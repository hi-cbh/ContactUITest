package com.testCode;


import java.io.IOException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.data.UserConfig;
import com.uitest.log.UiautomatorAssistant;
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

    UiautomatorAssistant uiautomatorAssistant ;
    
    public void testDemo() throws IOException, UiObjectNotFoundException {
        
        uiautomatorAssistant = new UiautomatorAssistant(getUiDevice());
        
        // 启动App
        Runtime.getRuntime().exec("am start com.chinamobile.contacts.im/.Main");
        
        sleep(3000);
        
        /*----------------------- 验证第一种小视频的打开方式------------------------------------*/
        uiautomatorAssistant.ClickByText("和通讯录");
        
        uiautomatorAssistant.ClickByText("设置");
        
        uiautomatorAssistant.ClickByText("关于和通讯录");
        
        uiautomatorAssistant.ClickByText("检查更新");
        
        
        UiObject obj_anzhupaiObject = new UiObject(new UiSelector().text("按住拍"));
        if (obj_anzhupaiObject.exists())
        {
            uiautomatorAssistant.UiAutomationLog( "第一次进入小视频的方法测试通过");
        }
        else {
            uiautomatorAssistant.TakeScreen("第一次进入小视频的方法测试不通过");
        }
        
    }
        
}