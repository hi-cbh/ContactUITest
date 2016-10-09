package com.uitest.contact430.testcase;

import com.contact.activity.v430.Setting430;
import com.contact.activity.v430.TabCall430;
import com.contact.activity.v430.TabConact430;
import com.uitest.data.UserConfig;
import com.uitest.otherapk.OtherApk;
import com.uitest.readxml.ReadXml;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.UiAutomatorHelper;

/**
 * 和通讯录，android V4.3基本模块用例
 * 
 * @author Administrator
 * 
 */
public class ContactCallV430 extends SimpleCode430 {

	public static void main(String[] args) {
		String jarName = "ContactCallV430";
		String testClass = "com.uitest.contact430.testcase.ContactCallV430";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		openContact();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		exitApp();
	}
	
	
	/**
	 * 通话记录-陌生人-新建联系人 拨号盘中，创建联系人,输入号码，添加为联系人，并保存
	 */

	public void testCase_call_001() {

		String name = ReadXml.getContact().get(1).getName();
		String phone = ReadXml.getContact().get(1).getPhone();
		
		TabConact430 tco = new TabConact430();
		TabCall430 tca = new TabCall430(); 
		
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
		

		TabConact430 tco = new TabConact430();
		TabCall430 tca = new TabCall430(); 
		// 清理
		tco.clearContact();
		tca.deleteAllCall();
		
		clickId("tab_call");

		// 添加测试数据
		TabConact430.createContacts(name, phone);

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
		

		TabConact430 tco = new TabConact430();
		TabCall430 tca = new TabCall430(); 
		// 清理
		tco.clearContact();
		tca.deleteAllCall();
		
		clickId("tab_call");

		// 创建本地联系人
		TabConact430.createContacts(name, phone);

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
		
		//String name = ReadXml.getContact().get(4).getName();
		String phone = ReadXml.getContact().get(4).getPhone();
		

		TabConact430 tco = new TabConact430();
		TabCall430 tca = new TabCall430(); 
		Setting430 st = new Setting430();
		OtherApk oa = new OtherApk();
	
		// 清理
		tco.clearContact();

	
		//清理黑名单
		st.ClearBackList();
		
		clickId("tab_call");
		
		// 清空所有通话记录
		tca.deleteAllCall();

		// 添加数据
		oa.prepareUnreadCall(phone, 15, 3, 2);

		// 点击拨号详细记录
		clickId("call_detail");

		// 点击加入黑名单
		clickId("iab_ib_more");
		
		clickText("加入黑名单");

		sleep(2000);
		// 返回主界面
		back();
		sleep(1000);

		// 进入管理黑名单
		st.OpenTabMenu("防打扰", "黑名单");

		// 检测当前界面为防打扰页
		assertText(phone);
		
		st.ClearBlack();
		// 清理
		tca.deleteAllCall();
	}
	
	/**
	 * 1标记为广告推销且勾选加入黑名单 通话记录-陌生人-标记
	 */
	public void testCase_call_005() {
		//String name = ReadXml.getContact().get(5).getName();
		String phone = ReadXml.getContact().get(5).getPhone();

		TabCall430 tca = new TabCall430(); 
		OtherApk oa = new OtherApk();
		
		// 清空所有通话记录
		tca.deleteAllCall();

		// 添加数据
		oa.prepareUnreadCall(phone, 15, 3, 2);

		// 点击拨号详细记录
		clickId("call_detail");

		// 点击标记
		clickText("标记");

		// 广告推销
		clickText("广告推销");

		// 同时加入黑名单
		clickText("同时加入黑名单");

		// 点击确定
		clickText("确定");

		sleep(2000);

		//点击更多
		clickId("iab_ib_more");
		
		
		assertText("取消标记");
		assertText("取消黑名单");
		
		//点击更多
		clickId("iab_ib_more");
		clickText("取消标记");
		
		clickId("iab_ib_more");
		clickText("取消黑名单");
		
		back();
		
		// 清空所有通话记录
		tca.deleteAllCall();
	}
	
	
	/**
	 * 长按号码，将其添加到黑名单 拨号 - 更多操作- 加入黑名单（长按记录，选择加入黑名单）
	 */
	public void testCase_call_006() {
		//String name = ReadXml.getContact().get(6).getName();
		String phone = ReadXml.getContact().get(6).getPhone();

		TabCall430 tca = new TabCall430(); 
		Setting430 st = new Setting430();
		OtherApk oa = new OtherApk();
		
		// 清空所有通话记录
		tca.deleteAllCall();

		// 添加数据
		oa.prepareUnreadCall(phone, 15, 3, 2);

		// 长按号码
		longClickId("line1");
		

		clickText("加入黑名单");
		
		sleep(1000);

		// 进入管理黑名单
		st.OpenTabMenu("防打扰", "黑名单");

		// 检测当前界面为防打扰页
		assertText(phone);
		
		st.ClearBlack();
		// 清理
		tca.deleteAllCall();

	}
	
	/**
	 * 添加IP拨号，选择17951 拨号 - 更多操作 - IP拨号-选择已有的前缀
	 */
	public void testCase_call_007() {
		//String name = ReadXml.getContact().get(7).getName();
		String phone = ReadXml.getContact().get(7).getPhone();

		TabCall430 tca = new TabCall430(); 

		OtherApk oa = new OtherApk();
		
		clickId("tab_call");
		// 清空所有通话记录
		tca.deleteAllCall();

		// 添加数据
		oa.prepareUnreadCall(phone, 15, 3, 2);

		// 长按号码
		longClickId("line1");
		
		// 点击IP拨号
		clickText("IP拨号");
		
		clickText("17951");
		
		//没有网络是点击确定
		sleep(8000);
		// 点击点击确定
		clickText("确定");

		clickId("tab_call");
		
		assertMessage("line1","17951" );
		// 清空所有通话记录
		tca.deleteAllCall();

	}
	
	/**
	 * 添加IP拨号，添加自定义前缀 拨号 - 更多操作 - IP拨号-选择手动添加的前缀
	 */
	public void testCase_call_008() {
		
		//String name = ReadXml.getContact().get(8).getName();
		String phone = ReadXml.getContact().get(8).getPhone();

		TabCall430 tca = new TabCall430(); 

		OtherApk oa = new OtherApk();
		
		clickId("tab_call");
		// 清空所有通话记录
		tca.deleteAllCall();

		// 添加数据
		oa.prepareUnreadCall(phone, 15, 3, 2);

		// 长按号码
		longClickId("line1");
		
		// 点击IP拨号
		clickText("IP拨号");
		

		// 判断是否存在多个自定义前缀
		if (isExistId("del_voip_phone")) {
			// 点击清除
			clickId("del_voip_phone");

			// 点击删除
			clickText("删除");

			// 长按号码
			longClickId("line1");

			// 点击IP拨号
			clickText("IP拨号");

		}

		// 点击添加前缀号码
		clickId("add_voip_phone");

		// 输入内容
		inputTextById("content", "138438");

		// 点击确定
		clickText("确定");

		//没有网络是点击确定
		sleep(8000);

		// 点击点击确定
		clickText("确定");

		clickId("tab_call");
		
		assertMessage("line1","138438" );
		
		sleep(2000);
		
		// 清空所有通话记录
		tca.deleteAllCall();

	}
	
	/**
	 * 拨打本地联系人号码 拨号- 拨打本地联系人
	 */
	public void testCase_call_009() {
		String name = ReadXml.getContact().get(9).getName();
		String phone = ReadXml.getContact().get(9).getPhone();

		TabCall430 tca = new TabCall430(); 
		TabConact430 tct = new TabConact430();
		
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
		
		// 准备数据，创建联系人
		TabConact430.createContacts(name, phone);
		
		clickId("tab_call");
		// 点击拨号
		tca.displaykeyboardCall();
		
		// 点击输入框
		clickId("digits");

		// 点击键盘数字
		tca.touchCallNumber(phone);

		// 点击搜索记录，
		clickId("listview_rl");

		sleep(8000);
		// 点击确定
		clickText("确定");

		clickId("tab_call");
		
		assertMessage("line1",name );

		sleep(2000);
		
		// 清空拨号记录
		tct.clearContact();
		tca.deleteAllCall();

	}

	/**
	 * 本地联系人通话记录，加入白名单 拨号 - 加入白名单
	 */
	public void testCase_call_010() {
		String name = ReadXml.getContact().get(10).getName();
		String phone = ReadXml.getContact().get(10).getPhone();

		TabCall430 tca = new TabCall430(); 
		TabConact430 tct = new TabConact430();
		Setting430 st = new Setting430();
		OtherApk oa = new OtherApk();
		
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
		
		clickId("tab_contacts");
		// 准备数据，创建联系人
		TabConact430.createContacts(name, phone);
		
		clickId("tab_call");
		oa.prepareUnreadCall(phone, 15, 3, 2);
		
		// 点击拨号详细记录
		clickId("call_detail");

		// 点击加入白名单
		clickId("iab_ib_more");
		clickText("加入白名单");

		// 返回主界面
		back();

		// 进入管理白名单
		st.OpenTabMenu("防打扰", "白名单");

		assertText(name);

		sleep(1000);

		st.ClearBlack();

		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
	}
	
	/**
	 * 拨号修改编辑 通话记录-本地联系人-编辑
	 */
	public void testCase_call_011() {
		String name = ReadXml.getContact().get(11).getName();
		String phone = ReadXml.getContact().get(11).getPhone();
		String phone2 = ReadXml.getContact().get(2).getPhone();

		TabCall430 tca = new TabCall430(); 
		TabConact430 tct = new TabConact430();
		OtherApk oa = new OtherApk();
		
		
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
		
		// 准备数据，创建联系人
		TabConact430.createContacts(name, phone);
		
		oa.prepareUnreadCall(phone, 15, 3, 2);
		
		clickId("tab_call");
		
		// 点击拨号详细记录
		clickId("call_detail");
		
		// 点击编辑
		clickId("iab_ib_action");

		inputTextByText("电话号码", phone2);

		// 点击保存
		clickText("完成");

		sleep(2000);

		// 返回拨号页
		back();

		tca.displaykeyboardCall();

		// 点击输入框
		clickId("digits");

		// 点击键盘数字
		tca.touchCallNumber(phone2);

		assertMessage("number", phone2);
		
		sleep(2000);
		
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();

	}
	
	
	/**
	 * 拨号页，删除联系人 通话记录-本地联系人-删除联系人
	 */
	
	public void testCase_call_012() {
		String name = ReadXml.getContact().get(12).getName();
		String phone = ReadXml.getContact().get(12).getPhone();

		TabCall430 tca = new TabCall430(); 
		TabConact430 tct = new TabConact430();
		OtherApk oa = new OtherApk();
		
		
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
		
		// 准备数据，创建联系人
		TabConact430.createContacts(name, phone);
		
		oa.prepareUnreadCall(phone, 15, 3, 2);
		
		clickId("tab_call");
		
		// 点击拨号详细记录
		clickId("call_detail");

		// 点击删除联系人
		clickId("iab_ib_more");
		clickText("删除联系人");

		// 点击删除
		clickText("删除");

		// 切换到联系人页
		clickId("tab_contacts");

		//删除成功
		assertId("check_declaration");
		
		// 进入拨号
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();

	}

	/**
	 * 通话记录-未接来电页-最新记录显示标识-列表顶部
	 */
	public void testCase_call_013(){

		String name = ReadXml.getContact().get(13).getName();
		String phone = ReadXml.getContact().get(13).getPhone();
		String phone2 = ReadXml.getContact().get(3).getPhone();

		TabCall430 tca = new TabCall430(); 
		TabConact430 tct = new TabConact430();
		OtherApk oa = new OtherApk();
		
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
		
		// 准备数据，创建联系人
		TabConact430.createContacts(name, phone);
		
		oa.prepareUnreadCall(phone, 15, 3, 2);
		
		oa.prepareUnreadCall(phone2, 15, 3, 1);

		
		clickId("tab_call");
		//判断是否含有标记
		assertBoolean(ElementManager.getChildCountByIdClass("listview_rl", "ImageView") == 2);
		
		sleep(2000);
		
		// 进入拨号
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
	
	}

	
	/**
	 * 通话记录-未接来电页-最新记录显示标识-点击后消失
	 */
	public void testCase_call_014(){
		String name = ReadXml.getContact().get(14).getName();
		String phone = ReadXml.getContact().get(14).getPhone();
		String phone2 = ReadXml.getContact().get(4).getPhone();
		
		TabCall430 tca = new TabCall430(); 
		TabConact430 tct = new TabConact430();
		OtherApk oa = new OtherApk();
		
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
		
		// 准备数据，创建联系人
		TabConact430.createContacts(name, phone);
		
		oa.prepareUnreadCall(phone, 15, 3, 2);
		oa.prepareUnreadCall(phone2, 15, 3, 2);
		
		clickId("tab_call");
		
		//判断是否含有标记
		assertId("tvStrangeMark");
		
		
		clickId("tvStrangeMark");
		
		back();
		
		//判断是否含有标记
		assertBoolean(!isExistId("tvStrangeMark"));
		
		sleep(2000);
		
		// 进入拨号
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
	}
	

}
