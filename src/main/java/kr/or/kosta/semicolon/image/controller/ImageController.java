package kr.or.kosta.semicolon.image.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.kosta.semicolon.common.util.UploadService;

@Controller
public class ImageController {

	@Inject
	UploadService uploadService;

	@RequestMapping(value="/image/search", method=RequestMethod.POST)
	public String imageSearch(MultipartFile image, Model model) throws Exception {
		
		String imageName = uploadService.uploadFile(image.getOriginalFilename(), image.getBytes());
		
		model.addAttribute("method", "post");
		model.addAttribute("imageName", imageName);
		
		return "/product/imageSearch";
	}
	
	@RequestMapping(value="/image/search", method=RequestMethod.GET)
	public String imageSearchUrl(String imageName, Model model) throws Exception {
		
		model.addAttribute("method", "get");
		model.addAttribute("imageName", imageName);
		
		return "/product/imageSearch";
	}
}
