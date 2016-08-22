package com.uitest.contact.testcase;

import junit.framework.Assert;
import com.contact.activity.MainActivity_contact;
import com.uitest.data.UserConfig;
import com.uitest.log.MyLogcatHelper;
import com.uitest.uiautomatorUtil.AssertUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.TestContactBase;
import com.uitest.util.UiAutomatorHelper;

import android.os.RemoteException;

public class CloudCard extends TestContactBase {

	public static void main(String[] args) {
		String jarName = "CloudCard";
		String testClass = "com.uitest.contact.testcase.CloudCard";
		String testName = "testDemo_002";
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
		
		//判断
		AssertUtil.Myassert("云名片运行期间发生错误", ElementManager.isExistById("iab_title"), "CloudCard");	
	}
	
	/**
	 *  1、本地联系人有3000人以上，安装后，进入联系人整理页，页面显示整理中，点击返回。
	 *	2、画面卡住后，点击物理返回按无反应。
	 *	3、等待15秒左右，弹出和通讯录已停止。
	 *	【预期结果】
	 *	整理中点击返回，弹出提示
	 * @throws RemoteException
	 */
	public void testDemo_002()throws RemoteException{
		
		System.out.println("testCase_002........");

		//返回
		MainActivity_contact.back("tab_contacts");
		
		//点击更多按钮
		ElementManager.clickById("iab_ib_more");
		
		//点击联系人整理
		ElementManager.clickByName("联系人整理");
		
		
		for(int i = 0; i <=2; i++)
		{
			if(ElementManager.isExistById("iab_back_area")){
				DriverManager.pressBack();
			}
			sleep(1000);
		}
		
		
		//放弃
		if(ElementManager.isExistById("dialog_btn_positive"))
		{
			ElementManager.clickById("dialog_btn_positive");
		}
		
		//返回
		MainActivity_contact.back("tab_contacts");
		
		
		//判断
		AssertUtil.Myassert("联系人整理运行期间发生错误", ElementManager.isExistById("iab_title"), "ContactOrganize");	
		
		
	}
	
	public void testDemo(){
		System.out.println("testDemo.......");
		
		
		Assert.assertEquals("testdemo", false, true);
	}
	
	
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		//exitApp();
	}
}
