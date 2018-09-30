package kr.or.kosta.semicolon.member.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;

import org.apache.log4j.Logger;
import org.junit.Test;

import kr.or.kosta.semicolon.member.domain.Member;

/**
 * @packgename			kr.or.kosta.semicolon.member.util
 * @filename			RSAUtil.java
 * @author 				박주연
 * @since				2017. 11. 15.
 * @see					암호화, 복호화 처리
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE		  AUTHOR		 NOTE
 * --------		-----------	---------------------------------------
 * 2017. 11. 15		박주연		최초 생성
 *
 */

public class RSAUtil {
	KeyPairGenerator keyPairGenerator;
	KeyPair keyPair;
	Key publicKey;
	Key privateKey;
	KeyFactory keyFactory;
	Cipher cipher;
	Encoder encoder;
	Decoder decoder;

	//생성자
	public RSAUtil() {
		try {
			// 공개키 및 개인키 생성
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(1024);
			keyPair = keyPairGenerator.genKeyPair();
			publicKey = keyPair.getPublic(); // 공개키
			privateKey = keyPair.getPrivate(); // 개인키
			cipher = Cipher.getInstance("RSA");
			encoder = Base64.getEncoder();
            		decoder = Base64.getDecoder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPublicKey(String str) throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] bytes = decoder.decode(str);
		publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytes));
	}
	
	public void setPrivateKey(String str) throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] bytes = decoder.decode(str);
		privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytes));
	}
	
	public String getPublicEncoded() {
		return encoder.encodeToString(publicKey.getEncoded());
	}
	
	public String getPrivateEncoded() {
		return encoder.encodeToString(privateKey.getEncoded());
	}

	/**
     * <pre>
     * 1. 개       요  :   암호화
     * 2. 처 리 내 용  :   publicKey를 이용해 암호화를 한다. BASE64를 이용해 byte를 string 형으로 변한 한 뒤 반환한다. 
     * </pre>
     * @Method Name : encrypte
     * @param : inputStr   암호화할 문자	
     */
	public String encrypte(String inputStr) {
		String strCipher = null;

		try {
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] arrCipherData = cipher.doFinal(inputStr.getBytes()); 
			strCipher = encoder.encodeToString(arrCipherData);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return strCipher;
	}
	
	/**
     * <pre>
     * 1. 개       요  :   복호화
     * 2. 처 리 내 용  :   privateKey를 이용해 복호화한다. BASE64를 이용해 string를 byte[] 형으로 변한 한 뒤 반환한다.
     * </pre>
     * @Method Name : decrypte
     * @param : inputStr   복호화할 문자	
     */
	public String decrypte(String inputStr) {
		String strResult = null;
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] arrData = cipher.doFinal(decoder.decode(inputStr));
			strResult = new String(arrData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult; 
	}

}
