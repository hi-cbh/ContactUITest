package com.uitest.contact4_2;

import java.awt.image.BufferedImage;
import java.util.List;

import com.contact.activity.v420.Setting420;
import com.contact.activity.v420.TabCall4_2;
import com.contact.activity.v420.TabConact4_2;
import com.uitest.data.UserConfig;
import com.uitest.otherapk.OtherApk;
import com.uitest.readxml.ReadXml;
import com.uitest.uiautomatorUtil.ElementManager;
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
		String testName = "testCase_contact_001";
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
		
		TabCall4_2 tca = new TabCall4_2(); 
		TabConact4_2 tct = new TabConact4_2();
		
		clickId("tab_contacts");
		tct.clearContact();

		clickId("tab_call");
		tca.deleteAllCall();
		
		// 准备数据，创建联系人
		TabConact4_2.createContacts(name, phone);
		TabConact4_2.createContacts(name2, phone2);
		TabConact4_2.createContacts(name3, phone3);

		clickId("tab_contacts");
		tct.clearContact();
	}
	

//	/**
//	 * 创建详细的联系人
//	 */
//	
//	public void testCase_contact_002() {
//		startTestCase();
//		deleteAllContacts();
//		back("tab_contacts");
//
//		// 创建联系人
//		createContacts();
//		// 清理数据
//		
//		deleteAllContacts();
//		//deleteContactsByPhone(this.phone);
//
//		reportLog("创建详细的联系人");
//	}

//	/**
//	 * 进入联系人详情页 删除一个联系人 联系人详细页 - 删除联系人
//	 */
//	
//	public void testCase_contact_003() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		deleteAllContacts();
//		back("tab_contacts");
//
//		// 准备测试数据
//		createContacts(casename, casephone);
//
//		// 点击拨号
//		clickById("tab_call");
//
//		// 点击联系人
//		clickById("tab_contacts");
//
//		// 判断列表是否存在该联系人
//		Myassert("不存在联系人：" + casename, searchContact(casephone, 1));
//
//		// 点击进入联系人
//		getFirstTextView(casephone, 1).click();
//
//		// 进入菜单，选择删除
//		clickMenuAndSelect(2);
//
//		// 点击确定
//		clickById("dialog_btn_positive");
//
//		back("tab_contacts");
//		Myassert("删除失败", !isExistenceByName(casename));
//
//		sleepTime(5000);
//
//		reportLog("联系人详细页 - 删除联系人");
//	}
//
//	/**
//	 * 长按联系人，选中全选，点击删除 联系人 - 更多操作 - 删除（长按联系人）
//	 */
//	
//	public void testCase_contact_004() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//
//		deleteAllContacts();
//		back("tab_contacts");
//
//		// 准备测试数据
//		createContacts(casename, casephone);
//
//		// 点击拨号
//		clickById("tab_call");
//
//		// 点击联系人
//		clickById("tab_contacts");
//
//		// 输入框内，输入搜索内容
//		intoContentEditTextById("contact_search_bar", casephone);
//
//		// 判断列表是否存在该联系人
//		// Assert.assertTrue(searchContact("1374242111" , 1));
//		Myassert("列表中没找到该联系人:" + casephone, searchContact(casephone, 1));
//
//		// 长按联系人
//		// clickLongWebElement(getFirstTextView("10086"));
//		clickLongByNameUseJs(casephone);
//
//		// 点击全选按钮
//		clickById("iab_ib_more");
//
//		// 点击删除
//		clickById("mca_delete_icon");
//
//		// 点击确定
//		clickById("dialog_btn_positive");
//
//		back("tab_contacts");
//		Myassert("删除失败", !isExistenceByName(casename));
//
//		deleteAllContacts();
//		reportLog("联系人 - 更多操作 - 删除（长按联系人）");
//	}
//
//	/**
//	 * 输入搜索条件，获取联系人信息。 联系人列表 - 搜索本地联系人
//	 */
//	
//	public void testCase_contact_005() {
//		startTestCase();
//
//		deleteAllContacts();
//		back("tab_contacts");
//
//		// 创建联系人，准备测试数据
//		createContacts("张小花", "13824451649");
//		createContacts("通讯录", "13843845678");
//
//		// 输入框内，输入搜索内容
//		intoContentEditTextById("contact_search_bar", "张小花");
//
//		// 判断列表是否存在该联系人
//		// Assert.assertTrue(searchContact("13824451649" , 1));
//		Myassert("列表中没找到该联系人:张小花", searchContact("13824451649", 1));
//
//		// 输入框内，输入搜索内容
//		intoContentEditTextById("contact_search_bar", "zxh");
//
//		// 判断列表是否存在该联系人
//		// Assert.assertTrue(searchContact("13824451649" , 1));
//		Myassert("列表中没找到该联系人:张小花", searchContact("13824451649", 1));
//
//		// 输入框内，输入搜索内容
//		intoContentEditTextById("contact_search_bar", "zhangxiaohua");
//
//		// 判断列表是否存在该联系人
//		// Assert.assertTrue(searchContact("13824451649" , 1));
//		Myassert("列表中没找到该联系人:张小花", searchContact("13824451649", 1));
//		// 输入框内，输入搜索内容
//		intoContentEditTextById("contact_search_bar", "13824451649");
//
//		// 判断列表是否存在该联系人
//		// Assert.assertTrue(searchContact("13824451649" , 1));
//		Myassert("列表中没找到该联系人:张小花", searchContact("13824451649", 1));
//		// 清理数据
//		deleteContactsByPhone("13824451649");
//		deleteContactsByPhone("13843845678");
//
//		reportLog("联系人列表 - 搜索本地联系人");
//	}
//
//	/**
//	 * 创建联系人后，新增或修改联系人信息 联系人详细页 - 编辑
//	 */
//	
//	public void testCase_contact_006() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		String casephone2 = phone;
//		deleteAllContacts();
//		back("contact");
//		// 创建联系人
//		createContacts(casename, casephone);
//
//		// 进入新创建的联系详细页
//		clickById("tab_contacts");
//
//		// 搜索联系人
//		intoContentEditTextById("contact_search_bar", casephone);
//
//		// 点击搜索记录，
//		searchWebElement(casename).click();
//
//		sleepTime(2000);
//
//		// 点击编辑
//		clickById("iab_ib_action");
//
////		// 获取界面所有的EditView元素
////		List<WebElement> editText = driver
////				.findElementsByClassName("android.widget.EditText");
////
////		// clearText(editText.get(4).getAttribute("text"));
////		editText.get(4).sendKeys(casephone2);
//
//		intoContentEditTextByName("电话号码", casephone2);
//		
//		
//		// 点击保存
//		clickById("iab_ib_action");
//
//		sleepTime(3000);
//
//		// 返回拨号页
//		back("tab_contacts");
//
//		intoContentEditTextById("contact_search_bar", casephone2);
//
//		// Assert.assertTrue(this.searchContact("testCase_025", 0));
//		Myassert("没有找到测试数据：" + casename, searchContact(casename, 0));
//
//		clearTextAndNote();
//		
//		clickById("tab_contacts");
//
//		// this.deleteContactsByName("testCase_025");
//		deleteAllContacts();
//		reportLog("联系人详细页 - 编辑");
//
//	}
//
//	/**
//	 * 联系人详细页 - 收藏
//	 */
//	
//	public void testCase_contact_007() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		deleteAllContacts();
//		back("contact");
//		// 创建测试数据
//		createContacts(casename, casephone);
//
//		// 进入新创建的联系详细页
//		clickById("tab_contacts");
//
//		// 搜索联系人
//		intoContentEditTextById("contact_search_bar", casephone);
//
//		// 点击搜索记录，
//		searchWebElement(casename).click();
//
//		sleepTime(2000);
//
//		// 点击收藏按钮
//		clickById("contact_detail_starred");
//
//		// 验证收藏标志被选上
//		boolean bl = driver.findElementById("contact_detail_starred")
//				.getAttribute("checked").equals("true");
//		Myassert("联系人没有被标识为收藏", bl);
//		// Assert.assertTrue("",driver.findElementById("contact_detail_starred").getAttribute("checked").equals("true"));
//
//		// 返回主页
//		back("tab_contacts");
//
//		// 清空记录
//		clearTextAndNote();
//
//		// 搜索列表中，是否存在 收藏联系人选项
//		Myassert("不存在收藏列表", driver.findElementByName("收藏联系人").isDisplayed());
//
//		// 删除用户名
//		deleteContactsByName(casename);
//		// 这里不能用全部删除联系人
//		// deleteAllContacts();
//		reportLog("联系人详细页 - 收藏");
//	}
//
//	/**
//	 * 新建联系人（屏幕下拉）
//	 */
//	
//	public void testCase_contact_008() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//
//		// 进入联系人列表
//		clickById("tab_contacts");
//
//		// 下拉列表
//		swipeToDown();
//
//		// 保存联系信息
//		saveContact(casename, casephone);
//
//		// 休眠3秒
//		sleepTime(3000);
//
//		// 输入框内，输入搜索内容
//		intoContentEditTextById("contact_search_bar", casephone);
//
//		// 判断是否通过
//		// Assert.assertTrue(searchContact(phone, 1));
//		Myassert("创建联系人失败", searchContact(casephone, 1));
//
//		// 删除联系人
//		// deleteContactsByName(username);
//		deleteAllContacts();
//		reportLog("新建联系人（屏幕下拉）");
//	}
//
//	/**
//	 * 联系人-加入白名单
//	 */
//	
//	public void testCase_contact_009() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//
//		deleteAllContacts();
//		clickById("tab_contacts");
//
//		// 创建联系人
//		createContacts(casename, casephone);
//
//		sleepTime(4000);
//
//		back("tab_contacts");
//		// 长按选择联系人
//		clickLongByIdUseJs("contact_name");
//
//		// 点击
//		clickByName("加入白名单");
//
//		// 进入管理白名单
//		OpenTabMenu("防打扰", "白名单");
//
//		// 检测当前界面为防打扰页
//		Myassert("没有进入白名单", driver.findElementByName("管理白名单").isDisplayed());
//
//		boolean bl = searchContact(casephone, 0);
//
//		// 检测当前是否存储骚扰电话
//		// Assert.assertTrue(bl);
//		Myassert("列表中，找不到联系人：" + casephone, bl);
//
//		sleepTime(1000);
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
//		back("tab_contacts");
//
//		// 删除
//		// deleteContactsByName(phone);
//		deleteAllContacts();
//		// 清空记录
//		clearTextAndNote();
//		reportLog("联系人-加入白名单");
//	}
//
//	/**
//	 * 联系人页-加入白名单
//	 */
//	
//	public void testCase_contact_010() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//
//		deleteAllContacts();
//
//		clickById("tab_contacts");
//
//		// 创建联系人
//		createContacts(casename, casephone);
//
//		// 清空记录
//		clearTextAndNote();
//
//		sleepTime(4000);
//
//		// 点击进入
//		clickByName(casephone);
//
//		// 选择加入白名单
//		this.clickMenuAndSelect(4);
//
//		// 返回联系人页
//		back("tab_contacts");
//
//		// 进入管理白名单
//		OpenTabMenu("防打扰", "白名单");
//
//		// 检测当前界面为防打扰页
//		Myassert("没有进入白名单管理", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("管理白名单"));
//
//		
//		Myassert("不存在白名单联系人", isExistenceById("name"));
//		Myassert("白名单联系人有误: " + casename, getTextViewNameById("name").equals(casename));
//		
//		//点击清空
//		clickById("iab_ib_action");
//		
//		clickById("dialog_btn_positive");
//		
//		// 返回主界面
//		back("tab_contacts");
//
//		// 删除
//		deleteAllContacts();
//		// 清空记录
//		clearTextAndNote();
//		reportLog("联系人页-加入白名单");
//	}
//
//	/**
//	 * 创建详细联系人，添加头像
//	 */
//	@Test(groups = { "debug" })
//	public void testCase_contact_011() {
//		startTestCase();
//		deleteAllContacts();
//		// 创建联系人
//		createContacts();
//		// 获取联系人图标
//		Point point = getContactsPoint().get(0);
//		// System.out.println("Point: " + point);
//
//		BufferedImage subImg1 = getContactHead(point);
//
//		// 点击一个联系人
//		clickById("contact_name");
//
//		// 选择图片
//		selectImage();
//
//		back("tab_contacts");
//
//		BufferedImage subImg2 = getContactHead(point);
//		// System.out.println("Point: " + point);
//
//		// 对比图片
//		boolean bl = sameAs(subImg1, subImg2, 0.9);
//
//		// 清理数据
//		this.deleteAllContacts();
//
//		// 判断
//		// Assert.assertTrue(!bl);
//		Myassert("添加图片失败", !bl);
//
//		reportLog("创建详细联系人，添加头像");
//	}
//
//	/**
//	 * 获取搜索输入框内的联系人个数 联系人数量在0个是对比，1个是对比。超于6个或7个联系人联系人数量无法对比，列表创建原理。
//	 */
//	
//	public void testCase_contact_012() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		
//		
//		// 清空本地联系人
//		deleteAllContacts();
//		
//		
//		back("tab_contacts");
//
//		// 进入联系人列表，获取联系人数量，getContactCount();
//		// 获取搜索框内容的数字，getNumById("contact_search_bar");
//
//		createContacts(casename, casephone);
//		back("tab_contacts");
//		//boolean b2 = getContactCount() == getNumById("contact_search_bar");
//		int num1 = getContactCount();
//		int num2 = getNumById("contact_search_bar");
//		
//		// Assert.assertTrue(getContactCount() ==
//		// getNumById("contact_search_bar"));
//		Myassert("联系人数量不一致,分别是: " + num1 + ": " + num2, num1 == num2);
//
//		// 清空本地联系人
//		deleteAllContacts();
//
//		reportLog("获取搜索输入框内的联系人个数");
//	}
//
//	/**
//	 * 分组管理，创建分组并添加成员
//	 */
//	
//	public void testCase_contact_013() {
//		startTestCase();
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//
//		String casename2 = getTestCaseName()+"_2";
//		String casephone2 = phone;
//
//		back("tab_contacts");
//
//		clearGroup();
//
//		deleteAllContacts();
//
//		createContacts(casename, casephone);
//		createContacts(casename2, casephone2);
//
//		// 创建分组，并留住当前页面
//		createGroup("陈策", 1);
//
//		// 点击我的分组
//		clickById("headview_item_name");
//
//		// 进入分组
//		clickByName("陈策");
//
//		// 点击添加成员
//		clickByName("添加成员");
//		// sleepTime(10000);
//
//		// 验证当前页面
//		Myassert("当前页不在我的分组内", isExistenceByName("分组添加成员"));
//
//		// 获取联系人列表联系人数量
//		int firNum = getNumById("contact_search_bar");
//
//		// 点击更多按钮
//		clickById("iab_ib_more");
//
//		// 点击添加
//		clickById("selection_ok");
//
//		// 获取联系人列表联系人数量
//		int secNum = getNumById("contact_search_bar");
//
//		// 验证数量是否一致
//		// Assert.assertTrue(firNum == secNum);
//		Myassert("数量是否一致", firNum == secNum);
//
//		back("tab_contacts");
//
//		// 点击我的分组
//		clickById("headview_item_name");
//
//
//		back("tab_contacts");
//		clearGroup();
//		
//		deleteAllContacts();
//
//		reportLog("分组管理，创建分组并添加成员");
//	}
//
//	/**
//	 * 分组管理，修改组名 分别创建两个分组，一个联系人为空，另一个联系人数量不为空
//	 */
//	@Test(groups = { "contact" ,"group"})
//	public void testCase_contact_014() {
//		startTestCase();
//
//		clearGroup();
//		deleteAllContacts();
//
//		// 创建联系人
//		createContacts("testCase0_contact_014", "13522168035");
//		createContacts("testCase1_contact_014", "13521168035");
//		createContacts("testCase2_contact_014", "13521068035");
//
//		// 创建分组1
//		createGroup("TestGroup_01", 1);
//
//		// 创建分组2，分组2添加联系人
//		createGroup("TestGroup_02", 1);
//
//		// 分组添加联系人
//		addAllGroupMembers("TestGroup_02");
//
//		intoMyGroupPage();
//
//		renameGroup("TestGroup_01", "你猜猜");
//
//		intoMyGroupPage();
//
//		renameGroup("TestGroup_02", "猜不到啊");
//
//		Myassert("修改分组失败", isExistenceByName("你猜猜")
//				&& isExistenceByName("猜不到啊"));
//
//		deleteGroup("你猜猜");
//
//		deleteGroup("猜不到啊");
//
//		deleteAllContacts();
//
//		reportLog("分组管理，修改组名");
//	}
//
//	/**
//	 * 分组管理，解除分组
//	 */
//	
//	public void testCase_contact_015() {
//		startTestCase();
//		clickById("tab_contacts");
//
//		clearGroup();
//
//		deleteAllContacts();
//
//		// 创建联系人
//		createContacts("testCase0_contact_015", "13522168036");
//		createContacts("testCase1_contact_015", "13521168036");
//		createContacts("testCase2_contact_015", "13521068036");
//
//		// 创建分组1
//		createGroup("TestGroup01_36", 1);
//
//		// 创建分组2，分组2添加联系人
//		createGroup("TestGroup02_36", 1);
//
//		// 分组添加联系人
//		addAllGroupMembers("TestGroup02_36");
//
//		// 进入我的分组
//		intoMyGroupPage();
//
//		// 删除分组
//		deleteGroup("TestGroup01_36");
//
//		// 进入我的分组
//		intoMyGroupPage();
//
//		// 删除分组
//		deleteGroup("TestGroup02_36");
//
//		Myassert(
//				"删除分组失败",
//				!(isExistenceByName("TestGroup01_36") && isExistenceByName("TestGroup02_36")));
//
//		deleteAllContacts();
//		reportLog("分组管理，解除分组");
//	}
//
//	/**
//	 * 分组管理，添加成员
//	 */
//	
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
//	
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
//	
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
//
//	/**
//	 * 分组管理，解散分组
//	 */
//	@Test(groups = { "contact" ,"group"})
//	public void testCase_contact_020() {
//		startTestCase();
//		// 清除数据
//		clearGroup();
//
//		deleteAllContacts();
//		// 创建联系人
//		createContacts("testCase0_041", "13522068041");
//		createContacts("testCase1_041", "13521168041");
//		createContacts("testCase2_041", "13521268041");
//
//		// 添加分组
//		createGroup("TestGroup0_41", 1);
//
//		createGroup("TestGroup1_41", 1);
//
//		createGroup("TestGroup2_41", 1);
//
//		// 添加1个联系人
//		addGroupMembers("TestGroup1_41", 1);
//
//		// 添加所有个联系人
//		addAllGroupMembers("TestGroup2_41");
//
//		// 删除
//		deleteOneGroup("TestGroup0_41");
//
//		deleteOneGroup("TestGroup1_41");
//
//		deleteOneGroup("TestGroup2_41");
//
//		// 判断
//		Myassert("解散分组失败：TestGroup0_41", !isExistenceByName("TestGroup0_41"));
//		Myassert("解散分组失败：TestGroup1_41", !isExistenceByName("TestGroup1_41"));
//		Myassert("解散分组失败：TestGroup2_41", !isExistenceByName("TestGroup2_41"));
//
//		deleteAllContacts();
//
//		reportLog("分组管理，解散分组");
//	}
//
//	/**
//	 * 分组管理，批量设置铃声
//	 */
//	
//	public void testCase_contact_021() {
//		startTestCase();
//		// 清除联系人
//		clearGroup();
//
//		deleteAllContacts();
//
//		// 创建联系人
//		createContacts("testCase0_042", "13522068042");
//		createContacts("testCase1_042", "13521168042");
//		createContacts("testCase2_042", "13521268042");
//
//		// 添加分组
//		createGroup("TestGroup0_42", 1);
//
//		createGroup("TestGroup1_42", 1);
//
//		createGroup("TestGroup2_42", 1);
//
//		// 添加联系人
//		addGroupMembers("TestGroup0_42", 0);
//
//		addGroupMembers("TestGroup1_42", 1);
//
//		addAllGroupMembers("TestGroup2_42");
//
//		// 添加铃声
//		scrollAndSelect("TestGroup0_42", "top");
//
//		scrollAndSelect("TestGroup1_42", "mid");
//
//		scrollAndSelect("TestGroup2_42", "bottom");
//
//		// 这方法只能通过拨号来验证
//
//		// 清除联系人
//		deleteGroup("TestGroup0_42");
//		deleteGroup("TestGroup1_42");
//		deleteGroup("TestGroup2_42");
//
//		deleteAllContacts();
//
//		reportLog("分组管理，批量设置铃声");
//	}
//
//	/**
//	 * 分组管理，组内搜索
//	 */
//	@Test(groups = { "contact" ,"group"})
//	public void testCase_contact_022() {
//		startTestCase();
//		// 清理数据
//		deleteAllContacts();
//
//		// 创建联系人
//		createContacts("testCase0_043", "13522068043");
//		createContacts("testCase1_043", "13521168043");
//		createContacts("testCase2_043", "13521268043");
//		createContacts("testCase3_043", "13522368043");
//		createContacts("testCase4_043", "13521468043");
//		createContacts("testCase5_043", "13521568043");
//
//		// 有联系人才能删除分组
//		deleteGroup("TestGroup0_43");
//
//		// 添加分组
//		createGroup("TestGroup0_43", 1);
//
//		// 添加联系人
//		addGroupMembers("TestGroup0_43", 5);
//
//		intoMyGroupPage();
//
//		clickByName("TestGroup0_43");
//
//		// 输入框内，输入搜索内容
//		intoContentEditTextById("contact_search_bar", "13522068043");
//		// 搜索存在的联系人
//		// Assert.assertTrue(searchContact("13522068043" , 1));
//		Myassert("找不到联系人：13522068043", searchContact("13522068043", 1));
//
//		// 输入框内，输入搜索内容
//		intoContentEditTextById("contact_search_bar", "13521568043");
//
//		// 搜索不存在的联系人
//		Myassert("搜索到联系人，理应搜索不到", isExistenceById("no_contact_text"));
//
//		// 返回
//		back("tab_contacts");
//
//		deleteGroup("TestGroup0_43");
//
//		// 清理数据
//		deleteAllContacts();
//
//		reportLog("分组管理，组内搜索");
//	}
//
//	/**
//	 * 联系人列表，发短信
//	 */
//	
//	public void testCase_contact_023() {
//		
//		startTestCase();
//		// 清理数据
//		deleteAllContacts();
//		deleteAllMMs();
//		
//		back("tab_contacts");
//		
//		String casename = this.getTestCaseName();
//		String casephone = sendPhone;
//		String casecontent = casename +": " + casephone;
//		
//		createContacts(casename, casephone);
//		
//		//长按
//		clickLongByIdUseJs("contact_name");
//		
//		//点击发短信
//		clickById("mca_msg_txt");
//		
//		Myassert("没有进入新信息页", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("新信息"));
//		
//		intoContentEditTextById("embedded_text_editor", casecontent);
//		
//		sendMMS();
//		
//		back("tab_mms");
//		
//		clickById("from");
//		
//		Myassert("发送的姓名不正确：" + casename, isExistenceById("iab_title") && getTextViewNameById("iab_title").equals(casename));
//		
//		Myassert("发送的号码不正确" + casephone, isExistenceById("iab_sub_title") && getTextViewNameById("iab_sub_title").equals(casephone));
//		
//		Myassert("发送内容不正确" + casecontent, isExistenceById("text_view") && getTextViewNameById("text_view").contains(casename));
//		
//		// 清理数据
//		deleteAllContacts();
//		deleteAllMMs();
//		reportLog("联系人列表，发短信");
//	}
//	
//	
//	/**
//	 * 联系人列表，群发短信
//	 */
//	
//	public void testCase_contact_024() {
//		
//		startTestCase();
//		// 清理数据
//		deleteAllContacts();
//		deleteAllMMs();
//		
//		back("tab_contacts");
//		
//		
//		String casename = this.getTestCaseName();
//		String casephone = sendPhone;
//		
//		String casename2 = this.getTestCaseName()+"2";
//		String casephone2 = phone;
//		
//		
//		String casecontent = getTestCaseName() + ": test_content";
//		
//		createContacts(casename, casephone);
//		createContacts(casename2, casephone2);
//		
//		back("tab_contacts");
//		
//		//点击群发短信
//		clickMenuAndSelect(1);
//		
//		//点击全选
//		clickById("iab_ib_more");
//		
//		//点击添加
//		clickById("selection_ok");
//		
//		
//		Myassert("没有进入新信息页", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("新信息"));
//		
//		intoContentEditTextById("embedded_text_editor", casecontent);
//		
//		sendMMS();
//		
//		sleepTime(2000);
//		
//		if(isExistenceById("title"))
//		{
//			if(getTextViewNameById("title").equals("短信发送失败")){
//				clickById("dialog_btn_negative");
//			}
//		}
//		
//		back("tab_mms");
//		
//		clickById("from");
//		
//		//
//		Myassert("发送的号码不正确" + casephone, isExistenceById("iab_sub_title") && getTextViewNameById("iab_sub_title").contains(casephone));
//		Myassert("发送的号码不正确" + phone, isExistenceById("iab_sub_title") && getTextViewNameById("iab_sub_title").contains(phone));
//	
//		List<WebElement> list = getLisWebElementById("text_view");
//		
//		Myassert("发出的号码数量不正确，应为：" + list.size(), list.size() == 2);
//		Myassert("两组短信内容不一致" , list.get(0).getText().equals(list.get(1).getText()));
//		Myassert("短信内容不正确：" + casecontent, list.get(0).getText().contains("test_content"));
//		
//		// 清理数据
//		deleteAllContacts();
//		deleteAllMMs();
//		reportLog("联系人列表，群发短信");
//		
//	}
//	
//	
//	
//	
//	/**
//	 * 联系人详细页，名片分享
//	 */
//	
//	public void testCase_contact_025() {
//		
//		startTestCase();
//		// 清理数据
//		deleteAllContacts();
//		deleteAllMMs();
//		
//		back("tab_contacts");
//		
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		
//		createContacts(casename, casephone);
//		
//		back("tab_contacts");
//		
//
//		clickById("contact_name");
//		
//		Myassert("没有进入联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//		
//		//分享名片
//		clickMenuAndSelect(1);
//		
//		Myassert("没有弹出选择分享软件", getTextViewNameById("android:id/alertTitle").equals("选择分享"));
//		
//		clickByName("和通讯录");
//		
//		sleepTime(1000);
//		
//		Myassert("没有进入新信息页", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("新信息"));
//		
//		intoContentEditTextByName("收件人:", phone);
//		
//		//点击发送
//		sendMMS();
//		sleepTime(2000);
//		
//		if(isExistenceById("title"))
//		{
//			if(getTextViewNameById("title").equals("短信发送失败")){
//				clickById("dialog_btn_negative");
//			}
//		}
//		
//		back("tab_mms");
//		
//		Myassert("没有发送短信", isExistenceById("from") && getTextViewNameById("from").contains(phone));
//		
//		clickById("from");
//		
//		String text = getTextViewNameById("text_view");
//		String adr = "http://pim.10086.cn/wapdownload.php ";
//		
//		Myassert("分享名片内容没有对应手机号" + casename, text.contains(casename));
//		Myassert("分享名片内容没有对应名称" + casephone, text.contains(casephone));
//		Myassert("分享名片内容没有对应地址" + adr, text.contains(adr));
//		
//		reportLog("联系人详细页，名片分享");
//		
//		deleteAllMMs();
//		deleteAllContacts();
//	}
//	
//	/**
//	 * 联系人详细页，群组选择(选择已有)
//	 */
//	
//	public void testCase_contact_026() {
//		
//		startTestCase();
//		// 清理数据
//		clearGroup();
//		deleteAllContacts();
//		deleteAllMMs();
//		
//		back("tab_contacts");
//		
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		String casegroup = getTestGroupName();
//		createContacts(casename, casephone);
//		createGroup(casegroup, 1);
//		
//		back("tab_contacts");
//		
//		clickById("contact_name");
//		
//		Myassert("没有进入联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//		
//		//分
//		clickMenuAndSelect(3);
//		
//		Myassert("没有进入分组选择", getTextViewNameById("iab_title").equals("分组选择"));
//
//		//选择分组
//		getLisWebElementById("check_group_select").get(getGroupNum(casegroup)).click();
//		
//		sleepTime(2000);
//		
//		Myassert("没有选择分组", getLisWebElementById("group_choice_ok_btn").get(0).getAttribute("enabled").equals("true"));
//		
//		clickById("group_choice_ok_btn");
//		
//		//自动返回联系人详情页
//		Myassert("没有自动返回联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//		
//		Myassert("联系人分组中，没有还有分组信息：" + casegroup, getTextViewNameById("contact_detail_groups_name").contains(casegroup));
//		
//		back("tab_contacts");
//		
//		clearGroup();
//		
//		reportLog("联系人详细页，群组选择");
//		
//		deleteAllCall();
//		deleteAllMMs();
//		deleteAllContacts();
//	}
//	
//	
//	/**
//	 * 联系人详细页，群组选择(新建分组)
//	 */
//	
//	public void testCase_contact_027() {
//		
//		startTestCase();
//		// 清理数据
//		clearGroup();
//		deleteAllContacts();
//		deleteAllMMs();
//		
//		back("tab_contacts");
//		
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		String casegroup = getTestGroupName();
//		
//		createContacts(casename, casephone);
//		
//		back("tab_contacts");
//		
//		clickById("contact_name");
//		
//		Myassert("没有进入联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//		
//		
//		//
//		clickMenuAndSelect(3);
//		
//		Myassert("没有进入分组选择", getTextViewNameById("iab_title").equals("分组选择"));
//
//		//点击新增
//		clickById("iab_ib_more");
//		
//		//新建分组
//		Myassert("没有进入新建分组", getTextViewNameById("title").equals("新建分组"));
//		
//		//输入分组名
//		intoContentEditTextById("content", casegroup);
//		
//		//点击保存
//		clickById("dialog_btn_positive");
//		
//		//点击确定
//		clickById("group_choice_ok_btn");
//		
//		sleepTime(2000);
//		
//		//自动返回联系人详情页
//		Myassert("没有自动返回联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//		
//		Myassert("联系人分组中，没有还有分组信息：" + casegroup, getTextViewNameById("contact_detail_groups_name").contains(casegroup));
//		
//		back("tab_contacts");
//		
//		clearGroup();
//		
//		reportLog("联系人详细页，群组选择(选择新建)");
//		
//		deleteAllCall();
//		deleteAllMMs();
//		deleteAllContacts();
//	}
//	
//	/**
//	 * 分组-分组管理-群发短信
//	 */
//	public void testCase_contact_028() {
//		
//		startTestCase();
//		// 清理数据
//		clearGroup();
//		deleteAllContacts();
//		deleteAllMMs();
//		
//		back("tab_contacts");
//				
//		String casename = this.getTestCaseName();
//		String casephone = sendPhone;
//		
//		String casename2 = this.getTestCaseName()+"2";
//		String casephone2 = phone;
//		
//		String casegroup = getTestGroupName();
//		
//		String casecontent = getTestCaseName() + ": test_content";
//		
//		createContacts(casename, casephone);
//		createContacts(casename2, casephone2);
//		
//		createGroup(casegroup, 1);
//		
//		addAllGroupMembers(casegroup);
//		
//		back("tab_contacts");
//		
//		intoMyGroupPage();
//		
//		clickByName(casegroup);
//		
//		Myassert("没有进入新建的分组", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals(casegroup));
//		
//		clickByName("群发短信");
//
//		//点击添加
//		clickById("selection_ok");	
//		
//		Myassert("没有进入新信息页", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("新信息"));
//		
//		intoContentEditTextById("embedded_text_editor", casecontent);
//		
//		sendMMS();
//		
//		sleepTime(2000);
//		
//		if(isExistenceById("title"))
//		{
//			if(getTextViewNameById("title").equals("短信发送失败")){
//				clickById("dialog_btn_negative");
//			}
//		}
//		
//		back("tab_mms");
//		
//		clickById("from");
//		
//		//
//		Myassert("发送的号码不正确" + casephone, isExistenceById("iab_sub_title") && getTextViewNameById("iab_sub_title").contains(casephone));
//		Myassert("发送的号码不正确" + phone, isExistenceById("iab_sub_title") && getTextViewNameById("iab_sub_title").contains(phone));
//	
//		List<WebElement> list = getLisWebElementById("text_view");
//		
//		Myassert("发出的号码数量不正确，应为：" + list.size(), list.size() == 2);
//		Myassert("两组短信内容不一致" , list.get(0).getText().equals(list.get(1).getText()));
//		Myassert("短信内容不正确：" + casecontent, list.get(0).getText().contains("test_content"));
//		
//		// 清理数据
//		clearGroup();
//		deleteAllContacts();
//		deleteAllMMs();
//		reportLog("分组-分组管理-群发短信");
//	}
//	
//	
//	/**
//	 * 联系人列表-长按联系人-名片分享
//	 */
//	
//	public void testCase_contact_029() {
//		
//		startTestCase();
//		// 清理数据
//		deleteAllContacts();
//		deleteAllMMs();
//		
//		back("tab_contacts");
//		
//		String casename = getTestCaseName();
//		String casephone = sendPhone;
//		
//		createContacts(casename, casephone);
//		
//		back("tab_contacts");
//		
//		clickLongByIdUseJs("contact_name");
//		
//		clickByName("分享名片");
//		
//		Myassert("没有弹出选择分享软件", getTextViewNameById("android:id/alertTitle").equals("选择分享"));
//		
//		clickByName("和通讯录");
//		
//		sleepTime(1000);
//		
//		Myassert("没有进入新信息页", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("新信息"));
//		
//		intoContentEditTextByName("收件人:", phone);
//		
//		//点击发送
//		sendMMS();
//		sleepTime(2000);
//		
//		if(isExistenceById("title"))
//		{
//			if(getTextViewNameById("title").equals("短信发送失败")){
//				clickById("dialog_btn_negative");
//			}
//		}
//		
//		back("tab_mms");
//		
//		Myassert("没有发送短信", isExistenceById("from") && getTextViewNameById("from").contains(phone));
//		
//		clickById("from");
//		
//		String text = getTextViewNameById("text_view");
//		String adr = "http://pim.10086.cn/wapdownload.php ";
//		
//		Myassert("分享名片内容没有对应手机号" + casename, text.contains(casename));
//		Myassert("分享名片内容没有对应名称" + casephone, text.contains(casephone));
//		Myassert("分享名片内容没有对应地址" + adr, text.contains(adr));
//		
//		reportLog("联系人详细页，名片分享");
//		
//		deleteAllMMs();
//		deleteAllContacts();
//	}

}
