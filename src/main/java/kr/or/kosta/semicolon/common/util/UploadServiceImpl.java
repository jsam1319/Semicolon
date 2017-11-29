package kr.or.kosta.semicolon.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.or.kosta.semicolon.image.domain.Image;

/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.common.util
 * @filename         UploadService.java
 * @author           김미소
 * @since            2017. 11. 13.
 * @see				 파일 업로드와 저장을 위한 컨트롤러
 *
 * == Modification Information (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 13.      김미소         최초 생성
 *
 *
 */

@Service
public class UploadServiceImpl implements UploadService {
	
	Logger logger = Logger.getLogger(UploadServiceImpl.class);
	
	private final static String UPLOAD_PATH = "/home/jaehyun/git/Semicolon/src/main/webapp/resources/images/";
	
	public String uploadFile(String originalName, byte[] fileData) throws Exception{
		
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(UPLOAD_PATH, savedName);
		FileCopyUtils.copy(fileData, target);                 //byte배열을 target으로 전송
		
		return savedName;
	}
	
	public String makeThumbnail(String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(UPLOAD_PATH, fileName));
		BufferedImage imgCopy = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,150);
		
		String thumbnailName = UPLOAD_PATH + "s_" + fileName;
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		File newFile = new File(thumbnailName);
		ImageIO.write(imgCopy, formatName, newFile);
		
		return thumbnailName.substring(UPLOAD_PATH.length()).replace(File.separatorChar, '/');
	}
	
	public void deleteFile(String originalName) throws Exception {
		File file = new File(UPLOAD_PATH, originalName);
		
		if(file.exists() == true) {
			file.delete();
		}
	}
	
	public String ckeditorInsert(Image image, HttpServletRequest request) throws Exception {
		
		String attachPath = "/home/jaehyun/git/Semicolon/src/main/webapp/resources/images/";
		String attachUrl = "http://localhost:8081/resources/images/";
		
		MultipartFile upload = image.getUpload();
		
		String originalFileName = "";
		
		if(upload != null) {
			
			originalFileName = upload.getOriginalFilename();
			
			File file = new File(attachPath+originalFileName);
			upload.transferTo(file);
			
		}
		
		String attachFile = attachPath + originalFileName;
		String url = attachUrl + originalFileName;
		
		logger.info("FileOriginalName : " + originalFileName);
		
		request.setAttribute("url", url);
		
		return null;
	}
	
	
}
	

