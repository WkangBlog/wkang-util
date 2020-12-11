package com.wkang.security;

import com.wkang.security.encrypt.md5.MD5Util;

public class KSecurityUtil {
	public static String getEncryptedPwd(String password) throws Exception{
		return MD5Util.getEncryptedPwd(password);
	}
	
	public static boolean validPassword(String password, String encpassword)throws Exception{
		return MD5Util.validPassword(password, encpassword);
	}
	
	public static String decode(String inStr)throws Exception{
		return MD5Util.convertMD5(MD5Util.convertMD5(inStr));
	}
}
