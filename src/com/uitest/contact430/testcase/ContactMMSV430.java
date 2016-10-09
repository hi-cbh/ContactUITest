package com.uitest.contact430.testcase;

import com.contact.activity.MainActivity_mms;
import com.uitest.data.UserConfig;
import com.uitest.otherapk.OtherApk;
import com.uitest.readxml.ReadXml;
import com.uitest.util.UiAutomatorHelper;

/**
 * 和通讯录，android V4.2基本模块用例
 * 
 * @author Administrator
 * 
 */
public class ContactMMSV430 extends SimpleCode430 {

	public static void main(String[] args) {
		String jarName = "ContactMMSV430";
		String testClass = "com.uitest.contact430.testcase.ContactMMSV430";
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
	
	public void testDemo1(){
		
	}
	
	public void testDemo2(){
		
	}
	
//	
//	/**
//	 * 新建短信，发送
//	 */
//	public void testCase_mms_001() {
//		String name = ReadXml.getContact().get(1).getName();
//		String phone = ReadXml.getContact().get(1).getPhone();
//		String mms = ReadXml.getContact().get(1).getMms();
//		
//	//	OtherApk oa = new OtherApk();
//		OtherApk.prepareUnreadMMS(phone, mms);
//		
//		System.out.println("name: " + name);
//		System.out.println("phone: " + phone);
//		System.out.println("mms: " + mms);
//		MainActivity_mms.createMMs(phone, mms);
		
//		startTestCase();
//
//		// 清除短信
//		deleteAllMMs();
//
//		// 创建短信
//		createMMs("13522068044", "testCase0_044");
//		createMMs("13522168044", "testCase1_044");
//
//		deleteAllMMs();
//		// 创建短信
//		reportLog("新建短信，下拉创建短信");
//	}
//
//	/**
//	 * 创建联系人，点击新建，点击选择已有的联系人
//	 */
//	public void testCase_mms_002() {
//		startTestCase();
//		deleteAllMMs();
//		deleteAllContacts();
//
//		createContacts("testCase0_045", "13522068045");
//		createContacts("testCase1_045", "13522168045");
//
//		createMMs("testCase_045_MMS_0");
//
//		createMMs("testCase_045_MMS_1");
//
//		// 清除
//		deleteAllContacts();
//		deleteAllMMs();
//
//		reportLog(getMethodName(), "创建联系人，点击新建，点击选择已有的联系人");
//	}
//
//	/**
//	 * 编辑常用语，选择第一条常用语，并发送
//	 */
//	
//	public void testCase_mms_003() {
//		startTestCase();
//		// 清除
//		deleteAllMMs();
//
//		clickById("tab_mms");
//
//		// 点击新建短信
//		clickById("iab_ib_action");
//
//		// 验证
//		Myassert("没有进入新建信息页", isExistenceByName("新信息"));
//
//		// 向输入框收入内容
//		intoContentEditTextByName("收件人:", "13522068046");
//
//		// 短信选项中，更多
//		clickById("add_mmspart_button");
//
//		// 验证
//		Myassert("没有进入更多选项", isExistenceById("MMS_option"));
//
//		// 右滑
//		swipeToRight("bottom");
//
//		// 验证
//		Myassert("没有进入编辑常用语", isExistenceById("mms_buttom_useful_sms_edit_btn"));
//
//		// 点击第一个
//		WebElement we = getWebElementInList("list_item_txt", "start");
//
//		String str = we.getText().toString().trim();
//
//		we.click();
//
//		// 点击确定
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
//		// 返回上一页
//		back("tab_mms");
//
//		// 去除信息回收站
//		if (isExistenceById("tv_title")) {
//			clickById("notice_delete");
//		}
//
//		// System.out.println("str " + str);
//		Myassert("内容不一致", getTextViewNameById("subject").toString().trim()
//				.equals(str));
//		reportLog(getMethodName(), "编辑常用语，选择第一条常用语，并发送");
//		deleteAllMMs();
//	}
//
//	/**
//	 * 编辑常用语，选择最后一条常用语，并发送
//	 */
//	
//	public void testCase_mms_004() {
//		startTestCase();
//		// 清除
//		deleteAllMMs();
//
//		clickById("tab_mms");
//
//		// 点击新建短信
//		clickById("iab_ib_action");
//
//		// 验证
//		Myassert("没有进入新建信息页", isExistenceByName("新信息"));
//
//		// 向输入框收入内容
//		intoContentEditTextByName("收件人:", "13522068047");
//
//		// 短信选项中，更多
//		clickById("add_mmspart_button");
//
//		// 验证
//		Myassert("没有进入更多选项", isExistenceById("MMS_option"));
//
//		// 右滑
//		swipeToRight("bottom");
//
//		// 验证
//		Myassert("没有进入编辑常用语", isExistenceById("mms_buttom_useful_sms_edit_btn"));
//
//		// 向上滑
//		swipeToUp();
//
//		// 点击最后一条
//		WebElement we = getWebElementInList("list_item_txt", "end");
//
//		String str = we.getText().toString().trim();
//
//		we.click();
//
//		// 点击确定
//		sendMMS();
//
//		// 返回上一页
//		back("tab_mms");
//
//		// 去除信息回收站
//		if (isExistenceById("tv_title")) {
//			clickById("notice_delete");
//		}
//
//		System.out.println("str " + str);
//		Myassert("未存在短信", isExistenceById("subject"));
//		Myassert("内容对比不一致", getTextViewNameById("subject").toString().trim()
//				.equals(str));
//		reportLog("编辑常用语，选择最后一条常用语，并发送");
//		deleteAllMMs();
//	}
//
//	/**
//	 * 编辑常用语，新增常用语
//	 */
//	
//	public void testCase_mms_005() {
//		startTestCase();
//		// 清除
//		deleteAllMMs();
//
//		clickById("tab_mms");
//
//		// 点击新建短信
//		clickById("iab_ib_action");
//
//		// 验证
//		Myassert("没有进入新增信息页", isExistenceByName("新信息"));
//
//		// 向输入框收入内容
//		intoContentEditTextByName("收件人:", "13522068048");
//
//		// 短信选项中，更多
//		clickById("add_mmspart_button");
//
//		// 验证
//		Myassert("没有进入更多选项", isExistenceById("MMS_option"));
//
//		// 右滑
//		swipeToRight("bottom");
//
//		// 验证
//		Myassert("没有进入常用短信编辑",
//				isExistenceById("mms_buttom_useful_sms_edit_btn"));
//
//		// 点击编辑常用语
//		clickById("mms_buttom_useful_sms_edit_btn");
//
//		// 点击添加
//		clickById("mms_buttom_useful_sms_add_btn");
//
//		// 添加常用语
//		intoContentEditTextById("content", "这是一段测试常用语01");
//
//		// 点击确定
//		clickById("dialog_btn_positive");
//
//		// 等待
//		sleepTime(3000);
//
//		// 向上滑
//		swipeToUp();
//
//		// 点击最后一条
//		WebElement we = getWebElementInList("list_item_txt", "end");
//
//		String str = we.getText().toString().trim();
//
//		we.click();
//
//		// 点击确定
//		sendMMS();
//
//		// 返回上一页
//		back("tab_mms");
//
//		// 去除信息回收站
//		if (isExistenceById("tv_title")) {
//			clickById("notice_delete");
//		}
//
//		// System.out.println("str " + str);
//		Myassert("内容对比不一致", getTextViewNameById("subject").toString().trim()
//				.equals(str));
//		reportLog("编辑常用语，新增常用语");
//		deleteAllMMs();
//	}
//
//	/**
//	 * 编辑常用语，删除常用语
//	 */
//	
//	public void testCase_mms_006() {
//		startTestCase();
//		// 清除
//		deleteAllMMs();
//
//		clickById("tab_mms");
//
//		// 点击新建短信
//		clickById("iab_ib_action");
//
//		// 验证
//		Myassert("没有进入新增信息页", isExistenceByName("新信息"));
//
//		// 短信选项中，更多
//		clickById("add_mmspart_button");
//
//		// 验证
//		Myassert("没有进入更多选项", isExistenceById("MMS_option"));
//
//		// 右滑
//		swipeToRight("bottom");
//		sleepTime(2000);
//
//		// 验证
//		Myassert("没有进入常用编辑页", isExistenceById("mms_buttom_useful_sms_edit_btn"));
//
//		// 向上滑
//		swipeToUp();
//
//		// 点击最后一条
//		WebElement we = getWebElementInList("list_item_txt", "end");
//
//		String str = we.getText().toString().trim();
//
//		// 判断是否为自定义常用语
//		if (getNumerByText(str) > 0) {
//			// 判断为有自定义的常用语，什么都不做
//		}
//		// 否则新建一自定义常用语
//		else {
//			// 点击编辑常用语
//			clickById("mms_buttom_useful_sms_edit_btn");
//
//			// 点击添加
//			clickById("mms_buttom_useful_sms_add_btn");
//
//			// 添加常用语
//			intoContentEditTextById("content", "这是一段测试常用语02");
//
//			// 点击确定
//			clickById("dialog_btn_positive");
//
//			sleepTime(2000);
//		}
//
//		// 点击编辑常用语
//		clickById("mms_buttom_useful_sms_edit_btn");
//
//		// 向上滑
//		swipeToUp();
//
//		// 获取最后一个元素
//		WebElement we2 = getWebElementInList("list_item_txt", "end");
//
//		// 判断为自定义常用语
//		Myassert("最有一条常用语非自定义",
//				getNumerByText(we2.getText().toString().trim()) > 0);
//
//		// 获取最后一个元素
//		WebElement del = getWebElementInList("list_item_btn", "end");
//
//		// 删除
//		del.click();
//
//		// 点击退出编辑
//		clickById("mms_buttom_useful_sms_exit_btn");
//
//		sleepTime(2000);
//
//		swipeToUp();
//		// 再次获取最后元素
//		WebElement we3 = getWebElementInList("list_item_txt", "end");
//		// 判断为非自定义常用语
//		Myassert("最后一条不是常用语",
//				getNumerByText(we3.getText().toString().trim()) < 0);
//		reportLog("编辑常用语，删除常用语");
//	}
//
//	/**
//	 * 设置时间、日期方法已经实现;版本为3.9.6点击发送后，跳转到空白页，无法删除已设置的短信
//	 */
//	public void testCase_mms_007() {
//		startTestCase();
//		clickById("tab_mms");
//
//		// 点击新建短信
//		clickById("iab_ib_action");
//
//		// 验证
//		Myassert("没有进入新增信息页", isExistenceByName("新信息"));
//
//		// 短信选项中，更多
//		clickById("add_mmspart_button");
//
//		// 验证
//		Myassert("没有进入更多选项", isExistenceById("MMS_option"));
//
//		// 定时
//		clickById("timinglayout");
//
//		// 验证
//		Myassert("没有进入时间设置页", isExistenceByName("请设定短信发送时间"));
//
//		// 设置时间
//		// setTime("16", "45");
//
//		// 设置年份
//		setDate("2017", "03", "21");
//
//		// 点击保存
//		clickById("dialog_btn_positive");
//
//		sleepTime(3000);
//		reportLog("未实现有Bug");
//	}
//
//	/**
//	 * 发送表情,选择最左端
//	 */
//	public void testCase_mms_008() {
//		startTestCase();
//		deleteAllMMs();
//
//		clickById("tab_mms");
//
//		// 点击新建短信
//		clickById("iab_ib_action");
//
//		// 验证
//		Myassert("没有进入新增信息页", isExistenceByName("新信息"));
//
//		// 短信选项中，更多
//		clickById("add_mmspart_button");
//
//		// 验证
//		Myassert("没有进入更多选项", isExistenceById("MMS_option"));
//
//		// 点击表情
//		clickById("emoticons");
//
//		// 验证
//		Myassert("没有进入表情选项", isExistenceById("emoticon_viewpager"));
//
//		// 点击默认
//		clickById("emotionbar_radiobtn_feixin");
//
//		// 选择表情
//		selectEmoticon(0);
//
//		// 选择表情
//		selectEmoticon(1);
//
//		// 删除第二个表情
//		selectEmoticon(20);
//
//		// 向输入框收入内容
//		intoContentEditTextByName("收件人:", "13522068051");
//
//		// 点击发送
//		sendMMS();
//
//		sleepTime(2000);
//
//		back("tab_mms");
//
//		// Assert.assertTrue("发送表情错误",getTextViewNameById("subject").contains("微笑"));
//		Myassert("发送表情错误", getTextViewNameById("subject").contains("微笑"));
//
//		reportLog("发送表情,选择最左端");
//		sleepTime(2000);
//
//		deleteAllMMs();
//	}
//
//	/**
//	 * 发送表情,选择最右端
//	 */
//	public void testCase_mms_009() {
//		startTestCase();
//		deleteAllMMs();
//
//		clickById("tab_mms");
//
//		// 点击新建短信
//		clickById("iab_ib_action");
//
//		// 验证
//		Myassert("没有进入新增信息页", isExistenceByName("新信息"));
//
//		// 短信选项中，更多
//		clickById("add_mmspart_button");
//
//		// 验证
//		Myassert("没有进入更多选项", isExistenceById("MMS_option"));
//
//		// 点击表情
//		clickById("emoticons");
//
//		// 验证
//		Myassert("没有进入表情选项", isExistenceById("emoticon_viewpager"));
//
//		// 点击默认
//		clickById("emotionbar_radiobtn_feixin");
//
//		// 向左滑
//		swipeToLeft("bottom");
//		sleepTime(1000);
//		swipeToLeft("bottom");
//		sleepTime(1000);
//		swipeToLeft("bottom");
//		sleepTime(1000);
//
//		// 选择表情
//		selectEmoticon(6);
//
//		// 选择表情
//		selectEmoticon(7);
//
//		// 删除第二个表情
//		selectEmoticon(20);
//
//		// 向输入框收入内容
//		intoContentEditTextByName("收件人:", "13522068052");
//
//		// 点击发送
//		sendMMS();
//
//		sleepTime(2000);
//
//		back("tab_mms");
//
//		// Assert.assertTrue(getTextViewNameById("subject").contains("恶魔"));
//		Myassert("发送表情错误", getTextViewNameById("subject").contains("恶魔"));
//		reportLog("发送表情,选择最右端");
//		sleepTime(2000);
//
//		deleteAllMMs();
//	}
//
//	/**
//	 * 精选短信,选择顶部
//	 */
//	public void testCase_mms_010() {
//		startTestCase();
//		deleteAllMMs();
//
//		clickById("tab_mms");
//
//		// 点击新建短信
//		clickById("iab_ib_action");
//
//		// 验证
//		Myassert("没有进入新增信息页", isExistenceByName("新信息"));
//
//		// 短信选项中，更多
//		clickById("add_mmspart_button");
//
//		// 验证
//		Myassert("没有进入更多选项", isExistenceById("MMS_option"));
//
//		// 点击表情
//		clickById("featuremms");
//
//		// 验证
//		Myassert("没有进入精选短信页", isExistenceByName("精选短信"));
//
//		// 选择精选短信
//		selectFeaturemms(0);
//
//		// 选择第一个
//		WebElement we = getWebElementInList("text", "start");
//		String subStr = we.getText().toString().substring(0, 4);
//
//		we.click();
//
//		// 向输入框收入内容
//		intoContentEditTextByName("收件人:", "13522068053");
//
//		// 点击发送
//		sendMMS();
//
//		sleepTime(2000);
//
//		back("tab_mms");
//
//		// Assert.assertTrue(getTextViewNameById("subject").contains(subStr));
//		Myassert("内容对比不一致", getTextViewNameById("subject").contains(subStr));
//		reportLog("精选短信,选择顶部");
//		sleepTime(2000);
//
//		deleteAllMMs();
//	}

}
