package kr.or.kosta.semicolon.image.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.image.domain
 * @filename         Image.java
 * @author           김미소
 * @since            2017. 11. 13.
 * @see				 Image테이블의 Domain클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 13.      김미소         최초 생성
 *
 *
 */
public class Image {
	
	private int imageNo;
	private int goodsNo;
	private String attachFile;
	private String CKEditorFuncNum;           // ckeditor 대상을 기억하기 위한 값 저장
	private MultipartFile upload;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(int imageNo, int goodsNo, String attachFile, String cKEditorFuncNum, MultipartFile upload) {
		super();
		this.imageNo = imageNo;
		this.goodsNo = goodsNo;
		this.attachFile = attachFile;
		CKEditorFuncNum = cKEditorFuncNum;
		this.upload = upload;
	}
	
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public int getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}
	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	@Override
	public String toString() {
		return "Image [imageNo=" + imageNo + ", goodsNo=" + goodsNo + ", attachFile=" + attachFile
				+ ", CKEditorFuncNum=" + CKEditorFuncNum + ", upload=" + upload + "]";
	}
	

	
	

}
