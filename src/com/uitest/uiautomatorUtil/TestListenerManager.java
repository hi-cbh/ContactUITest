package com.uitest.uiautomatorUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.net.ParseException;
import android.os.Bundle;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;

/**
 * 用于自动化监控，获取测试结果和日志
 * @author Administrator
 *
 */
public class TestListenerManager extends UiAutomatorTestCase{

	
	protected static final String ROOT_PATH="/mnt/sdcard/AppTestReport/";
	protected static final String DIR_NAME;//任务目录名
	protected static String sTestName;//测试用例名
	protected static String filePath;//保存用例测试信息文件名
	protected static String pngPath;//保存图像文件名
	protected static boolean isSaveReport2SD=true;//控制保存到SD卡报告的开关
	protected static TestListener listen;//监听
	private static int runtime_local = 0;
	
		

	//静态初始化目录  当然目录名可以从命令传入，保证每次任务结果在同一个目录下面
	static{
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"yyyyMMdd_HHmmss");
		long ctime = System.currentTimeMillis();
		DIR_NAME = formattime1.format(new Date(ctime));
	}

	@Override
	public void run(TestResult result) {
		Bundle bundle=getParams();
		String is2SD=bundle.getString("tosd");
		if(is2SD!=null&&is2SD.matches("true|false")){
			isSaveReport2SD=Boolean.valueOf(is2SD);
		}
		if(!isSaveReport2SD){
			super.run(result);
			return;
		}
		String testName = getName().toString();
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"MMdd_HHmmss");
		long ctime = System.currentTimeMillis();
		String time = formattime1.format(new Date(ctime));
		String dirPath=ROOT_PATH+DIR_NAME;
		sTestName=testName+"_"+time;
		filePath=dirPath+"/"+testName+"_"+time+".txt";
		pngPath=dirPath+"/"+testName+"_"+time+".png";
				
		try {
			Runtime.getRuntime().exec("mkdir "+ROOT_PATH);
			Runtime.getRuntime().exec("mkdir "+dirPath);
			Runtime.getRuntime().exec("touch "+filePath);	
	 }catch(Exception e){
		e.printStackTrace();
	 }
		listen=new listener(filePath,result);
		result.addListener(listen);	//加入监听者		
		super.run(result);
		
	}
	
	public class listener implements TestListener{
		PrintStream printTrace;	
		TestResult results;
		File ft;
		String testResult="P";
		Throwable trace;
		
		
		
		public listener(String filePath,TestResult result){
			this.results=result;
			ft=new File(filePath);
			try {

		        FileOutputStream fileOutputTrace = new FileOutputStream(ft,true);
		        printTrace = new PrintStream(fileOutputTrace); 
		 }catch(Exception e){
			e.printStackTrace();
		 }
			
		}
		

		@Override
		public void addError(Test arg0, Throwable arg1) {
			FileManager.saveFile("Error in "+arg0.getClass()+"#"+getName(), ft);
			arg1.printStackTrace(printTrace);
			File storePath=new File(pngPath);
			UiDevice.getInstance().takeScreenshot(storePath, 0.3f, 8);
			testResult="E";
			trace=arg1;
		}

		@Override
		public void addFailure(Test arg0, AssertionFailedError arg1) {
			FileManager.saveFile("Failure in "+arg0.getClass()+"#"+getName(), ft);
			arg1.printStackTrace(printTrace);
			File storePath=new File(pngPath);
			UiDevice.getInstance().takeScreenshot(storePath, 0.3f, 8);
			testResult="F";
			trace=arg1;
		}

		String startTime;
		String endTime;
		@Override
		public void endTest(Test arg0) {
			endTime=TimeUtil.getCurrentSysTimeLog();
			FileManager.saveFile("End Time:"+endTime, ft);
		    try {
				long d=TimeUtil.getTimeDistance(endTime, startTime);
				FileManager.saveFile("TotalTime:"+d+"ms", ft);
				FileManager.saveFile("PassTime:"+runtime_local+"ms", ft);

			} catch (ParseException e) {
				e.printStackTrace();
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		    				    		
			results.removeListener(listen);//结束移除监听
			
		}

		@Override
		public void startTest(Test arg0) {
			startTime=TimeUtil.getCurrentSysTimeLog();
			FileManager.saveFile("Start Time:"+startTime, ft);
		}
	}
	
	
	public void exec(String cmd){
		try {	
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
