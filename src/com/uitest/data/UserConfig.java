package com.uitest.data;

public class UserConfig {

	//运行前需要提前手动创建一下目录，否则运行错误(部分android手机没权限创建目录)
	public static String saveRootPath = "/mnt/sdcard/AppTestReport/";    //运行记录及app日志
	public static String savePicPath = "/mnt/sdcard/AppTestReportPic/"; //运行错误时截图
	public static String saveLogPath = "/mnt/sdcard/AppTestReportLog/"; //系统运行日志
	public static String saveAppLogPath = "/mnt/sdcard/AppTestReportAppRunLog/";
	
	//全局参数
	public static boolean isWriteLog = true; //是否写入app运行日志，默认为关闭
	
	
	//登录账号
	public static String LoginName = "13427665104";
	public static String LoginPwd = "yscs12345";

	//根据每台PC的不同，进行调整
	public static String androidId = "2";
	public static String packageName = "com.chinamobile.contacts.im";
	
	
}
