package com.wkang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PhoneFormatCheckUtils {
	///**
	 //* 大陆号码和香港号码均可
	 //*/
	public static boolean isPhoneLegal(String str) throws PatternSyntaxException{
		return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
	}
	

	 //* 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数   13 14  15 16 17 18
	//* 此方法中前三位格式有：
	//* 13+任意数
	//* 15+除4的任意数
	//* 18+除4的任意数
	//* 16+任意数
	//* 17+除9的任意数
	//* 147

	private static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException{
		String regExp = "^((13[0-9]|15[^4]|18[0-9]|16[0-9]|17[0-8]|147))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}
	//**
	//* 香港手机号码8位数，5|6|8|9开头+7为任意数
	//*/
	private static boolean isHKPhoneLegal(String str) throws PatternSyntaxException{
		String regExp = "^(5|6|8|9)\\d{7}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isPhoneLegal("18135154963"));
	}
}
