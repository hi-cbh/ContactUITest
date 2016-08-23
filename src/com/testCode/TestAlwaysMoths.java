package com.testCode;

import java.io.IOException;

import com.uitest.data.UserConfig;
import com.uitest.util.AlwaysMethod;
import com.uitest.util.UiAutomatorHelper;

public class TestAlwaysMoths extends AlwaysMethod{

	public static void main(String[] args) {
		String jarName = "TestAlwaysMoths";
		String testClass = "com.testCode.TestAlwaysMoths";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	
	
	public void testDemo1() throws IOException{
	
        // 启动App
        //Runtime.getRuntime().exec("am start com.chinamobile.contacts.im/.Main");
 
		home();
		
		clickText("和通讯录");
		
        //等等3秒
        sleep(3000);
        
        //点击屏幕中的文本
        clickText("和通讯录");
        clickText("设置");
        clickText("关于和通讯录");
        clickText("检查更新");

        sleep(5000);
        //验证页面是否存在资源id
        assertText("检查更新"); 
		
	}

}
