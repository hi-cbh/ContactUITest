package com.testCode;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.commandline.Command;
import com.uitest.data.UserConfig;
import com.uitest.error.WatcherError;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.UiAutomatorHelper;


public class Test_wechat extends UiAutomatorTestCase
{
	public static void main(String[] args) {
		String jarName = "Test_wechat";
		String testClass = "com.testCode.Test_wechat";
		String testName = "testCmdLine";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	
	public void testCmdLine() throws UiObjectNotFoundException{
		
		 UiObject uo = ElementManager.getUiObjectByResourceId("com.sec.android.app.launcher:id/home_softkey_apps_button");
		
		WatcherError.registerCall();
		
		Command.callPhone("10086");
        //用例
       
        pressBack();

        uo.click();
        sleep(2000);
        
        pressBack();
        sleep(2000);
        
	}
	   
	
	public void pressBack(){
		UiDevice.getInstance().pressBack();
	}
}