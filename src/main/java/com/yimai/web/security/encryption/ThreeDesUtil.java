package com.yimai.web.security.encryption;

/**
 *  3DES 加密解密工具
 */
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ThreeDesUtil {
	private static ThreeDesUtil instance;
	private ThreeDesUtil() {
	}
	public static ThreeDesUtil getInstance() {
		if (instance == null) {
			instance = new ThreeDesUtil();
		}
		return instance;
	}
	
	/**
	 * 加密
	 * @param plaintext
	 * @return
	 */
	public String encrypt(String key, String iv, String plaintext) throws Exception {
			SecureRandom sr = new SecureRandom();
			DESedeKeySpec dks = new DESedeKeySpec(key.getBytes());
			Security.addProvider(new BouncyCastleProvider());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			SecretKey securekey = keyFactory.generateSecret(dks);
			IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
			Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS7Padding");
			cipher.init(Cipher.ENCRYPT_MODE, securekey, ivSpec, sr);
			return byte2hex(cipher.doFinal(plaintext.getBytes()));
	}
	
	private String byte2hex(byte[] b) {//二进制转字符串
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs;
	}
	
	/**
	 * 解密
	 * @param ciphertext
	 * @return
	 */
	public String decrypt(String key, String iv, String ciphertext) throws Exception  {
		SecureRandom sr = new SecureRandom();
		DESedeKeySpec dks = new DESedeKeySpec(key.getBytes());
		Security.addProvider(new BouncyCastleProvider());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey securekey = keyFactory.generateSecret(dks);
		IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS7Padding");
		cipher.init(Cipher.DECRYPT_MODE, securekey, ivSpec, sr);
		return new String(cipher.doFinal(hex2byte(ciphertext)));
	}
	
	private byte[] hex2byte(String str) { // 字符串转二进制
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1)
			return null;
		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		try{
			String key = "073188992648forenetf8ssc";
			String iv = "88888888";
			//加密
			String ciphertext = ThreeDesUtil.getInstance().encrypt(key, iv, "0");
			System.out.println(ciphertext);
			//解密
			String pwd = ThreeDesUtil.getInstance().decrypt(key, iv, ciphertext);
			System.out.println(pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
