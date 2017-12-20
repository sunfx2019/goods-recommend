package com.yimai.web.security.encryption;

import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroMD5 {

	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
		String credentials = "1";
		int hashIterations = 1;
		Object obj = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
		System.out.println(obj);
	}

}
