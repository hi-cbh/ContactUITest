package com.uitest.contact4_2;

import com.contact.activity.v420.Setting420;
import com.contact.activity.v420.TabCall4_2;
import com.contact.activity.v420.TabConact4_2;
import com.uitest.data.UserConfig;
import com.uitest.readxml.ReadXml;
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
		String testName = "testCase_call_004";
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

		String name = ReadXml.getContact().get(1).getName();
		String phone = ReadXml.getContact().get(1).getPhone();
		
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
		tca.touchCallNumber(phone);

		// 点击添加为联系人
		clickText("添加为联系人");

		// 添加新建联系人
		clickText("新建联系人");

		//输入姓名
		inputTextById("edit_contact_name", name);

		// 点击保存
		clickText("完成");

		sleep(2000);

		back();

		sleep(2000);

		//进入联系人模块
		clickId("tab_contacts");
		//点击搜索框
		clickId("contact_search_bar");
		//搜索联系人
		inputTextById("contact_search_bar", phone);
		//如果联系人存在，则删除，否则返回
		
		assertId("contact_icon");
		
		// 清理
		tco.clearContact();
		tca.deleteAllCall();
	}
	
	
	/**
	 * 通话记录-陌生人-添加到已有联系人 添加为已有联系人
	 */
	public void testCase_call_002() {
		
		String name = ReadXml.getContact().get(2).getName();
		String phone = ReadXml.getContact().get(2).getPhone();
		

		TabConact4_2 tco = new TabConact4_2();
		TabCall4_2 tca = new TabCall4_2(); 
		// 清理
		tco.clearContact();
		tca.deleteAllCall();
		
		clickId("tab_call");

		// 添加测试数据
		TabConact4_2.createContacts(name, phone);

		// 点击拨号
		clickId("tab_call");

		// 点击联系人
		clickId("tab_contacts");

		// 点击拨号
		clickId("tab_call");

		// 点击输入框
		clickId("digits");

		// 点击键盘数字
		tca.touchCallNumber("84850922");

		// 点击添加为联系人
		clickText("添加为联系人");

		// 添加新建联系人
		clickText("添加到已有联系人");


		clickId("contact_icon");
		
		// 点击保存
		clickText("完成");
		
		sleep(2000);
		
		back();
		
		//进入联系人模块
		clickId("tab_contacts");
		//点击搜索框
		clickId("contact_search_bar");
		//搜索联系人
		inputTextById("contact_search_bar", "84850922");
		//如果联系人存在，则删除，否则返回
		
		assertId("contact_icon");

		// 清理
		tco.clearContact();
		tca.deleteAllCall();
	}

	

	/**
	 * 拨号盘 -搜索本地联系人（按拼音或号码搜索） 本地联系人检测
	 */
	public void testCase_call_003() {
		
		String name = "通讯录";
		String phone = "13800138000";
		

		TabConact4_2 tco = new TabConact4_2();
		TabCall4_2 tca = new TabCall4_2(); 
		// 清理
		tco.clearContact();
		tca.deleteAllCall();
		
		clickId("tab_call");

		// 创建本地联系人
		TabConact4_2.createContacts(name, phone);

		// 点击拨号
		clickId("tab_call");

		// 点击联系人
		clickId("tab_contacts");

		// 点击拨号
		clickId("tab_call");

		// 点击输入框
		clickId("digits");

		// 点击键盘数字
		tca.touchCallNumber("138001");

		//验证
		assertText(name);
		
		// 清空输入框内容
		longClickId("btn_backspace");

		// 点击键盘数字
		tca.touchCallNumber("001380");

		assertText(name);

		// 清空输入框内容
		longClickId("btn_backspace");

		// 点击键盘数字
		tca.touchCallNumber("138000");

		assertText(name);

		// 清空输入框内容
		longClickId("btn_backspace");

		// 点击键盘数字,tongx转化为键盘数字为86649
		tca.touchCallNumber("86649");

		assertText(name);

		// 清空输入框内容
		longClickId("btn_backspace");

		// 点击键盘数字,txl转化为键盘数字为895
		tca.touchCallNumber("895");

		assertText(name);

		// 清空输入框内容
		longClickId("btn_backspace");

		// 点击键盘数字,xunlu转化为键盘数字为98658
		tca.touchCallNumber("98658");

		assertText(name);

		// 清空输入框内容
		longClickId("btn_backspace");

		sleep(3000);

		// 清理
		tco.clearContact();

	}
	
	/**
	 * 将拨号记录中一号码添加到黑名单 通话记录-陌生人-加入黑名单（详细页，选择加入黑名单）
	 */
	public void testCase_call_004() {
		
		String name = ReadXml.getContact().get(4).getName();
		String phone = ReadXml.getContact().get(4).getPhone();
		

		TabConact4_2 tco = new TabConact4_2();
		TabCall4_2 tca = new TabCall4_2(); 
		Setting420 st = new Setting420();
		
		// 创建本地联系人
		TabConact4_2.createContacts(name, phone);
		// 清理
		tco.clearContact();

		clickId("tab_call");

		// 进入管理黑名单
		st.OpenTabMenu("防打扰", "黑名单");
		
		//是否存在
		if (isExistId("iab_ib_action")) {
			// 点击清空
			clickId("iab_ib_action");

			// 点击清空
			clickText("清空");
		}

		// 返回主界面
		back();
		back();
		back();
		back();

		clickId("tab_call");
		
		// 清空所有通话记录
		tca.deleteAllCall();

		// 添加数据
		tca.touchCallNumber("13813881499");

		// 点击拨号详细记录
		clickId("call_detail");

		// 点击加入黑名单
		//clickMenuAndSelect(4);

		// 返回主界面
		back();
		sleep(1000);

//		// 进入管理黑名单
//		st.OpenTabMenu("防打扰", "黑名单");
//
//		// 检测当前界面为防打扰页
//		Myassert("没有进入黑名单管理页", driver.findElementByName("管理黑名单").isDisplayed());
//
//		boolean bl = searchContact("13813881499", 0);
//
//		// 检测当前是否存储骚扰电话
//		// Assert.assertTrue(bl);
//		Myassert("黑名单中，没有找到该联系人：13813881499", bl);
//
//		sleep(1000);
//
//		// 清空数据
//		if (bl) {
//			// 点击清空
//			clickById("iab_ib_action");
//
//			// 点击清空
//			clickById("dialog_btn_positive");
//		}
//		// 返回主界面
//		back("tab_call");
//
//		// 清理
//		tca.deleteAllCall();
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
