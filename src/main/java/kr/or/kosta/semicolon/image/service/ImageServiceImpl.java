package kr.or.kosta.semicolon.image.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

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
		System.out.println(image);
		
		String feature = "";
		
		try {
			URL url = new URL("http://localhost:8000/polls/feature/");
			URLConnection con = url.openConnection();
			
			con.setDoOutput(true);
			String parameter = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(image.getAttachFile(), "UTF-8");

			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
			wr.write(parameter);
			wr.flush();  // 꼭 flush를 호출해야 한다.
			
			BufferedReader rd = null;

			rd = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line = null;
			
			while ((line = rd.readLine()) != null) {
			  feature = feature + line;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		image.setFeature(feature);
		dao.insert(image);
	}

}
