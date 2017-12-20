package com.yimai.web.security.encryption;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Spring StandardPasswordEncoder 标准加密
 * 
 * @author sunfx
 *
 */
public class StandardPasswordEncoderUtil {

	private final static String DEFUALT_SECRET = "55311ED2C1E5E4C5E050007F010089E5";

	private final static StandardPasswordEncoder encode = new StandardPasswordEncoder(DEFUALT_SECRET);

	private StandardPasswordEncoderUtil(){
		
	}
	
	public static String encodePassword(CharSequence rawPassword) {
		return encode.encode(rawPassword);
	}

	public static boolean md5match(String rawPassword, String encodedPassword) {
		return encode.matches(rawPassword, encodedPassword);
	}

	public static void main(String[] args) {
		//String password = "1234567890";
		String password = "7147b7998be2fcb49e8a5d35972b1f2fbfa053ba38e75aa5a5207516279a1aeb4c40e15476b04011";
		String password_ = StandardPasswordEncoderUtil.encodePassword(password);
		System.out.println(password_.length());
		System.out.println(password_);
		System.out.println(StandardPasswordEncoderUtil.md5match(password, password_));
	}

}
