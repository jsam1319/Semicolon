package kr.or.kosta.semicolon.common.util;

import javax.servlet.http.HttpServletRequest;

import kr.or.kosta.semicolon.image.domain.Image;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.common.util
 * @filename         UploadService.java
 * @author           김미소
 * @since            2017. 11. 13.
 * @see
 *
 * == Modification Information (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 22.      김미소         최초 생성
 *
 *
 */
public interface UploadService {
	
	public String uploadFile(String originalName, byte[] fileData) throws Exception;
	
	public String makeThumbnail(String fileName) throws Exception;
	
	public void deleteFile(String originalName) throws Exception;
	
	public String ckeditorInsert(Image image, HttpServletRequest request) throws Exception;

}
