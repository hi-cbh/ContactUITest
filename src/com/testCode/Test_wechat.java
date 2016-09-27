package com.testCode;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.contact.activity.v420.Setting420;
import com.contact.activity.v420.TabConact4_2;
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

	
	public void testCmdLine() {
		Setting420 st = new Setting420();
        st.ClearBackList();
	}
	   
}