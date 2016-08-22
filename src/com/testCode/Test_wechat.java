package com.testCode;


import java.io.IOException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.AssertUtil;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.uiautomatorUtil.ElementManagerLog;
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

    
    public void testDemo() throws IOException, UiObjectNotFoundException {
  
        // 启动App
        Runtime.getRuntime().exec("am start com.chinamobile.contacts.im/.Main");
 
        //等等3秒
        sleep(3000);
        
        //通过“名称”点击
        ElementManagerLog.clickByName("和通讯录");
        ElementManagerLog.clickByName("设置");
        ElementManagerLog.clickByName("关于和通讯录");
        ElementManagerLog.clickByName("检查更新");

        AssertUtil.Myassert("没有找到元素", ElementManager.isExistByName("按住拍"), "testDemo");
    }
    
    public void testDemo1() throws IOException, UiObjectNotFoundException {
    	  
        // 启动App
        Runtime.getRuntime().exec("am start com.chinamobile.contacts.im/.Main");
        
        sleep(3000);

        //通过“名称”点击
        ElementManagerLog.clickByName("和通讯录");
        ElementManagerLog.clickByName("设置");
        ElementManagerLog.clickByName("通话设置");

        //验证
        AssertUtil.Myassert("没有找到", ElementManager.isExistByName("一键拨号设置"), "testDemo1");

    }
        
}