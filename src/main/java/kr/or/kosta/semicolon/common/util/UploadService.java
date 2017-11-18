package kr.or.kosta.semicolon.common.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.image.controller
 * @filename         UploadController.java
 * @author           김미소
 * @since            2017. 11. 13.
 * @see				 파일 업로드와 저장을 위한 컨트롤러
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 13.      김미소         최초 생성
 *
 *
 */

@Service
public class UploadService {
	
	Logger logger = Logger.getLogger(UploadService.class);
	
	private final static String UPLOAD_PATH = "C:/Users/kosta/git/Semicolon/src/main/webapp/resources/images/";
	
	public String uploadFile(String originalName, byte[] fileData) throws Exception{
		File target = new File(UPLOAD_PATH, originalName);
		FileCopyUtils.copy(fileData, target);                 //byte배열을 target으로 전송
		
		return originalName;
	}
	
	public static String makeThumbnail(String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(UPLOAD_PATH, fileName));
		BufferedImage imgCopy = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,130);
		
		String thumbnailName = UPLOAD_PATH + "s_" + fileName;
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		File newFile = new File(thumbnailName);
		ImageIO.write(imgCopy, formatName, newFile);
		
		return thumbnailName.substring(UPLOAD_PATH.length()).replace(File.separatorChar, '/');
	}
	

}
