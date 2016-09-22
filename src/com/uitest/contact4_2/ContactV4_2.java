package com.uitest.contact4_2;
import java.util.List;

import com.contact.activity.v420.TabCall4_2;
import com.contact.activity.v420.TabConact4_2;
import com.uitest.data.UserConfig;
import com.uitest.util.UiAutomatorHelper;

/**
 * 和通讯录，android V4.2基本模块用例
 * 
 * @author Administrator
 * 
 */
public class ContactV4_2 extends SimpleCode420 {

	public static void main(String[] args) {
		String jarName = "ContactV4_2";
		String testClass = "com.uitest.contact4_2.ContactV4_2";
		String testName = "testCase_call_001";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		openContact();
	}

	/**
	 * 通话记录-陌生人-新建联系人 拨号盘中，创建联系人,输入号码，添加为联系人，并保存
	 */

	public void testCase_call_001() {

		TabConact4_2 tco = new TabConact4_2();
		TabCall4_2 tca = new TabCall4_2(); 
		// 清理
		tco.clearContact();
		tca.deleteAllCall();
		
		clickId("tab_call");

		// 点击拨号
		clickId("tab_call");

		// 点击联系人
		clickId("tab_contacts");

		// 点击拨号
		clickId("tab_call");

		// 点击输入框
		clickId("digits");

		// 点击键盘数字
		tca.touchCallNumber("13822138001");

		// 点击添加为联系人
		clickText("添加为联系人");

		// 添加新建联系人
		clickText("新建联系人");

		//输入姓名
		inputTextById("edit_contact_name", "saveAsContact");

		// 点击保存
		clickId("iab_ib_action");

		sleep(2000);

		back();

		sleep(2000);

		//进入联系人模块
		clickId("tab_contacts");
		//点击搜索框
		clickId("contact_search_bar");
		//搜索联系人
		inputTextById("contact_search_bar", "13822138001");
		//如果联系人存在，则删除，否则返回
		assertId("13822138001");
		
		// 清理
		tco.clearContact();
		tca.deleteAllCall();
	}
	
	
	
	/**
	 * 手势滑动侧边栏与拨号页、联系人、信息切换。
	 */
	public void testCase_other_001() {
		// 返回
		home("tab_contacts");
		for (int i = 0; i < 8; i++) {
			swipeToRight();
			sleep(1000);
			swipeToLeft();
			sleep(1000);
		}
		// 判断当前界面存在和通讯录标题
		assertId("iab_title");

		clickId("tab_call");
		for (int i = 0; i < 8; i++) {
			swipeToRight();
			sleep(1000);
			swipeToLeft();
			sleep(1000);
		}
		// 判断当前界面存在和通讯录标题
		assertId("iab_title");

		clickId("tab_mms");
		for (int i = 0; i < 8; i++) {
			swipeToRight();
			sleep(1000);
			swipeToLeft();
			sleep(1000);
		}
		// 判断当前界面存在和通讯录标题
		assertId("iab_title");
	}

	/**
	 * 验证侧边栏切换
	 */
	public void testCase_other_002() {
		int i;
		int num;
		for (i = 0; i < 20; i++) {
			num = (int) (Math.random() * 10) % 5;
			switch (num) {
			case 4:
				// 点击拨号
				clickId("tab_call");
				// sleep(1000);
				break;

			case 3:
				// 点击联系人
				clickId("tab_contacts");
				// sleep(1000);
				break;

			case 2:
				// 点击信息
				clickId("tab_mms");
				// sleep(1000);
				break;

			case 1:
				// 点击生活助手
				clickId("tab_cloud");
				// sleep(1000);
				break;

			case 0:
				// 点击和通讯录
				clickId("iab_title");
				// sleep(1000);

				// 点击返回
				back();
				sleep(1000);
				break;
			}

		}

		assertId("iab_title");
	}

	
	/**
	 * 
	 */
	public void testLogin(){
		
	}
	
	
	
	/**
	 * 创建联系人
	 */
	public void testCase_001() {
		//进入联系人模块
		clickId("tab_contacts");
		//点击搜索框
		clickId("contact_search_bar");
		//搜索联系人
		inputTextById("contact_search_bar", "13543493854");
		//如果联系人存在，则删除，否则返回
		if(isExistId("contact_name")){
			longClickId("contact_icon");
			clickText("删除");
			clickText("删除");
		}
		else{
			clickId("contact_search_del_btn");
		}

		//点击创建
		clickId("iab_ib_action");
		//输入姓名
		inputTextById("edit_contact_name", "陈壁画");
		//输入号码
		inputTextByText("电话号码", "13543493854");
		//点击完成
		clickText("完成");
		sleep(2000);
		//返回主页
		back();
	
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		exitApp();
	}
}
