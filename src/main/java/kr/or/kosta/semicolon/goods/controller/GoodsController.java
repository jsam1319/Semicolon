package kr.or.kosta.semicolon.goods.controller;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.semicolon.bottom.domain.Bottom;
import kr.or.kosta.semicolon.bottom.service.BottomService;
import kr.or.kosta.semicolon.common.util.UploadService;
import kr.or.kosta.semicolon.common.util.UploadServiceImpl;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.domain.TakeAllThings;
import kr.or.kosta.semicolon.goods.service.GoodsService;
import kr.or.kosta.semicolon.image.domain.Image;
import kr.or.kosta.semicolon.image.service.ImageService;
import kr.or.kosta.semicolon.keyword.domain.Keyword;
import kr.or.kosta.semicolon.keyword.service.KeywordService;
import kr.or.kosta.semicolon.tops.domain.Tops;
import kr.or.kosta.semicolon.tops.service.TopsService;
//복구중..
/**
 * @packgename   kr.or.kosta.semicolon.goods.controller
 * @filename         GoodsController.java
 * @author          전세종
 * @since            2017. 11. 10.
 * @see					상품관리를 위한 Controller
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 10.      kosta         최초 생성
 *
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	Logger logger = Logger.getLogger(GoodsController.class);
	
	@Inject
	GoodsService goodsService;
	
	@Inject
	TopsService topsService;
	
	@Inject
	BottomService bottomService;
	
	@Inject
	KeywordService keywordService;
	
	@Inject
	UploadService uploadService;
	
	@Inject
	ImageService imageService;
	
	
	/**
	 * <pre>
	 * 1. 개      요 : goods view method
	 * 2. 처리내용 : 상품 정보를 가지고 goods view로 이동하는 메소드
	 * </pre>
	 * @Method Name : goods
	 * @param model : 상품 정보를 저장하기 위한 model
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Goods> goods(Model model) {
		
		return goodsService.allList();
	}
	
	
	@RequestMapping(value = "/goods", method = RequestMethod.POST)
	public String success(Goods goods, RedirectAttributes rttr) {
		
		//goodsService.insert(goods);
		rttr.addFlashAttribute("result", "SUCCESS");
		
		return null;
	}
	

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public void insert(Goods goods) {
		logger.info("상품등록페이지요청..GET");
	}
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개      요 : 상품등록 메소드
	 * 2. 처리내용 : 상품등록하면서 동시에 사이즈(상의 or 하의), 키워드, 이미지, 컬러 등록
	 * </pre>
	 * @Method Name : insert
	 * @param all
	 * @return, Bottom bottom, Keyword keyword, Image image
	 */
	@Transactional
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(TakeAllThings all, HttpServletRequest request) {
		logger.info("상품등록..POST");
		
		// 상품 등록
		Goods goods = new Goods();
		goods = all.getGoods();
		goodsService.insert(goods);
		
		int goodsNo = goods.getGoodsNo();
		int length = all.getTypes().length;
		
		// 상품이 상의일 경우
		if(all.getSleeveLength() != null) {
			
			Tops tops = new Tops();
			tops.setGoodsNo(goodsNo);
			
			for (int i=0; i<length; i++) {
				
				tops.setTypes(all.getTypes()[i]);
				tops.setSizes(all.getSizes()[i]);
				tops.setSleeveLength(all.getSleeveLength()[i]);
				tops.setFullLength(all.getFullLength()[i]);
				
				topsService.insert(tops);
				
			}
			
		// 상품이 하의일경우
		}else if(all.getHip() != null) {
			
			Bottom bottom = new Bottom();
			bottom.setGoodsNo(goodsNo);
			
			for(int i=0; i<length; i++) {
				
				bottom.setTypes(all.getTypes()[i]);
				bottom.setSizes(all.getSizes()[i]);
				bottom.setWaist(all.getWaist()[i]);
				bottom.setRise(all.getRise()[i]);
				bottom.setHip(all.getHip()[i]);
				bottom.setThigh(all.getThigh()[i]);
				bottom.setFullLength(all.getFullLength()[i]);
				
				bottomService.insert(bottom);
			}
			
		}
		
		// 키워드 등록
		String[] kewords = all.getKeywordName();
		
		Keyword keyword = new Keyword();
		keyword.setGoodsNo(goodsNo);
		
		for (int i = 0; i < kewords.length; i++) {
			
			keyword.setKeywordName(all.getKeywordName()[i]);
			
			keywordService.insert(keyword);
		}
		
		//이미지 등록
		String[] images = all.getAttachFile();
		
		Image image = new Image();
		image.setGoodsNo(goodsNo);
		
		for (int i = 0; i < images.length; i++) {
			image.setAttachFile(images[i]);
			
			imageService.insert(image);
		}
		
		return "redirect:/";
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개      요 : 상품 등록 View에서 Front Image, Toggle Image의 썸네일을 보여주기 위한 메소드
	 * 2. 처리내용 : UploadService 통해 이미지 업로드 후 썸네일 생성
	 * </pre>
	 * @Method Name : insert
	 * @param file
	 * @param model
	 * @return "/resources/images/"+thumbnail (thumbnail이미지 경로)
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/upload", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String insert(MultipartFile file, Model model) throws Exception {
		logger.info("파일 이름:" + file.getOriginalFilename());
		
		String savedName = uploadService.uploadFile(file.getOriginalFilename(), file.getBytes());
		String thumbnail = uploadService.makeThumbnail(savedName);
		
		model.addAttribute("savedName", savedName);
		model.addAttribute("thumbnail", thumbnail);
		
		logger.info("저장 이름:" + savedName);
		
		return "/resources/images/"+thumbnail;
		
	}
	/**
	 * 
	 * <pre>
	 * 1. 개      요 : CKEditor에서 업로드 기능 생성
	 * 2. 처리내용 : 업로드하려는 파일 경로 가져온 후 반환
	 * </pre>
	 * @Method Name : ckeditorInsert
	 * @param image
	 * @param model
	 * @param request
	 * @return 업로드 이미지 경로를 포함한 script
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/ckupload", method=RequestMethod.POST)
	public String ckInsert(Image image, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		uploadService.ckeditorInsert(image, request);
		
		//uploadService.imageUpload(request, response, image);
		
		String url = (String)request.getAttribute("url");
		
		return "<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction('" + image.getCKEditorFuncNum() + "','" + url + "', 'Complete to Upload Image!') </script>";
	}
	
	
}
