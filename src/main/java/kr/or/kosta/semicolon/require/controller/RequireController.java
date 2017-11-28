package kr.or.kosta.semicolon.require.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.common.util.UploadService;
import kr.or.kosta.semicolon.require.domain.Require;
import kr.or.kosta.semicolon.require.service.RequireService;

/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.require.controller
 * @filename         RequireController.java
 * @author           김미소
 * @since            2017. 11. 24.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 24.       4         최초 생성
 *
 *
 */
@Controller
@RequestMapping(value="/require")
public class RequireController {
	
	Logger logger = Logger.getLogger(RequireController.class);
	
	@Inject
	RequireService requireService;
	
	@Inject
	UploadService uploadService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(){
		logger.info("결제 후 list 컨트롤러.. GET");
		
		return "/require/insert2";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		logger.info("공구요청 컨트롤러.. GET");
		
		return "/require/insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(Require require, HttpServletRequest request) {
		logger.info("공구요청 컨트롤러.. POST");
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		
		require.setMemberNo(memberNo);
		
		requireService.insert(require);
		
		return "redirect:/require/list";         
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(){
		logger.info("공구요청 list 컨트롤러.. GET");
	}
	
	@ResponseBody
	@RequestMapping(value="/list/{page}", method=RequestMethod.POST)
	public List<Require> list(@PathVariable("page") int page){
		logger.info("공구요청 list 컨트롤러.. POST");
		List<Require> list;
		
		list = requireService.listAll(page);
		System.out.println(list);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/modal/{requireNo}", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String readOne(@PathVariable("requireNo")int requireNo) {
		logger.info("modal-- 컨트롤러 ReadOne... ");
		
		Require require = new Require();
		
		require = requireService.readOne(requireNo);
		
		JSONObject obj = new JSONObject();
		obj.put("title", require.getTitle());
		obj.put("regdate", require.getRegdate());
		obj.put("price", require.getPrice());
		obj.put("company", require.getCompany());
		obj.put("content", require.getContent());
		obj.put("image", require.getImage());
		obj.put("requireNo", require.getRequireNo());
		obj.put("comments", require.getComments());
		
		String jsonStr = obj.toJSONString();
		
		return jsonStr;
	}
	
	@ResponseBody
	@RequestMapping(value="/reply/{requireNo}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public Require insert(@PathVariable("requireNo")int requireNo, @RequestBody Require require) {
		logger.info("modal--  컨트롤러 Reply... update");
		
		require.setRequireNo(requireNo);
		requireService.update(require);
		
		require = requireService.readOne(requireNo);
		
		return require;
	}
	
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
	
}
