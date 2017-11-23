package kr.or.kosta.semicolon.image.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.image.dao.ImageDao;
import kr.or.kosta.semicolon.image.domain.Image;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Inject
	ImageDao dao;

	@Override
	public void insert(Image image) {
		dao.insert(image);
	}

}
