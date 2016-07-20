package com.uitest.contact.testcase;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.TestContactBase;
import com.uitest.util.UiAutomatorHelper;
import com.contact.activity.*;

public class TestBack  extends TestContactBase {
	public static void main(String[] args) {
		String jarName = "TestBack";
		String testClass = "com.uitest.contact.testcase.TestBack";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	
	
	public void testCase_001() throws RemoteException {
		String  name = "tab_contacts";
		System.out.println("[start] back");
		int i = 0;
		for (; i < 7; i++) {
			//首页
			if(MainActivity_contact.rootFloor()){
				ElementManager.clickById(name);
				ElementManager.clickById(name);
				//sleep(500);
				System.out.println("[ end ] back");
				return;
			}else if(!MainActivity_contact.notRootFloor() || !MainActivity_contact.settingPage() || !MainActivity_contact.searchPage()) {
				//返回上一层
				System.out.println("notRootFloor or settingPage or searchPage");
				UiDevice.getInstance().pressBack();
				sleep(500);
			}
			//弹窗
			else if(MainActivity_contact.isPopup() && ElementManager.getViewTextById("title").equals("短信发送失败")){
				//取消
				ElementManager.clickById("dialog_btn_negative");
			}
			else if(MainActivity_contact.isPopup()){
				//确定
				ElementManager.clickById("dialog_btn_positive");				
			}
			else{
				ElementManager.clickById("tab_contacts");
				
				sleep(2000);
				
				ElementManager.clickById("tab_call");
			}
			//不在首层
			sleep(500);
		}
	}
	
}
