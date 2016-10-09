package com.uitest.contact430.testcase;

import com.contact.activity.GroupListActivity;
import com.contact.activity.v430.Setting430;
import com.contact.activity.v430.TabCall430;
import com.contact.activity.v430.TabConact430;
import com.uitest.data.UserConfig;
import com.uitest.readxml.ReadXml;
import com.uitest.util.UiAutomatorHelper;

/**
 * 和通讯录，android V4.2基本模块用例
 * 
 * @author Administrator
 * 
 */
public class ContacContactV430 extends SimpleCode430 {

	public static void main(String[] args) {
		String jarName = "ContacContactV430";
		String testClass = "com.uitest.contact430.testcase.ContacContactV430";
		String testName = "testCase_contact_002";
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
	 * 创建联系人
	 */
	public void testCase_contact_001() {
		String name = ReadXml.getContact().get(1).getName();
		String phone = ReadXml.getContact().get(1).getPhone();
		
		String name2 = ReadXml.getContact().get(2).getName();
		String phone2 = ReadXml.getContact().get(2).getPhone();
		
		String name3 = ReadXml.getContact().get(3).getName();
		String phone3 = ReadXml.getContact().get(3).getPhone();
		
		TabConact430 tct = new TabConact430();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);
		TabConact430.addContacts(name2, phone2);
		TabConact430.addContacts(name3, phone3);
		
		clickId("tab_contacts");
		assertText(name);
		assertText(name2);
		assertText(name3);
		
		clickId("tab_contacts");
		tct.clearContact();
	}
	

	/**
	 * 创建详细的联系人
	 */
	public void testCase_contact_002() {
		
		String name = ReadXml.getContact().get(2).getName();
		String phone = ReadXml.getContact().get(2).getPhone();
		String email = ReadXml.getContact().get(2).getEmail();
		int id = ReadXml.getContact().get(2).getId();
		
		TabCall430 tca = new TabCall430(); 
		TabConact430 tct = new TabConact430();
		
		clickId("tab_call");
		tca.deleteAllCall();

		//进入联系人模块
		clickId("tab_contacts");

		//点击创建
		clickId("iab_ib_action");
		
		//点击更多
		clickId("add_more_attribute");
		//选择邮箱
		clickText("邮箱");
		//输入内容
		inputTextByText("邮箱", email);
		
		//输入姓名
		inputTextByText("姓名", name);
		//输入号码
		inputTextByText("电话号码", phone);

		inputTextByText("我的备注", "id_"+id);
		
		//点击完成
		clickText("完成");
		sleep(2000);
		//返回主页
		back();
		
		clickId("tab_contacts");
		assertText(name);
		
		clickId("tab_contacts");
		tct.clearContact();

	}

	/**
	 * 进入联系人详情页 删除一个联系人 联系人详细页 - 删除联系人
	 */
	
	public void testCase_contact_003() {
		String name = ReadXml.getContact().get(3).getName();
		String phone = ReadXml.getContact().get(3).getPhone();
		
		
		TabConact430 tct = new TabConact430();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);
		
		//
		clickId("tab_contacts");
		
		//点击联系人
		clickId("contact_name");
		
		//进入更多
		clickText("更多");
		
		//点击更多
		clickId("iab_ib_more");
		
		clickText("删除联系人");
		clickText("删除");
		
		assertId("btResolve");

	}

	/**
	 * 输入搜索条件，获取联系人信息。 联系人列表 - 搜索本地联系人
	 */
	public void testCase_contact_004() {
		
		String name = ReadXml.getContact().get(4).getName();
		String phone = ReadXml.getContact().get(4).getPhone();
	
		String name2 = ReadXml.getContact().get(5).getName();
		String phone2 = ReadXml.getContact().get(5).getPhone();
		
		TabConact430 tct = new TabConact430();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);
		TabConact430.addContacts(name2, phone2);
		
		//点击搜索框
		clickId("contact_search_bar");
		
		//搜索联系人
		inputTextById("contact_search_bar", name);
		
		assertText(name);
		
		//搜索联系人
		inputTextById("contact_search_bar", phone);
		
		assertText(phone);	
		
		back();
		
		clickId("tab_contacts");
		tct.clearContact();

	}

	/**
	 * 创建联系人后，新增或修改联系人信息 联系人详细页 - 编辑
	 */
	public void testCase_contact_005() {
		
		String name = ReadXml.getContact().get(5).getName();
		String phone = ReadXml.getContact().get(5).getPhone();
		String phone2 = ReadXml.getContact().get(6).getPhone();
		
		
		TabConact430 tct = new TabConact430();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);

		//
		clickId("tab_contacts");
		
		//点击联系人
		clickId("contact_name");
		
		//进入更多
		clickText("更多");
		
		clickId("iab_ib_action");
		
		inputTextByText("电话号码", phone2);

		clickText("完成");
		

		back();
		
		//点击搜索框
		clickId("contact_search_bar");
		
		//搜索联系人
		inputTextById("contact_search_bar", phone2);
		
		assertText(name);
		
		back();
		
		clickId("tab_contacts");
		tct.clearContact();
	}

	/**
	 * 联系人详细页 - 收藏
	 */
	
	public void testCase_contact_006() {
		
		String name = ReadXml.getContact().get(6).getName();
		String phone = ReadXml.getContact().get(6).getPhone();
		
		TabConact430 tct = new TabConact430();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);

		assertBoolean(!isExistText("收藏联系人"));
		
		//
		clickId("tab_contacts");
		
		//点击联系人
		clickId("contact_name");
		
		//进入更多
		clickText("更多");
		
		clickId("iab_ib_action_ex");
		
		back();
		
		assertText("收藏联系人");
		
		clickId("tab_contacts");
		tct.deleteContactByName(name);
	}

	/**
	 * 新建联系人（屏幕下拉）
	 */
	
	public void testCase_contact_007() {
		
		String name = ReadXml.getContact().get(7).getName();
		String phone = ReadXml.getContact().get(7).getPhone();
		
		TabConact430 tct = new TabConact430();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		tct.swipeDownNewContact(name, phone);

		back();
		
		clickId("tab_contacts");
		
		assertText(name);
		clickId("tab_contacts");
		tct.clearContact();
	}

	/**
	 * 联系人-加入白名单
	 */
	public void testCase_contact_008() {
		String name = ReadXml.getContact().get(8).getName();
		String phone = ReadXml.getContact().get(8).getPhone();
		
		TabConact430 tct = new TabConact430();
		Setting430 st = new Setting430();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);

		clickId("tab_contacts");
		
		// 长按选择联系人
		longClickId("contact_name");

		// 点击
		clickText("加入白名单");

		// 进入管理白名单
		st.OpenTabMenu("防打扰", "白名单");


		// 检测当前界面为防打扰页
		assertText(phone);
		
		st.ClearBlack();
		// 清理
		tct.clearContact();
	}

	/**
	 * 联系人页-加入白名单
	 */
	
	public void testCase_contact_009() {
		String name = ReadXml.getContact().get(9).getName();
		String phone = ReadXml.getContact().get(9).getPhone();
		
		TabConact430 tct = new TabConact430();
		Setting430 st = new Setting430();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);

		clickId("tab_contacts");
		
		clickId("contact_name");
		
		clickText("更多");

		clickId("iab_ib_more");
		
		clickText("加入白名单");
		
		// 返回联系人页
		back();

		// 进入管理白名单
		st.OpenTabMenu("防打扰", "白名单");


		// 检测当前界面为防打扰页
		assertText(phone);
		
		st.ClearBlack();
		// 清理
		tct.clearContact();
	}

	
	/**
	 * 分组管理，创建分组并添加成员
	 */
	public void testCase_contact_010() {
		String name = ReadXml.getContact().get(10).getName();
		String phone = ReadXml.getContact().get(10).getPhone();

		
		String gname = ReadXml.getContact().get(100).getName();
		
		
		TabConact430 tct = new TabConact430();
		GroupListActivity gl = new GroupListActivity();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);

		clickText("我的分组");
		gl.clearGroup();

		// 创建分组，并留住当前页面
		gl.createGroup(gname);

		sleep(2000);
		
		//选择联系人
		clickId("contact_name");
		
		//确定
		clickId("selection_ok");
		
		sleep(2000);

		clickText(gname);
		
		assertText(name);
	
		back();
		
		gl.clearGroup();
		
		back();
		
		tct.clearContact();
	}


	/**
	 * 分组管理，添加成员
	 */
	public void testCase_contact_011() {
		String name = ReadXml.getContact().get(11).getName();
		String phone = ReadXml.getContact().get(11).getPhone();

		String name2 = ReadXml.getContact().get(12).getName();
		String phone2 = ReadXml.getContact().get(12).getPhone();
		
		String name3 = ReadXml.getContact().get(13).getName();
		String phone3 = ReadXml.getContact().get(13).getPhone();
		
		String name4 = ReadXml.getContact().get(14).getName();
		String phone4 = ReadXml.getContact().get(14).getPhone();

		String gname = ReadXml.getContact().get(101).getName();
		
		TabConact430 tct = new TabConact430();
		GroupListActivity gl = new GroupListActivity();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);
		TabConact430.addContacts(name2, phone2);
		TabConact430.addContacts(name3, phone3);
		TabConact430.addContacts(name4, phone4);

		clickText("我的分组");
		gl.clearGroup();

		// 创建分组，并留住当前页面
		gl.createGroup(gname);
		sleep(2000);
	
		//选择联系人
		clickId("contact_name");
		
		//确定
		clickId("selection_ok");
		
		sleep(2000);

		clickText(gname);
		
		sleep(2000);
		clickText("添加成员");
		
		sleep(1000);
		clickId("iab_ib_more");
		clickId("selection_ok");
		
		assertBoolean(getTextById("contact_search_hint_tv").contains("4人"));
		sleep(1000);
		back();
		
		gl.clearGroup();
		sleep(2000);
		back();
		
		tct.clearContact();
		sleep(2000);
	}

	/**
	 * 分组管理，移除成员
	 */
	public void testCase_contact_012() {
		
		String name = ReadXml.getContact().get(21).getName();
		String phone = ReadXml.getContact().get(21).getPhone();

		String name2 = ReadXml.getContact().get(22).getName();
		String phone2 = ReadXml.getContact().get(22).getPhone();
		
		String name3 = ReadXml.getContact().get(23).getName();
		String phone3 = ReadXml.getContact().get(23).getPhone();
		
		String name4 = ReadXml.getContact().get(24).getName();
		String phone4 = ReadXml.getContact().get(24).getPhone();

		String gname = ReadXml.getContact().get(108).getName();
		
		TabConact430 tct = new TabConact430();
		GroupListActivity gl = new GroupListActivity();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);
		TabConact430.addContacts(name2, phone2);
		TabConact430.addContacts(name3, phone3);
		TabConact430.addContacts(name4, phone4);

		clickText("我的分组");
		gl.clearGroup();

		// 创建分组，并留住当前页面
		gl.createGroup(gname);
		sleep(2000);
		
		clickId("iab_ib_more");
		//确定
		clickId("selection_ok");
		sleep(2000);

	
		clickText(gname);
		sleep(2000);
		
		clickText("移除成员");
		
		clickId("contact_name");
		
		clickId("mca_sure");
		clickText("移除");
		
		assertBoolean(getTextById("contact_search_hint_tv").contains("3人"));
		sleep(1000);
		back();
		
		gl.clearGroup();
		sleep(2000);
		back();
		
		tct.clearContact();
		sleep(2000);
	}
	
	
	
	/**
	 * 分组管理，重命名
	 */
	public void testCase_contact_013() {
		String name = ReadXml.getContact().get(31).getName();
		String phone = ReadXml.getContact().get(31).getPhone();
	
		String gname = ReadXml.getContact().get(113).getName();
		String gname2 = ReadXml.getContact().get(114).getName();
		
		TabConact430 tct = new TabConact430();
		GroupListActivity gl = new GroupListActivity();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);


		clickText("我的分组");
		gl.clearGroup();
		
		// 创建分组，并留住当前页面
		gl.createGroup(gname);
		sleep(2000);
		
		clickId("iab_ib_more");
		//确定
		clickId("selection_ok");
		sleep(2000);
		
		longClickText(gname);

		clickText("重命名分组");
		
		inputTextById("content",gname2);
		
		clickText("保存");
		
		assertText(gname2);
		sleep(1000);
		
		gl.clearGroup();
		sleep(2000);
		back();
		
		tct.clearContact();
		sleep(2000);
	}
	
	
	/**
	 * 分组管理，排序
	 */
	public void testCase_contact_014() {
		
		String name = ReadXml.getContact().get(14).getName();
		String phone = ReadXml.getContact().get(14).getPhone();

		
		String gname = ReadXml.getContact().get(114).getName();
		
		TabConact430 tct = new TabConact430();
		GroupListActivity gl = new GroupListActivity();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact430.addContacts(name, phone);

		clickText("我的分组");
		gl.clearGroup();
		
		// 创建分组，并留住当前页面
		gl.createGroup(gname);
		sleep(2000);
		
		clickId("iab_ib_more");
		//确定
		clickId("selection_ok");
		sleep(2000);
		
		//移动到末尾
		clickText("排序");
		gl.groupSort(gname, 2);
		clickText("保存");
		sleep(3000);
		assertBoolean(gl.getGroupRank(gname) == 6);

		//移动到第二位
		clickText("排序");
		gl.groupSort(gname, 1);
		clickText("保存");
		sleep(3000);
		assertBoolean(gl.getGroupRank(gname) == 2);
		
		sleep(1000);
		
		gl.clearGroup();
		sleep(2000);
		back();
		
		tct.clearContact();
		sleep(2000);
		
	}

	




}
