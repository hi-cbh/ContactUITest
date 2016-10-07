package com.uitest.contact4_2.testcase;

import java.util.List;

import com.uitest.data.UserConfig;
import com.uitest.util.UiAutomatorHelper;

/**
 * 和通讯录，android V4.2基本模块用例
 * 
 * @author Administrator
 * 
 */
public class ContactMMSV420 {

	public static void main(String[] args) {
		String jarName = "ContactMMSV420";
		String testClass = "com.uitest.contact4_2.testcase.ContactMMSV420";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	/**
	 * 新建短信，下拉创建短信
	 */
	
	public void testCase_mms_001() {
		startTestCase();

		// 清除短信
		deleteAllMMs();

		// 创建短信
		createMMs("13522068044", "testCase0_044");
		createMMs("13522168044", "testCase1_044");

		deleteAllMMs();
		// 创建短信
		reportLog("新建短信，下拉创建短信");
	}

	/**
	 * 创建联系人，点击新建，点击选择已有的联系人
	 */
	
	public void testCase_mms_002() {
		startTestCase();
		deleteAllMMs();
		deleteAllContacts();

		createContacts("testCase0_045", "13522068045");
		createContacts("testCase1_045", "13522168045");

		createMMs("testCase_045_MMS_0");

		createMMs("testCase_045_MMS_1");

		// 清除
		deleteAllContacts();
		deleteAllMMs();

		reportLog(getMethodName(), "创建联系人，点击新建，点击选择已有的联系人");
	}

	/**
	 * 编辑常用语，选择第一条常用语，并发送
	 */
	
	public void testCase_mms_003() {
		startTestCase();
		// 清除
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新建信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068046");

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 右滑
		swipeToRight("bottom");

		// 验证
		Myassert("没有进入编辑常用语", isExistenceById("mms_buttom_useful_sms_edit_btn"));

		// 点击第一个
		WebElement we = getWebElementInList("list_item_txt", "start");

		String str = we.getText().toString().trim();

		we.click();

		// 点击确定
		sendMMS();

		sleepTime(2000);
		
		if(isExistenceById("title"))
		{
			if(getTextViewNameById("title").equals("短信发送失败")){
				clickById("dialog_btn_negative");
			}
		}
		// 返回上一页
		back("tab_mms");

		// 去除信息回收站
		if (isExistenceById("tv_title")) {
			clickById("notice_delete");
		}

		// System.out.println("str " + str);
		Myassert("内容不一致", getTextViewNameById("subject").toString().trim()
				.equals(str));
		reportLog(getMethodName(), "编辑常用语，选择第一条常用语，并发送");
		deleteAllMMs();
	}

	/**
	 * 编辑常用语，选择最后一条常用语，并发送
	 */
	
	public void testCase_mms_004() {
		startTestCase();
		// 清除
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新建信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068047");

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 右滑
		swipeToRight("bottom");

		// 验证
		Myassert("没有进入编辑常用语", isExistenceById("mms_buttom_useful_sms_edit_btn"));

		// 向上滑
		swipeToUp();

		// 点击最后一条
		WebElement we = getWebElementInList("list_item_txt", "end");

		String str = we.getText().toString().trim();

		we.click();

		// 点击确定
		sendMMS();

		// 返回上一页
		back("tab_mms");

		// 去除信息回收站
		if (isExistenceById("tv_title")) {
			clickById("notice_delete");
		}

		System.out.println("str " + str);
		Myassert("未存在短信", isExistenceById("subject"));
		Myassert("内容对比不一致", getTextViewNameById("subject").toString().trim()
				.equals(str));
		reportLog("编辑常用语，选择最后一条常用语，并发送");
		deleteAllMMs();
	}

	/**
	 * 编辑常用语，新增常用语
	 */
	
	public void testCase_mms_005() {
		startTestCase();
		// 清除
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068048");

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 右滑
		swipeToRight("bottom");

		// 验证
		Myassert("没有进入常用短信编辑",
				isExistenceById("mms_buttom_useful_sms_edit_btn"));

		// 点击编辑常用语
		clickById("mms_buttom_useful_sms_edit_btn");

		// 点击添加
		clickById("mms_buttom_useful_sms_add_btn");

		// 添加常用语
		intoContentEditTextById("content", "这是一段测试常用语01");

		// 点击确定
		clickById("dialog_btn_positive");

		// 等待
		sleepTime(3000);

		// 向上滑
		swipeToUp();

		// 点击最后一条
		WebElement we = getWebElementInList("list_item_txt", "end");

		String str = we.getText().toString().trim();

		we.click();

		// 点击确定
		sendMMS();

		// 返回上一页
		back("tab_mms");

		// 去除信息回收站
		if (isExistenceById("tv_title")) {
			clickById("notice_delete");
		}

		// System.out.println("str " + str);
		Myassert("内容对比不一致", getTextViewNameById("subject").toString().trim()
				.equals(str));
		reportLog("编辑常用语，新增常用语");
		deleteAllMMs();
	}

	/**
	 * 编辑常用语，删除常用语
	 */
	
	public void testCase_mms_006() {
		startTestCase();
		// 清除
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 右滑
		swipeToRight("bottom");
		sleepTime(2000);

		// 验证
		Myassert("没有进入常用编辑页", isExistenceById("mms_buttom_useful_sms_edit_btn"));

		// 向上滑
		swipeToUp();

		// 点击最后一条
		WebElement we = getWebElementInList("list_item_txt", "end");

		String str = we.getText().toString().trim();

		// 判断是否为自定义常用语
		if (getNumerByText(str) > 0) {
			// 判断为有自定义的常用语，什么都不做
		}
		// 否则新建一自定义常用语
		else {
			// 点击编辑常用语
			clickById("mms_buttom_useful_sms_edit_btn");

			// 点击添加
			clickById("mms_buttom_useful_sms_add_btn");

			// 添加常用语
			intoContentEditTextById("content", "这是一段测试常用语02");

			// 点击确定
			clickById("dialog_btn_positive");

			sleepTime(2000);
		}

		// 点击编辑常用语
		clickById("mms_buttom_useful_sms_edit_btn");

		// 向上滑
		swipeToUp();

		// 获取最后一个元素
		WebElement we2 = getWebElementInList("list_item_txt", "end");

		// 判断为自定义常用语
		Myassert("最有一条常用语非自定义",
				getNumerByText(we2.getText().toString().trim()) > 0);

		// 获取最后一个元素
		WebElement del = getWebElementInList("list_item_btn", "end");

		// 删除
		del.click();

		// 点击退出编辑
		clickById("mms_buttom_useful_sms_exit_btn");

		sleepTime(2000);

		swipeToUp();
		// 再次获取最后元素
		WebElement we3 = getWebElementInList("list_item_txt", "end");
		// 判断为非自定义常用语
		Myassert("最后一条不是常用语",
				getNumerByText(we3.getText().toString().trim()) < 0);
		reportLog("编辑常用语，删除常用语");
	}

	/**
	 * 设置时间、日期方法已经实现;版本为3.9.6点击发送后，跳转到空白页，无法删除已设置的短信
	 */
	public void testCase_mms_007() {
		startTestCase();
		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 定时
		clickById("timinglayout");

		// 验证
		Myassert("没有进入时间设置页", isExistenceByName("请设定短信发送时间"));

		// 设置时间
		// setTime("16", "45");

		// 设置年份
		setDate("2017", "03", "21");

		// 点击保存
		clickById("dialog_btn_positive");

		sleepTime(3000);
		reportLog("未实现有Bug");
	}

	/**
	 * 发送表情,选择最左端
	 */
	public void testCase_mms_008() {
		startTestCase();
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 点击表情
		clickById("emoticons");

		// 验证
		Myassert("没有进入表情选项", isExistenceById("emoticon_viewpager"));

		// 点击默认
		clickById("emotionbar_radiobtn_feixin");

		// 选择表情
		selectEmoticon(0);

		// 选择表情
		selectEmoticon(1);

		// 删除第二个表情
		selectEmoticon(20);

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068051");

		// 点击发送
		sendMMS();

		sleepTime(2000);

		back("tab_mms");

		// Assert.assertTrue("发送表情错误",getTextViewNameById("subject").contains("微笑"));
		Myassert("发送表情错误", getTextViewNameById("subject").contains("微笑"));

		reportLog("发送表情,选择最左端");
		sleepTime(2000);

		deleteAllMMs();
	}

	/**
	 * 发送表情,选择最右端
	 */
	public void testCase_mms_009() {
		startTestCase();
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 点击表情
		clickById("emoticons");

		// 验证
		Myassert("没有进入表情选项", isExistenceById("emoticon_viewpager"));

		// 点击默认
		clickById("emotionbar_radiobtn_feixin");

		// 向左滑
		swipeToLeft("bottom");
		sleepTime(1000);
		swipeToLeft("bottom");
		sleepTime(1000);
		swipeToLeft("bottom");
		sleepTime(1000);

		// 选择表情
		selectEmoticon(6);

		// 选择表情
		selectEmoticon(7);

		// 删除第二个表情
		selectEmoticon(20);

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068052");

		// 点击发送
		sendMMS();

		sleepTime(2000);

		back("tab_mms");

		// Assert.assertTrue(getTextViewNameById("subject").contains("恶魔"));
		Myassert("发送表情错误", getTextViewNameById("subject").contains("恶魔"));
		reportLog("发送表情,选择最右端");
		sleepTime(2000);

		deleteAllMMs();
	}

	/**
	 * 精选短信,选择顶部
	 */
	public void testCase_mms_010() {
		startTestCase();
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 点击表情
		clickById("featuremms");

		// 验证
		Myassert("没有进入精选短信页", isExistenceByName("精选短信"));

		// 选择精选短信
		selectFeaturemms(0);

		// 选择第一个
		WebElement we = getWebElementInList("text", "start");
		String subStr = we.getText().toString().substring(0, 4);

		we.click();

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068053");

		// 点击发送
		sendMMS();

		sleepTime(2000);

		back("tab_mms");

		// Assert.assertTrue(getTextViewNameById("subject").contains(subStr));
		Myassert("内容对比不一致", getTextViewNameById("subject").contains(subStr));
		reportLog("精选短信,选择顶部");
		sleepTime(2000);

		deleteAllMMs();
	}

	/**
	 * 精选短信,选择底部
	 */
	public void testCase_mms_011() {
		startTestCase();
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项页", isExistenceById("MMS_option"));

		// 点击表情
		clickById("featuremms");

		// 验证
		Myassert("没有进入精选短信页", isExistenceByName("精选短信"));

		swipeToUp();
		sleepTime(1000);
		swipeToUp();
		sleepTime(1000);
		swipeToUp();
		sleepTime(1000);

		// 选择精选短信
		selectFeaturemms(9);

		swipeToUp();
		sleepTime(1000);
		swipeToUp();
		sleepTime(1000);
		swipeToUp();
		sleepTime(1000);
		swipeToUp();
		sleepTime(1000);

		// 选择
		WebElement we = getWebElementInList("text", "end");
		String subStr = we.getText().toString().substring(0, 4);

		we.click();

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068054");

		// 点击发送
		sendMMS();

		sleepTime(2000);

		back("tab_mms");

		// Assert.assertTrue(getTextViewNameById("subject").contains(subStr));
		Myassert("内容对比不一致", getTextViewNameById("subject").contains(subStr));
		reportLog("精选短信,选择底部");
		sleepTime(2000);

		deleteAllMMs();
	}

	/**
	 * 发彩信，选择本地图片
	 */
	@Test(groups = { "debug" })
	public void testCase_mms_012() {
		startTestCase();
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068055");

		intoContentEditTextById("embedded_text_editor", "testCase_055");

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 点击图片
		clickById("picture");

		// 本地相册
		contextMenuTitleSelect(1);
		// 选择相册

		clickByName("相册");

		// 再次选择相册
		clickByName("相册");

		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;

		Point point = new Point(width / 4, height / 2);

		sleepTime(1000);
		this.touchScreen(point);

		Point point2 = new Point(width / 2, height / 5);
		sleepTime(1000);
		this.touchScreen(point2);

		sleepTime(2000);
		// 点击完成
		clickByName("完成");

		sleepTime(3000);

		// 点击发送
		sendMMS();

		sleepTime(2000);

		back("tab_mms");

		Myassert("彩信发送失败1",
				getTextViewNameById("subject").contains("testCase_055"));
		Myassert("彩信发送失败2", isExistenceById("attachment"));
		reportLog("发彩信，选择本地图片");
		sleepTime(2000);

		deleteAllMMs();
	}

	/**
	 * 发送名片，单个
	 */
	
	public void testCase_mms_013() {
		startTestCase();
		// 清除
		deleteAllMMs();
		deleteAllContacts();

		createContacts("testCase0_056", "13522068056");
		createContacts("testCase1_056", "13522168056");

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068056");

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选项", isExistenceById("MMS_option"));

		// 点击分享名片
		clickById("send_card");

		// 验证
		Myassert("没有进入联系人选择页", isExistenceByName("联系人选择"));

		// 选择联系人数量
		addMMsContactMembers(1);

		// 点击发送
		sendMMS();

		sleepTime(2000);

		back("tab_mms");

		Myassert("发送失败", isExistenceById("from"));

		// 进入第一条短信
		clickById("from");

		String allString = getTextViewNameById("text_view");

		Myassert(
				"短信发送失败",
				(allString.contains("testCase0_056"))
						&& (allString.contains("13522068056")));
		reportLog("发送名片，单个");
		back("tab_mms");

		// 清除
		deleteAllMMs();

		deleteAllContacts();

	}

	/**
	 * 发送名片，多个
	 */
	
	public void testCase_mms_014() {
		startTestCase();
		// 清除
		deleteAllMMs();
		deleteAllContacts();

		createContacts("testCase0_057", "13522068057");
		createContacts("testCase1_057", "13522168057");
		createContacts("testCase2_057", "13522268057");

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068056");

		// 短信选项中，更多
		clickById("add_mmspart_button");

		// 验证
		Myassert("没有进入更多选择", isExistenceById("MMS_option"));

		// 点击分享名片
		clickById("send_card");

		// 验证
		Myassert("没有进入联系人选择页", isExistenceByName("联系人选择"));

		// 选择联系人数量
		addMMsContactMembers(3);

		// 点击发送
		sendMMS();

		sleepTime(2000);

		back("tab_mms");

		Myassert("短信发送失败", isExistenceById("from"));

		// 进入第一条短信
		clickById("from");

		String allString = getTextViewNameById("text_view");

		Myassert(
				"发送失败，内容不含：testCase0_057",
				(allString.contains("testCase0_057"))
						&& (allString.contains("13522068057")));
		Myassert(
				"发送失败，内容不含：testCase1_057",
				(allString.contains("testCase1_057"))
						&& (allString.contains("13522168057")));
		Myassert(
				"发送失败，内容不含：testCase2_057",
				(allString.contains("testCase2_057"))
						&& (allString.contains("13522268057")));
		reportLog("发送名片，多个");
		back("tab_mms");

		// 清除
		deleteAllMMs();

		deleteAllContacts();

	}

	/**
	 * 输入用户、内容，返回.出现草稿箱
	 */
	
	public void testCase_mms_015() {
		startTestCase();
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068058");

		intoContentEditTextById("embedded_text_editor", "testCase_058");

		back("tab_mms");

		// Assert.assertTrue("",isExistenceById("from")&&getTextViewNameById("from").contains("草稿"));
		Myassert("没有生产草稿",
				isExistenceById("from")
						&& getTextViewNameById("from").contains("草稿"));

		reportLog("输入用户、内容，返回.出现草稿箱");
		deleteAllMMs();
	}

	/**
	 * 输入用户、内容，清空，返回，不产生草稿
	 */
	
	public void testCase_mms_016() {
		startTestCase();
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068059");

		intoContentEditTextById("embedded_text_editor", "testCase_059");

		back("tab_mms");

		Myassert("没有生成草稿",
				isExistenceById("from")
						&& getTextViewNameById("from").contains("草稿"));

		// 再次进入
		clickById("from");

		// 清空内容
		intoContentEditTextById("embedded_text_editor", "");

		back("tab_mms");

		// 验证
		Myassert("草稿删除失败", isExistenceById("btResolve"));
		reportLog("输入用户、内容，清空，返回，不产生草稿");
		deleteAllMMs();
	}

	/**
	 * 输入用户、内容，清空，返回，不产生草稿
	 */
	
	public void testCase_mms_017() {
		startTestCase();
		deleteAllMMs();

		clickById("tab_mms");

		// 点击新建短信
		clickById("iab_ib_action");

		// 验证
		Myassert("没有进入新增信息页", isExistenceByName("新信息"));

		// 向输入框收入内容
		intoContentEditTextByName("收件人:", "13522068060");

		back("tab_mms");

		// 验证
		Myassert("草稿没有被删除", isExistenceById("btResolve"));

		reportLog("输入用户、内容，清空，返回，不产生草稿");

		deleteAllMMs();
	}

	/**
	 * 短信模块，全部标为已读(测试机需要安装短信生成器)
	 */
	
	public void testCase_mms_018() {
		startTestCase();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信，已经包括了清空短信
		prepareUnreadMMS();

		// 标为已读
		clickMenuAndSelect(1);

		List<WebElement> list = getLisWebElementById("unread");

		Myassert("全部标为已读失败", list.size() == 0);

		reportLog("短信模块，全部标为已读(测试机需要安装短信生成器)");

		deleteAllMMs();

	}

	/**
	 * 短信模块，未读信息(测试机需要安装短信生成器)
	 */
	
	public void testCase_mms_019() {
		startTestCase();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信，已经包括了清空短信
		int size = prepareUnreadMMS();

		// 标为未读
		clickMenuAndSelect(6);

		// 获取当前短信数量
		Myassert("未读短信数量不一致：准备的未读短信为：" + size, getMMsCount() == size);

		reportLog("短信模块，未读信息(测试机需要安装短信生成器)");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信模块，未读信息读取一条，未读短信变成已读(测试机需要安装短信生成器)
	 */
	
	public void testCase_mms_020() {
		startTestCase();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		int size = prepareUnreadMMS();

		// 标为未读
		clickMenuAndSelect(6);
		// 获取当前短信数量
		Myassert("未读短信数量不一致：准备的未读短信为：" + size, getMMsCount() == size);

		clickById("tab_mms");
		clickMenuAndSelect(6);
		List<WebElement> listFir = getLisWebElementById("from");

		String PhoneFir = listFir.get(0).getText();

		// 进入短信
		listFir.get(0).click();
		sleepTime(1000);

		// 返回未读短信
		this.backPage(1);
		Myassert("未能返回未读信息列表页", isExistenceByName("未读信息"));

		// 第二次获取
		List<WebElement> listSec = getLisWebElementById("from");

		String PhoneSec = listSec.get(0).getText();

		Myassert(
				"未读信息读取一条，未读短信未能变成已读",
				(listFir.size() == (listSec.size() + 1))
						&& !(PhoneFir.equals(PhoneSec)));

		reportLog("短信模块，未读信息读取一条，未读短信变成已读(测试机需要安装短信生成器)");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,清空信息
	 */
	
	public void testCase_mms_021() {
		startTestCase();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS();

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		String firPhone = list.get(0).getText();
		int firSize = list.size();

		list.get(0).click();

		// 选择清空信息
		clickMenuAndSelect(1);

		// 点击删除
		clickById("dialog_btn_positive");

		// 等待页面刷新
		sleepTime(3000);
		list = getLisWebElementById("from");
		String secPhone = list.get(0).getText();
		int secSize = list.size();

		// 自动返回列表
		Myassert("没有自动返回短信列表", getTextViewNameById("iab_title").equals("和通讯录"));
		Myassert("删除短信失败",
				(firSize == secSize + 1) && (!firPhone.equals(secPhone)));

		reportLog("短信对聊页,清空信息");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,新建联系人
	 */
	
	public void testCase_mms_023() {
		startTestCase();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS();

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 新建联系人
		clickMenuAndSelect(2);

		Myassert("没有进入新建联系人", getTextViewNameById("iab_title").equals("新建联系人"));

		intoContentEditTextByName("姓名", "testCase_065");

		// 点击保存
		clickById("iab_ib_action");

		Myassert("姓名保存失败",
				getTextViewNameById("iab_title").equals("testCase_065"));

		reportLog("短信对聊页,新建联系人");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,添加到已有联系人
	 */
	
	public void testCase_mms_024() {
		startTestCase();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS();

		createContacts("testCase_066", "13522068066");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 新建联系人
		clickMenuAndSelect(3);

		Myassert("没有进入新建联系人", getTextViewNameById("iab_title").equals("新建联系人"));

		Myassert("没有联系人", isExistenceById("contact_name"));

		// 选择联系人
		clickById("contact_name");

		// 点击保存
		clickById("iab_ib_action");

		Myassert("姓名保存失败",
				getTextViewNameById("iab_title").equals("testCase_066"));

		reportLog("短信对聊页,添加到已有联系人");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,加入黑名单
	 */
	
	public void testCase_mms_025() {
		startTestCase();
		deleteBlacklist();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS();

		deleteBlacklist();

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 黑名单
		clickMenuAndSelect(4);

		String tmpPhone = getTextViewNameById("iab_sub_title");

		back("tab_mms");

		OpenTabMenu("防打扰", "黑名单");

		Myassert("不存在黑名单联系人", isExistenceByName("管理黑名单"));

		Myassert("加入黑名单的联系人不一致",
				getTextViewNameById("phone_name").equals(tmpPhone));

		back("tab_mms");

		deleteBlacklist();

		reportLog("短信对聊页,加入黑名单");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,全选
	 */
	
	public void testCase_mms_026() {
		startTestCase();
		deleteAllMMs();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS("2", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 更多
		clickMenuAndSelect(5);

		// 点击全选
		clickById("mca_ib_select");

		int num = getNumerByText(getTextViewNameById("mca_title"));

		Myassert("没有全选联系人", num == 4);

		backPage(1);

		reportLog("短信对聊页,全选");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,多选
	 */
	
	public void testCase_mms_027() {
		startTestCase();
		deleteAllMMs();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS("2", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 更多
		clickMenuAndSelect(5);

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		// 点击最后两个
		ll.get(ll.size() - 1).click();

		ll.get(ll.size() - 2).click();

		int num = getNumerByText(getTextViewNameById("mca_title"));

		Myassert("没有联系人数量选择有异常", num == 2);

		backPage(1);

		reportLog("短信对聊页,多选");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,删除
	 */
	
	public void testCase_mms_028() {
		startTestCase();
		deleteAllMMs();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS("2", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 更多
		clickMenuAndSelect(5);

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		int firSize = ll.size();

		// 点击最后两个
		ll.get(firSize - 1).click();

		// 点击删除
		clickByName("删除");

		// 确认删除
		clickById("dialog_btn_positive");

		ll = getLisWebElementById("text_view");
		int secSize = ll.size();

		Myassert("短信删除失败", firSize == secSize + 1);

		reportLog("短信对聊页,删除短信");

		back("tab_mms");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,收藏
	 */
	
	public void testCase_mms_029() {
		startTestCase();
		deleteAllMMs();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS("2", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 更多
		clickMenuAndSelect(5);

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		int firSize = ll.size();

		// 点击最后
		ll.get(firSize - 1).click();

		// 点击收藏
		clickByName("收藏");

		String tmpPhone = getTextViewNameById("iab_sub_title");

		backPage(1);

		// 进入信息收藏
		clickMenuAndSelect(4);

		Myassert("未进入信息收藏页", getTextViewNameById("iab_title").equals("信息收藏"));

		Myassert("没有发现收藏的信息号码", getTextViewNameById("from").equals(tmpPhone));

		clickByName(tmpPhone);

		// 清空信息
		clickMenuAndSelect(1);

		back("tab_mms");

		reportLog("短信对聊页,收藏");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,转发（填写手机号码）
	 */
	
	public void testCase_mms_030() {
		startTestCase();
		deleteAllMMs();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS("2", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 更多
		clickMenuAndSelect(5);

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		int firSize = ll.size();

		// 点击最后
		ll.get(firSize - 1).click();

		// 点击收藏
		clickByName("转发");

		Myassert("没有进入新信息页", getTextViewNameById("iab_title").equals("新信息"));

		intoContentEditTextByName("收件人:", phone);

		// 点击发送
		sendMMS();

		sleepTime(2000);

		Myassert("没有发送成功", getTextViewNameById("iab_sub_title").equals(phone));

		back("tab_mms");

		reportLog("短信对聊页,转发（填写手机号码）");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,转发（选择分组联系人）
	 */
	
	public void testCase_mms_031() {
		startTestCase();
		deleteAllMMs();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		createContacts("testCase_073", phone);
		prepareUnreadMMS("2", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 更多
		clickMenuAndSelect(5);

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		int firSize = ll.size();

		// 点击最后
		ll.get(firSize - 1).click();

		// 点击收藏
		clickByName("转发");

		Myassert("没有进入新信息页", getTextViewNameById("iab_title").equals("新信息"));

		// 点击添加按钮
		clickById("add_recipients");

		// 点击联系人
		clickById("contact_name");

		// 点击添加
		clickById("selection_ok");

		// 点击发送
		sendMMS();

		sleepTime(2000);

		Myassert("没有发送成功", getTextViewNameById("iab_sub_title").equals(phone));

		back("tab_mms");

		reportLog("短信对聊页,转发（选择分组联系人）");

		deleteAllContacts();
		deleteAllMMs();
	}

	/**
	 * 短信对聊页,长按转发（填写手机号码）
	 */
	
	public void testCase_mms_032() {
		startTestCase();
		deleteAllMMs();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		prepareUnreadMMS("2", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		int firSize = ll.size();

		// 判断短信为自己发送的，还是接收
		if (isExistenceById("avatar_right")) {
			// 长按最后一个
			clickLongByElementUseJs(ll.get(firSize - 1));

			// 点击转发
			contextMenuTitleSelect(2);
		} else {
			// 长按最后一个
			clickLongByElementUseJs(ll.get(firSize - 1));

			// 点击转发
			contextMenuTitleSelect(1);
		}

		Myassert("没有进入新信息页", getTextViewNameById("iab_title").equals("新信息"));

		intoContentEditTextByName("收件人:", phone);

		// 点击发送
		sendMMS();

		sleepTime(2000);

		Myassert("没有发送成功", getTextViewNameById("iab_sub_title").equals(phone));

		back("tab_mms");

		reportLog("短信对聊页,长按转发（填写手机号码）");

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,长按转发（选择分组联系人）
	 */
	
	public void testCase_mms_033() {
		startTestCase();
		deleteAllMMs();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。
		setMessagePop(false);
		// 清空短信
		// 准备未读短信（保证两条以上），已经包括了清空短信
		createContacts("testCase_075", phone);
		prepareUnreadMMS("2", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		int firSize = ll.size();
		
		Myassert("短信内容为0", firSize > 0);

		// 长按最后一个
		clickLongByElementUseJs(ll.get(firSize - 1));

		// 点击转发
		contextMenuTitleSelect(1);

		Myassert("没有进入新信息页", getTextViewNameById("iab_title").equals("新信息"));

		// 点击添加按钮
		clickById("add_recipients");

		// 点击联系人
		clickById("contact_name");

		// 点击添加
		clickById("selection_ok");

		// 点击发送
		sendMMS();

		sleepTime(2000);

		Myassert("没有发送成功", getTextViewNameById("iab_sub_title").equals(phone));

		back("tab_mms");

		reportLog("短信对聊页,转发（选择分组联系人）");

		deleteAllContacts();
		deleteAllMMs();
	}

	/**
	 * 短信对聊页,长按重发（需要点击自己发送的短信）
	 */
	
	public void testCase_mms_034() {
		startTestCase();

		deleteAllMMs();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		createContacts("testCase_076", sendPhone);

		// 新建短信
		createMMs("testCase_076，重发短信测试");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		// 长按第一个
		clickLongByElementUseJs(ll.get(0));

		Myassert("没有重发按钮", getLisWebElementById("context_menu_title").get(0)
				.getText().equals("重发"));
		// 点击重发
		contextMenuTitleSelect(1);

		sleepTime(2000);

		// Assert.assertTrue("重发失败", isExistenceById("delivered_indicator"));

		reportLog("短信对聊页,长按重发（需要点击自己发送的短信）");

		deleteAllContacts();

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,长按查看信息详情
	 */
	
	public void testCase_mms_035() {
		startTestCase();

		deleteAllMMs();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		prepareUnreadMMS("3", "1");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		String currentPhone = getTextViewNameById("iab_sub_title");

		// 判断短信为自己发送的，还是接收
		if (isExistenceById("avatar_right")) {
			// 长按第一个
			clickLongByElementUseJs(ll.get(0));
			// 点击查看信息详情
			contextMenuTitleSelect(4);
		} else {
			// 长按第一个
			clickLongByElementUseJs(ll.get(0));
			// 点击查看信息详情
			contextMenuTitleSelect(3);
		}

		Myassert("没有弹出信息详情", isExistenceById("title"));

		// 是否需要添加其他验证
		Myassert("没有找到号码", getTextViewNameById("hints").contains(currentPhone));

		clickById("dialog_btn_positive");

		back("tab_mms");

		reportLog("短信对聊页,长按查看信息详情");

		deleteAllContacts();

		deleteAllMMs();
	}

	/**
	 * 短信对聊页,长按收藏短信
	 */
	
	public void testCase_mms_036() {
		startTestCase();

		deleteAllMMs();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		prepareUnreadMMS("3", "1");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		String currentPhone = getTextViewNameById("iab_sub_title");

		// 判断短信为自己发送的，还是接收
		if (isExistenceById("avatar_right")) {
			// 长按第一个
			clickLongByElementUseJs(ll.get(0));
			// 点击查看信息详情
			contextMenuTitleSelect(5);
		} else {
			// 长按第一个
			clickLongByElementUseJs(ll.get(0));
			// 点击查看信息详情
			contextMenuTitleSelect(4);
		}

		backPage(1);

		// 进入信息收藏
		clickMenuAndSelect(4);

		Myassert("未进入信息收藏页", getTextViewNameById("iab_title").equals("信息收藏"));

		Myassert("没有发现收藏的信息号码", getTextViewNameById("from")
				.equals(currentPhone));

		clickByName(currentPhone);

		// 清空信息
		clickMenuAndSelect(1);

		back("tab_mms");

		reportLog("短信对聊页,长按收藏短信");

		deleteAllContacts();

		deleteAllMMs();

	}

	/**
	 * 短信对聊页,长按删除
	 */
	
	public void testCase_mms_037() {
		startTestCase();

		deleteAllMMs();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		prepareUnreadMMS("3", "1");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		int firSize = list.size();

		list.get(0).click();

		// 点击全选
		List<WebElement> ll = getLisWebElementById("text_view");

		// 判断短信为自己发送的，还是接收
		if (isExistenceById("avatar_right")) {
			// 长按第一个
			clickLongByElementUseJs(ll.get(0));
			// 点击删除
			contextMenuTitleSelect(6);
		} else {
			// 长按第一个
			clickLongByElementUseJs(ll.get(0));
			// 点击删除
			contextMenuTitleSelect(5);
		}

		back("tab_mms");

		list = getLisWebElementById("from");

		int secSize = list.size();

		Myassert("删除短信失败", firSize == secSize + 1);

		reportLog("短信对聊页,长按删除");

		deleteAllContacts();

		deleteAllMMs();

	}

	/**
	 * 短信对聊页,拨号
	 */
	
	public void testCase_mms_038() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		prepareUnreadMMS("3", "1");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		String currentPhone = getTextViewNameById("iab_sub_title");

		clickById("iab_ib_action");

		sleepTime(2000);
		// 点击确定
		clickByName("确定");

		sleepTime(2000);

		back("tab_call");

		Myassert("没有找到拨号记录", isExistenceById("line1"));

		Myassert("拨号记录，拨打的号码不一致",
				getTextViewNameById("line1").equals(currentPhone));

		reportLog("短信对聊页,拨号");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信对聊页,点击短信的号码(只能是纯号码)-拨号
	 */
	@Test(groups = { "" })
	public void testCase_mms_040() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		createContacts("testCase_081", sendPhone);

		createMMs(phone);

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		String currentPhone = getTextViewNameById("text_view").toString()
				.trim();

		clickById("text_view");

		sleepTime(2000);

		Myassert("没有弹出选择框", isExistenceById("title"));
		Myassert("不是对短信上的号码进行操作",
				getTextViewNameById("title").contains(currentPhone));

		// 打电话
		contextMenuTitleSelect(1);

		clickById("iab_ib_action");

		sleepTime(2000);
		// 点击确定
		clickByName("确定");

		sleepTime(2000);

		back("tab_call");

		Myassert("没有找到拨号记录", isExistenceById("line1"));

		Myassert("拨号记录，拨打的号码不一致",
				getTextViewNameById("line1").equals(currentPhone));

		reportLog("短信对聊页,点击号码选择拨号");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信对聊页,点击短信的号码(只能是纯号码)-发短信
	 */
	
	public void testCase_mms_041() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		createContacts("testCase_082", sendPhone);

		createMMs(phone);

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		String currentPhone = getTextViewNameById("text_view").toString()
				.trim();

		clickById("text_view");

		Myassert("没有弹出选择框", isExistenceById("title"));
		Myassert("不是对短信上的号码进行操作",
				getTextViewNameById("title").contains(currentPhone));

		// 发短信
		contextMenuTitleSelect(2);

		Myassert("没有进入新建短信页",
				getTextViewNameById("iab_sub_title").contains(currentPhone));

		intoContentEditTextById("embedded_text_editor",
				"testCase_082,点击短信的号码(只能是纯号码)-发短信");

		sendMMS();

		back("tab_mms");

		Myassert("没有找到新号码的短信",
				searListContainName(getLisWebElementById("from"), currentPhone));

		reportLog("对聊页， 点击短信的号码(只能是纯号码)-发短信");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信对聊页,点击短信的号码(只能是纯号码)-添加为联系人
	 */
	
	public void testCase_mms_042() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		createContacts("testCase_083", sendPhone);

		createMMs(phone);

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		String currentPhone = getTextViewNameById("text_view").toString()
				.trim();

		clickById("text_view");

		Myassert("没有弹出选择框", isExistenceById("title"));
		Myassert("不是对短信上的号码进行操作",
				getTextViewNameById("title").contains(currentPhone));

		// 添加为联系人
		contextMenuTitleSelect(3);

		Myassert("没有进入新建联系人页", getTextViewNameById("iab_title").equals("新建联系人"));

		intoContentEditTextByName("姓名", "testCase01_083");

		clickById("iab_ib_action");

		sleepTime(2000);

		back("tab_contacts");

		Myassert(
				"没有找到新号码的联系人",
				searListContainName(getLisWebElementById("contact_name"),
						"testCase01_083"));

		reportLog("短信对聊页,点击号码选择添加为联系人");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信对聊页,点击短信的号码(只能是纯号码)-复制
	 */
	
	public void testCase_mms_043() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信。

		createContacts("testCase_084", sendPhone);

		createMMs(phone);

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		list.get(0).click();

		String currentPhone = getTextViewNameById("text_view").toString()
				.trim();

		clickById("text_view");

		Myassert("没有弹出选择框", isExistenceById("title"));
		Myassert("不是对短信上的号码进行操作",
				getTextViewNameById("title").contains(currentPhone));

		// 添加复制
		contextMenuTitleSelect(4);

		// 粘贴到输入框
		pasteString("embedded_text_editor");

		sendMMS();

		// 获取列表
		List<WebElement> ll = getLisWebElementById("text_view");

		Myassert("没有复制成功", ll.size() == 2);

		Myassert(
				"复制的内容不一致",
				ll.get(0).getText().toString().trim()
						.equals(ll.get(1).getText().toString().trim()));

		back("tab_mms");

		reportLog("短信对聊页,点击号码选择添加为联系人");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信列表,搜索短信，搜索条件号码或内容
	 */
	
	public void testCase_mms_044() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信
		prepareUnreadMMS("7", "2");

		createMMs(phone, "testCase_085：短信列表,搜索短信内容：是我就是我；搜索条件号码 : " + sendPhone);

		clickById("tab_mms");

		// 搜索框输入搜索内容：内容中的号码
		intoContentEditTextById("contact_search_bar", sendPhone);

		Myassert("没有搜索到相关的结果", isExistenceById("sms_search"));
		Myassert("搜索结果中，不含搜索内容",
				getTextViewNameById("subject").contains(sendPhone));

		// 搜索框输入搜索内容：发送者号码
		intoContentEditTextById("contact_search_bar", phone);

		Myassert("没有搜索到相关的结果", isExistenceById("sms_search"));
		Myassert("搜索结果中，不含搜索内容", getTextViewNameById("from").contains(phone));

		// 搜索框输入搜索内容：内容前部分内容
		intoContentEditTextById("contact_search_bar", "testCase_085");

		Myassert("没有搜索到相关的结果", isExistenceById("sms_search"));
		Myassert("搜索结果中，不含搜索内容",
				getTextViewNameById("subject").contains("testCase_085"));

		// 搜索框输入搜索内容：内容后部分的内容
		intoContentEditTextById("contact_search_bar", "是我就是我");

		Myassert("没有搜索到相关的结果", isExistenceById("sms_search"));
		Myassert("搜索结果中，不含搜索内容",
				getTextViewNameById("subject").contains("是我就是我"));

		back("tab_mms");

		reportLog("短信列表,搜索短信，搜索条件号码或内容");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信列表,加入黑名单（长按短信）
	 */
	
	public void testCase_mms_045() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信
		prepareUnreadMMS("3", "1");

		deleteBlacklist();

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		WebElement we = list.get(0);

		String currentPhone = we.getText().toString().trim();

		// 长按第一个
		clickLongByElementUseJs(we);

		clickByName("加入黑名单");

		OpenTabMenu("防打扰", "黑名单");

		Myassert("不存在黑名单联系人", isExistenceByName("管理黑名单"));

		Myassert("加入黑名单的联系人不一致",
				currentPhone.contains(getTextViewNameById("phone_name")));

		back("tab_mms");

		deleteBlacklist();

		reportLog("短信列表,加入黑名单（长按短信）");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信列表,标为已读（长按短信）
	 */
	
	public void testCase_mms_046() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信
		prepareUnreadMMS("7", "4");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("unread");

		int size = list.size() - 1;
		// System.out.println("size= " + size);

		Myassert("不存在未读短信", (size >= 0));

		for (int i = size; i >= 0; i--) {
			// 长按
			clickLongByElementUseJs(list.get(i));
			sleepTime(1000);

			clickByName("标记为已读");
			sleepTime(1000);
		}

		Myassert("仍有未读短信 ", !isExistenceById("unread"));

		reportLog("短信列表,标为已读（长按短信）");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信列表,批量回复（长按短信）
	 */
	
	public void testCase_mms_047() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信
		prepareUnreadMMS("2", "1");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		String phonestring = new String("");
		// 为了方便，添加一段字符串中
		for (WebElement we : list) {

			phonestring = phonestring + we.getText() + ";";
		}

		System.out.println("查找的字符串：" + phonestring);

		clickLongByElementUseJs(list.get(0));

		// 点击全选
		clickById("mca_ib_select");

		clickByName("批量回复");

		Myassert("没有进入新信息页", isExistenceById("iab_title"));
		Myassert("进入页面错误", getTextViewNameById("iab_title").equals("新信息"));

		intoContentEditTextById("embedded_text_editor", "testCase_088: 批量回复");

		sendMMS();

		List<WebElement> toList = getLisWebElementById("to_contact_name");

		for (int j = 0; j <= toList.size() - 1; j++) {
			Myassert("号码中没有包含：" + toList.get(j).getText(),
					phonestring
							.contains(getNumerByText(toList.get(j).getText())
									+ ""));
		}

		backPage(2);

		reportLog("短信列表,批量回复（长按短信）");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();

	}

	/**
	 * 短信列表,删除（长按短信）
	 */
	
	public void testCase_mms_048() {
		startTestCase();

		deleteAllMMs();
		deleteAllCall();
		deleteAllContacts();
		// 环境准备
		// 接收短信时需要关闭弹窗提醒。才可生产未读短信
		prepareUnreadMMS("4", "1");

		clickById("tab_mms");

		List<WebElement> list = getLisWebElementById("from");

		clickLongByElementUseJs(list.get(0));

		// 点击全选
		clickById("mca_ib_select");

		clickByName("删除");

		// 确定删除
		clickById("dialog_btn_positive");

		sleepTime(3000);

		Myassert("删除短信失败", isExistenceById("btResolve"));

		reportLog("短信列表,删除（长按短信）");

		deleteAllContacts();
		deleteAllCall();
		deleteAllMMs();
	}



}
