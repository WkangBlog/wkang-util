package com.wkang;

/**
 * 分割英语单词中的字母与数字工具类
 * @author Administrator
 *
 */
public class SplitsUtil {
	
	public static String getVersionNumber(String driverVersion){
		
		driverVersion = driverVersion.trim();
		String versionNumber = "";
		if (driverVersion != null && !"".equals(driverVersion)) {
			for (int i = 0; i < driverVersion.length(); i++) {
				if (driverVersion.charAt(i) >= 48 && driverVersion.charAt(i) <= 57) {
					versionNumber += driverVersion.charAt(i);
				}
			}

		}
	
		return versionNumber;
	}

	public static void main(String[] args) {
		System.out.println(getVersionNumber("v14"));
	}
}
