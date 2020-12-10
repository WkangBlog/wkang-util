package com.wkang.security;



import com.wkang.security.encrypt.md5.MD5Util;

import java.text.ParseException;


public class SecurityUtil {
	public static String getEncryptedPwd(String password) throws Exception{
		return MD5Util.getEncryptedPwd(password);
	}
	
	public static boolean validPassword(String password, String encpassword)throws Exception{
		return MD5Util.validPassword(password, encpassword);
	}
	
	public static String decode(String inStr)throws Exception{
		return MD5Util.convertMD5(MD5Util.convertMD5(inStr));
	}

	public static void main(String[] args) throws ParseException {	
		String phone = "123456";
		try {
			System.out.println(getEncryptedPwd(phone));
			System.out.println(decode("601szo"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
