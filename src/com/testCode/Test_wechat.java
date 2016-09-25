package com.testCode;

import java.io.IOException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.data.UserConfig;
import com.uitest.util.UiAutomatorHelper;


public class Test_wechat extends UiAutomatorTestCase
{
	public static void main(String[] args) {
		String jarName = "Test_wechat";
		String testClass = "com.testCode.Test_wechat";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	
	public void testCmdLine(){
		cmdLine("am start -a android.intent.action.CALL -d tel:1008611");
		
		cmdLine("am stop -a android.intent.action.CALL");
		
	}
	
	
	
    public void cmdLine(String cmd){
    	try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

        
}