package com.wkang.network.entity;

public class ReturnCode {
	public static final String SUCCESS = "0000";// 成功
	public static final String LIMIT = "1111";
	public static final String FAIL = "2222";// 失败
	public static final String REPEAR = "3333";// 重复
	public static final String DEPRECATED = "4444";// 过时
	public static final String DBERROR = "5555";// 数据库执行错误
	public static final String PARAM_ERROR = "6666";// 参数错误
	public static final String DB_NOTFIND = "7777";// 未找到
	public static final String Register = "8888";
	public static final String PERMISSIONFAIL = "9999";
	public static final String PARAM_TRANS_ERROR = "6667";//参数转换错误
	public static final String EXCUT_EMPTY = "5556";//未执行任何操作
	public static final String DATA_NOTFIND = "1404";//数据不存在
	public static final String DATA_DELETE = "1405";//数据已删除
	public static final String DATA_MATCH_CONDITION_ERROR = "1406";//数据条件匹配失败
	public static final String PWD_ERROR = "1407";//密码错误
	public static final String SEND_VCODE_FAIL = "2001";//验证码不匹配
	public static final String SEND_VCODE_TIMEOUT = "2002";//验证码超时
	public static final String USE_TRIVIAL = "4001";//使用频率高
}
