package com.uitest.contact.testcase;


import java.io.File;

import com.android.uiautomator.core.UiDevice;
import com.contact.activity.MainActivity_contact;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.AssertUtil;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.TestContactBase;
import com.uitest.util.UiAutomatorHelper;

import android.os.RemoteException;

public class CloudCard extends TestContactBase {

	public static void main(String[] args) {
		String jarName = "CloudCard";
		String testClass = "com.uitest.contact.testcase.CloudCard";
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
		1、进入【我的名片】页面，点击页面名片信息
		2、点击右上角【编辑】按钮
		3、进入【名片编辑】页面，弹出提示“和通讯录已停止”
	 * @throws RemoteException
	 */
	public void testCase_001() throws RemoteException {
		//点击头像
		ElementManager.clickById("avatar_im");
		
		sleep(5000);
		
		//点击编辑
		ElementManager.clickById("iab_ib_action");
		
		sleep(10000);
		
		//点击完成
		ElementManager.clickById("iab_tv_finish");
		
		sleep(5000);
		
		//返回
		MainActivity_contact.back("tab_contacts");
		

		AssertUtil.Myassert("运行失败", ElementManager.isExistById("iab_title"), "CloudCard");	
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		//exitApp();
	}
}
