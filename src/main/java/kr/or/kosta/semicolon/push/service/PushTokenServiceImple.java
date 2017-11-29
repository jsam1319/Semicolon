package kr.or.kosta.semicolon.push.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.push.domain.PushToken;


@Service
public class PushTokenServiceImple implements PushTokenService {
	
	Logger logger = Logger.getLogger(PushTokenServiceImple.class);
	

	@Override
	public void pushToken(PushToken token) throws Exception {
		
		logger.info("message서비스 들어옴");
		logger.info(token);
		
		final String apiKey = "AAAAwTbSbDI:APA91bH-OnvyR7ufaBOQa-JV9-Jm-x0BAORTX9blgU3NaLGqcuotgVhkxUqWRLhoCxlmlr0fQVkfOZgYFJ6_KuqZCrmeZVImS3HKb3brtz9bnzxLyQ6vcRkwYHlnRl07suwg8_jvKUQo";
		
		URL url = new URL("https://fcm.googleapis.com/fcm/send");
		
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "key=" + apiKey);
        
        con.setDoOutput(true);
        
        String input = "{\"data\" : {\"title\" : \"" + token.getTitle() + " \", \"body\" : \"" + token.getMessage() + "\"}, \"to\":\"" + token.getPushToken() + "\"}";
        
        OutputStream os = con.getOutputStream();
        
        os.write(input.getBytes("UTF-8"));
        os.flush();
        os.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        
        in.close();

	}

}
