package com.testCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.net.ParseException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.uiautomatorUtil.ImageManager;
import com.uitest.uiautomatorUtil.TimeUtil;
import com.uitest.util.UiAutomatorHelper;

public class MyUIauto extends UiAutomatorTestCase{
	
	

	public static void main(String[] args) {
		String jarName = "MyUIauto";
		String testClass = "com.testCode.MyUIauto";
		String testName = "testImage";
		String androidId = "2";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	
	
	public void testPressHome() throws UiObjectNotFoundException, ParseException, java.text.ParseException {
		UiDevice.getInstance().dumpWindowHierarchy("email.xml");
		UiDevice.getInstance().dumpWindowHierarchy("heloo.xml");
//		
//		System.out.println("start");
//		String startime = getCurrentSysTime();
//		String endtime,tmpTime; 
//		long runtime,tmpRunTime;
//		
//		endtime = getCurrentSysTime();
//		runtime =  getTimeDistance(endtime , startime);
//		
//		//sleep(5000);
//		UiDevice.getInstance().openNotification();
//		//等待页面切换
//		UiObject uo = new UiObject(new UiSelector().resourceIdMatches(".*title_bar_mail_list"));
//		uo.waitUntilGone(2000);
//		
//		System.out.println("start");
//		File file = new File("/data/local/tmp/local/tmp/email.xml");
//		String realPath = "email.xml";
//		boolean bl = false;
//		
//		do{
//			UiDevice.getInstance().dumpWindowHierarchy(realPath);
//			bl = ReadTxtFile("/data/local/tmp/local/tmp/email.xml","Email");
//			
//			if(bl){
//				break;
//			}
//			tmpTime = getCurrentSysTime();
//			tmpRunTime =  getTimeDistance(tmpTime , startime);
//			
//		}while(tmpRunTime <= 10000);
//		
//		endtime = getCurrentSysTime();
//		runtime =  getTimeDistance(endtime , startime);
//		
//		if(bl){
//			
//			System.out.println("找到内容：" + bl+", runTime: " + runtime);
//		}else{
//			System.out.println("找不到内容：" + bl+", runTime: " + runtime);
//		}
	}
	
	public void testImage(){
		//ImageManager.snapshot("testImage", "有点水印");
		ImageManager.snapshotLine("testImageLine");
	}
	
	
	
	
	
	/**
	 * 检测通知栏中是否含有某些字段。
	 * <br/>缺点：
	 * <br/>1、如果运行过快，无法获取
	 * <br/>2、测试前必须清除状态栏中的通知或推送消息（*）
	 * @param uo      原有界面的任一控件
	 * @param findStr 查找的字符串
	 * @param MaxTime 最大等待时间(ms; 1s = 1000ms)
	 */
	public void checkNotification(UiObject uo, String findStr, long MaxTime){

		System.out.println("start");
		String startime = TimeUtil.getCurrentSysTime();
		String endtime,tmpTime; 
		long runtime,tmpRunTime;
		
		try {
			//sleep(5000);
			UiDevice.getInstance().openNotification();
			//等待页面切换
			uo.waitUntilGone(2000);
			
			System.out.println("start");
			File file = new File("/data/local/tmp/local/tmp/email.xml");
			String realPath = "email.xml";
			boolean bl = false;
			
			do{
				UiDevice.getInstance().dumpWindowHierarchy(realPath);
				bl = ReadTxtFile("/data/local/tmp/local/tmp/email.xml",findStr);
				
				if(bl){
					break;
				}
				tmpTime = TimeUtil.getCurrentSysTime();
				tmpRunTime =  TimeUtil.getTimeDistance(tmpTime , startime);
				
			}while(tmpRunTime <= MaxTime);
			
			endtime = TimeUtil.getCurrentSysTime();
			runtime =  TimeUtil.getTimeDistance(endtime , startime);
			
			if(bl){
				
				System.out.println("找到内容：" + bl+", runTime: " + runtime);
			}else{
				System.out.println("找不到内容：" + bl+", runTime: " + runtime);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	
	
	
	//读取文本文件中的内容
    @SuppressWarnings("resource")
	public static boolean ReadTxtFile(String strFilePath,String text)
    {
        String path = strFilePath;
        //String content = ""; //文件内容字符串
            //打开文件
            File file = new File(path);
            //如果path是传递过来的参数，可以做一个非目录的判断
            if (file.isDirectory())
            {
            	System.out.println("The File doesn't not exist.");
            	return false;
            }
            else
            {
                try {
                    InputStream instream = new FileInputStream(file); 
                    if (instream != null) 
                    {
                        InputStreamReader inputreader = new InputStreamReader(instream);
                        BufferedReader buffreader = new BufferedReader(inputreader);
                        String line;
                        //分行读取
                        while (( line = buffreader.readLine()) != null) {
                           // content += line + "\n";
                            if(line.contains(text)){
                            	
                            	instream.close();
                            	//System.out.println("true");
                            	return true;
                            }
                        }                
                        instream.close();
                    }
                }
                catch (java.io.FileNotFoundException e) 
                {
                	e.printStackTrace();
                } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            }
            System.out.println("false");
            return false;
    }
    
}
