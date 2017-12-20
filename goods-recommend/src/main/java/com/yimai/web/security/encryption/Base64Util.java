package com.yimai.web.security.encryption;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {

	/**
	 * Base64解密
	 * 
	 * @param plainText
	 * @return
	 */
	public static String encodeStr(String plainText) {
		byte[] b = plainText.getBytes();
		Base64 base64 = new Base64();
		b = base64.encode(b);
		return new String(b);
	}

	/**
	 * 
	 * Base64加密
	 */
	public static String decodeStr(String encodeStr) {
		byte[] b = encodeStr.getBytes();
		Base64 base64 = new Base64();
		b = base64.decode(b);
		return new String(b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "12345";
		String encodeStr = encodeStr(str);
		System.out.println(encodeStr);
		System.out.println(decodeStr(encodeStr));
	}

}
