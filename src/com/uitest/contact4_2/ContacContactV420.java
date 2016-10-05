package com.uitest.contact4_2;

import com.contact.activity.GroupListActivity;
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
public class ContacContactV420 extends SimpleCode420 {

	public static void main(String[] args) {
		String jarName = "ContacContactV420";
		String testClass = "com.uitest.contact4_2.ContacContactV420";
		String testName = "testCase_contact_010";
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
		
		TabConact4_2 tct = new TabConact4_2();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact4_2.addContacts(name, phone);
		TabConact4_2.addContacts(name2, phone2);
		TabConact4_2.addContacts(name3, phone3);
		
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
		
		TabCall4_2 tca = new TabCall4_2(); 
		TabConact4_2 tct = new TabConact4_2();
		
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
		
		
		TabConact4_2 tct = new TabConact4_2();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact4_2.addContacts(name, phone);
		
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
		
		TabConact4_2 tct = new TabConact4_2();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact4_2.addContacts(name, phone);
		TabConact4_2.addContacts(name2, phone2);
		
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
		
		
		TabConact4_2 tct = new TabConact4_2();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact4_2.addContacts(name, phone);

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
		
		TabConact4_2 tct = new TabConact4_2();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact4_2.addContacts(name, phone);

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
		
		TabConact4_2 tct = new TabConact4_2();
		
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
		
		TabConact4_2 tct = new TabConact4_2();
		Setting420 st = new Setting420();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact4_2.addContacts(name, phone);

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
		
		TabConact4_2 tct = new TabConact4_2();
		Setting420 st = new Setting420();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact4_2.addContacts(name, phone);

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
		
		
		TabConact4_2 tct = new TabConact4_2();
		GroupListActivity gl = new GroupListActivity();
		
		clickId("tab_contacts");
		tct.clearContact();
		
		// 准备数据，创建联系人
		TabConact4_2.addContacts(name, phone);

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


//	/**
//	 * 分组管理，添加成员
//	 */
//	public void testCase_contact_016() {
//		startTestCase();
//		// 清空数据
//		clearGroup();
//
//		deleteAllContacts();
//
//		// 创建联系人
//		createContacts("testCase0_contact_016", "13522068037");
//		createContacts("testCase1_contact_016", "13521168037");
//		createContacts("testCase2_contact_016", "13521268037");
//		createContacts("testCase3_contact_016", "13522368037");
//		createContacts("testCase4_contact_016", "13521468037");
//		createContacts("testCase5_contact_016", "13521568037");
//		createContacts("testCase6_contact_016", "13521668037");
//
//		// 创建分组，分组添加联系人
//		// 不添加联系人
//		createGroup("TestGroup0_37", 1);
//		// 添加1个联系人
//		createGroup("TestGroup1_37", 1);
//		// 添加2个联系人
//		createGroup("TestGroup2_37", 1);
//		// 添加所有联系人
//		createGroup("TestGroup3_37", 1);
//
//		// 添加完后，判断未分组的联系人数量是否为0
//
//		// 添加1个联系人
//		addGroupMembers("TestGroup1_37", 1);
//
//		// 添加2个联系人
//		addGroupMembers("TestGroup2_37", 2);
//
//		
//		// 添加7个联系人
//		addAllGroupMembers("TestGroup3_37");
//
//		// 进入我的分组
//		intoMyGroupPage();
//
//		List<WebElement> list = this.getWebElementList("TextView",
//				"groupNumber");
//
//		Myassert("分成成员数量有异常:未分组", getNumerByText(list.get(getGroupNum("未分组"))
//				.getText()) == 0);
//
//		Myassert(
//				"分成成员数量有异常:TestGroup0_37",
//				getNumerByText(list.get(getGroupNum("TestGroup0_37")).getText()) == 0);
//
//		Myassert(
//				"分成成员数量有异常:TestGroup1_37",
//				getNumerByText(list.get(getGroupNum("TestGroup1_37")).getText()) == 1);
//
//		Myassert(
//				"分成成员数量有异常:TestGroup2_37",
//				getNumerByText(list.get(getGroupNum("TestGroup2_37")).getText()) == 2);
//
//		Myassert(
//				"分成成员数量有异常:TestGroup3_37",
//				getNumerByText(list.get(getGroupNum("TestGroup3_37")).getText()) == 7);
//
//		// 清除数据
//		deleteGroup("TestGroup0_37");
//		deleteGroup("TestGroup1_37");
//		deleteGroup("TestGroup2_37");
//		deleteGroup("TestGroup3_37");
//
//		deleteAllContacts();
//		reportLog("分组管理，添加成员");
//
//	}
//
//	/**
//	 * 分组管理，排序
//	 */
//	public void testCase_contact_017() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		// 删除已有分组，预防影响测试
//		clearGroup();
//
//		deleteAllContacts();
//
//		createContacts(casename, casephone);
//
//		// 创建分组
//		createGroup("testCase01_038", 1);
//		createGroup("testCase02_038", 1);
//		createGroup("testCase03_038", 1);
//		createGroup("testCase04_038", 1);
//
//		// 验证
//		Myassert("没找到我的分组入口", isExistenceById("headview_item_name"));
//
//		intoMyGroupPage();
//
//		int groupSize = getWebElementList("TextView", "txt_group_name").size();
//
//		// 点击排序
//		clickByName("排序");
//
//		sleepTime(3000);
//
//		// 移动分组
//		groupMoveto("testCase04_038", "up");
//
//		sleepTime(1000);
//
//		// 移动分组
//		groupMoveto("testCase01_038", "down");
//
//		// 点击保存
//		clickByName("保存");
//
//		sleepTime(2000);
//
//		// 验证
//		Myassert("分组排序顺序有异常（非第二）：testCase04_038",
//				getGroupNum("testCase04_038") == 1);
//
//		Myassert("分组排序顺序有异常（非末尾）：testCase01_038",
//				getGroupNum("testCase01_038") == (groupSize - 1));
//
//		deleteGroup("testCase01_038");
//		deleteGroup("testCase02_038");
//		deleteGroup("testCase03_038");
//		deleteGroup("testCase04_038");
//
//		deleteAllContacts();
//
//		reportLog("分组管理，排序");
//	}
//
//	/**
//	 * 分组管理，移除成员
//	 */
//	@Test(groups = { "contact" ,"group"})
//	public void testCase_contact_018() {
//		startTestCase();
//		// 清空数据
//		clearGroup();
//
//		String g1 = getTestGroupName() + "_1";
//
//		String g3 = getTestGroupName() + "_3";
//
//		
//		deleteAllContacts();
//
//		// 创建联系人
//		createContacts("testCase0_039", "13522068039");
//		createContacts("testCase1_039", "13521168039");
//		createContacts("testCase2_039", "13521268039");
//		createContacts("testCase3_039", "13522368039");
//		createContacts("testCase4_039", "13521468039");
//		createContacts("testCase5_039", "13521568039");
//		createContacts("testCase6_039", "13521668039");
//
//		// 创建分组，分组添加联系人
//		// 不添加联系人
//		createGroup(g1, 1);
//
//		// 添加2个联系人
//		createGroup(g3, 1);
//
//		// 添加7个联系人
//		addAllGroupMembers(g1);
//
//
//		addAllGroupMembers(g3);
//
//
//		// 不移除
//		deleteGroupMembers(g1, 0);
//
//
//		// 移除2个
//		deleteGroupMembers(g3, 2);
//
//		// 进入我的分组
//		intoMyGroupPage();
//
//		List<WebElement> list = this.getWebElementList("TextView",
//				"groupNumber");
//
//		Myassert("分组成员数量有异常：未分组", getNumerByText(list.get(getGroupNum("未分组"))
//				.getText()) == 0);
//
//		Myassert(
//				"分组成员数量有异常：" + g1,
//				getNumerByText(list.get(getGroupNum(g1)).getText()) == 7);
//
//		Myassert(
//				"分组成员数量有异常：" + g3,
//				getNumerByText(list.get(getGroupNum(g3)).getText()) == 5);
//
//		// 清除数据
//		clearGroup();
//
//		deleteAllContacts();
//		reportLog("分组管理，移除成员");
//	}
//
//	/**
//	 * 分组管理，重命名
//	 */
//	public void testCase_contact_019() {
//		startTestCase();
//		// 清除数据
//		clearGroup();
//
//		deleteAllContacts();
//
//		// 创建联系人
//		createContacts("testCase0_040", "13522068040");
//		createContacts("testCase1_040", "13521168040");
//		createContacts("testCase2_040", "13521268040");
//
//		// 添加分组
//		createGroup("TestGroup0_40", 1);
//
//		createGroup("TestGroup1_40", 1);
//
//		createGroup("TestGroup2_40", 1);
//
//		// 添加1个联系人
//		addGroupMembers("TestGroup1_40", 1);
//
//		// 添加所有个联系人
//		addAllGroupMembers("TestGroup2_40");
//
//		// 重命名
//		renameOneGroup("TestGroup0_40", "Rename01");
//		renameOneGroup("TestGroup1_40", "Rename02");
//		renameOneGroup("TestGroup2_40", "Rename03");
//
//		intoMyGroupPage();
//		// 验证
//		Myassert("重命名失败:TestGroup0_40", isExistenceByName("Rename01")
//				&& (!isExistenceByName("TestGroup0_40")));
//
//		Myassert("重命名失败:TestGroup1_40", isExistenceByName("Rename02")
//				&& (!isExistenceByName("TestGroup1_40")));
//
//		Myassert("重命名失败:TestGroup2_40", isExistenceByName("Rename03")
//				&& (!isExistenceByName("TestGroup2_40")));
//
//		// 清除数据
//		deleteGroup("TestGroup0_40");
//		deleteGroup("TestGroup1_40");
//		deleteGroup("TestGroup2_40");
//		deleteGroup("Rename01");
//		deleteGroup("Rename02");
//		deleteGroup("Rename03");
//
//		deleteAllContacts();
//
//		reportLog("分组管理，重命名");
//	}



}
