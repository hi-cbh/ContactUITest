package com.uitest.contact.testcase;


import com.contact.activity.MainActivity_contact;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.TestContactBase;
import com.uitest.util.UiAutomatorHelper;

import android.os.RemoteException;

public class TestCaseContact extends TestContactBase {

	public static void main(String[] args) {
		String jarName = "CardEditor";
		String testClass = "com.uitest.contact.testcase.TestCaseContact";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		openContact();
		
		// 点击和通讯录
		ElementManager.clickById("iab_title");
		//判断是否为登录状态，否，登录账号
		if(!isLoginState()){
			//返回
			MainActivity_contact.back("tab_contacts");
			//退出
			Logout();
			Login(UserConfig.LoginName,UserConfig.LoginPwd);
		}
		
	}
	
	/**
	 * 登录时延，和通讯录
	 * @throws RemoteException
	 */
	public void testCase_001() throws RemoteException {
		//点击流量充值文案
		ElementManager.clickById("llBalance");
		
		//点击刷新
		ElementManager.clickById("iab_ib_action");
		
		sleep(5000);
		//返回
		MainActivity_contact.back("tab_contacts");
		
		
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		//exitApp();
	}
}
