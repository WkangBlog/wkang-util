package com.wkang;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringHelper {
	public static String replaceNull(String from){
		return (from==null || "".equals(from))?"":from;
	}
	
	public static String replaceNull(String from,String to){
		return (from==null || "".equals(from))?to:from;
	}
	
	/**
	 * 判断一个字符串是否不为null或""，如果为null或空则返回false，反之true
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str)
	{
		boolean isnotnull = false;
		if(str != null && !"".equals(str.trim()))
		{
			isnotnull = true;
		}
		return isnotnull;
	}
	
	public static String transStr(String str)
	{
		String aus = "";
		String auarr [] = str.split(",");
		for(int i=0;i<auarr.length;i++)
		{
			aus += "'"+auarr[i]+"',";
		}
		if(aus.length() > 0)
			aus=aus.substring(0,aus.length()-1);
		return aus;
	}
	
	public static Integer getPageCount(int count, Integer pageSize) {
		Integer pageCount = 0;
		if (count % pageSize == 0){
			pageCount = count / pageSize;
		}else{
			pageCount = count / pageSize + 1;
		}
		return pageCount;
	}
	
	 /** 
	 * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集） 
	 * @param str 
	 *            待转换字符串 
	 * @return 转换后字符串 
	 * @throws UnsupportedEncodingException 
	 *             exception 
	 */  
	public static String emojiConvert(String str)  
	        throws UnsupportedEncodingException {  
	    String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";  
	  
	    Pattern pattern = Pattern.compile(patternString);  
	    Matcher matcher = pattern.matcher(str);  
	    StringBuffer sb = new StringBuffer();  
	    while(matcher.find()) {  
	        try {  
	            matcher.appendReplacement(  
	                    sb,  
	                    "[["  
	                            + URLEncoder.encode(matcher.group(1),  
	                                    "UTF-8") + "]]");  
	        } catch(UnsupportedEncodingException e) {  
	            throw e;  
	        }  
	    }  
	    matcher.appendTail(sb);  
	    return sb.toString();  
	}
	
	/** 
	 * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串 
	 * @param str 
	 *            转换后的字符串 
	 * @return 转换前的字符串 
	 * @throws UnsupportedEncodingException 
	 *             exception 
	 */  
	public static String emojiRecovery(String str)  
	        throws UnsupportedEncodingException {  
	    String patternString = "\\[\\[(.*?)\\]\\]";  
	  
	    Pattern pattern = Pattern.compile(patternString);  
	    Matcher matcher = pattern.matcher(str);  
	  
	    StringBuffer sb = new StringBuffer();  
	    while(matcher.find()) {  
	        try {  
	            matcher.appendReplacement(sb,  
	                    URLDecoder.decode(matcher.group(1), "UTF-8"));  
	        } catch(UnsupportedEncodingException e) {  
	            throw e;  
	        }  
	    }  
	    matcher.appendTail(sb);   
	    return sb.toString();  
	}  

	/**
	  * java生成随机数字和字母组合
	  * @param length 生成随机数的长度
	  * @return
	  */
	 public static String getCharAndNumr(int length) {
	  String val = "";
	  Random random = new Random();
	  for (int i = 0; i < length; i++) {
	   // 输出字母还是数字
	   String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; 
	   // 字符串
	   if ("char".equalsIgnoreCase(charOrNum)) {
	    // 取得大写字母还是小写字母
	    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; 
	    val += (char) (choice + random.nextInt(26));
	   } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
	    val += String.valueOf(random.nextInt(10));
	   }
	  }
	  return val.toUpperCase();
	 }

	
	public static void main(String [] args)
	{
		//String s = "CREATE TABLE tb_userinfo AS SELECT * FROM tb_user WHERE userid = '{userid}'; SELECT * FROM tb_userinfo";
		//String s1= "{userid}";
		//String s2= "ADMIN";
		//s=s.replace(s1, s2);
		//System.out.println(s);
		//String s = "p1,日期,4,0,0000000000000,A:选项A;B:选项B";
		//System.out.println(s.split("\\|")[0]);
		//String s1 = " select * from tb_user";
		//String s2 = " create table tb_userinfo as select * from tb_user";
		//System.out.println(s1.trim().toUpperCase().indexOf("SELECT"));
		//System.out.println(DateHelper.getNowTime("yyyyMM")+" :: "+DateHelper.getNowTime("yyMM")+" :: "+DateHelper.getNowTime("yyyy-MM-dd")+" :: "+DateHelper.getNowTime("yyyy-MM-dd HH:mm:ss")+" :: "+
				//DateHelper.getPreviousMonthFirst()+" :: "+DateHelper.getPreviousMonthEnd()+" :: "+DateHelper.getLastMonth("yyMM")+" :: "+DateHelper.getLastMonth("yyyyMM"));
	
		//String s = "{key:'2',value:'friendone'},{key:'0',value:'ff'}";
		//s = s.replace("},{", "}|{");
		//System.out.println(s);
		//String s1 = s.split("\\|")[0];
		//String s2 = s.split("\\|")[1];
		//System.out.println(s1);
		//System.out.println(s2);
		/*String [] paramarr = {"{sys_loginno}","{sys_loginorgcode}",
				"{sys_YYYYMM}","{sys_YYMM}","{sys_YYYY-MM-DD}","{sys_datatime}",
				"{sys_lastmonthfd}","{sys_lastmonthed}","{sys_lmYYMM}","{sys_lmYYYYMM}"};

		String [] paramvalarr = {"ADMIN","N",
		DateHelper.getNowTime("yyyyMM"),DateHelper.getNowTime("yyMM"),DateHelper.getNowTime("yyyy-MM-dd"),DateHelper.getNowTime("yyyy-MM-dd HH:mm:ss"),
		DateHelper.getPreviousMonthFirst(),DateHelper.getPreviousMonthEnd(),DateHelper.getLastMonth("yyMM"),DateHelper.getLastMonth("yyyyMM")};

		String s = "SELECT * FROM tb_user WHERE userid = '{sys_loginno}';";
		
		for(int i=0;i<paramarr.length;i++)
		{
			s=s.replace(paramarr[i],paramvalarr[i]);
		}*/
//		String sysurl = "{ip}";
//		sysurl =sysurl.replace("{ip}", "dsfdsfdsfdsa");
//		System.out.println("aaaaaaaaaaaaa\r\naaaaaaaaaaaaa");
//		System.out.println(sysurl);
		
		System.out.println(getCharAndNumr(26));
	}
}
