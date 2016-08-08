package com.uitest.contact.testcase;


import junit.framework.Assert;

import com.contact.activity.MainActivity_contact;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.TestContactBase;
import com.uitest.util.UiAutomatorHelper;

import android.os.RemoteException;

public class CardEditor extends TestContactBase {

	public static void main(String[] args) {
		String jarName = "CardEditor";
		String testClass = "com.uitest.contact.testcase.CardEditor";
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
	 * 【测试步骤与结果】
		 场景一：
		1、点击云名片下话费余额文案，进入查询充值界面，点击刷新按钮
		2、刷新后，点击返回按钮，返回到侧边栏页，弹出“和通讯录已停止”提示框
		 场景二：
		1、点击生活助手-搜索框，进入搜索页，点击中国移动选项
		2、在搜索期间，快速连续点击返回按钮，返回到侧边栏页，弹出“和通讯录已停止”提示框
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
