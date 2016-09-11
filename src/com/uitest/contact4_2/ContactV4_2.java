package com.uitest.contact4_2;

import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.contact.activity.MainActivity_contact;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.AssertUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;

import com.uitest.util.UiAutomatorHelper;


/**
 * 和通讯录，android V4.2基本模块用例
 * @author Administrator
 *
 */
public class ContactV4_2 extends SimpleCode420{

	public static void main(String[] args) {
		String jarName = "ContactV4_2";
		String testClass = "com.uitest.contact.testcase.ContactV4_2";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

		
		@Override
		protected void setUp() throws Exception {
			super.setUp();
			openContact();
		}
		
//		/**
//		 * 登录时延，和通讯录
//		 * @throws RemoteException
//		 */
//		public void testCase_001() throws RemoteException {
//			Logout();
//			Login(UserConfig.LoginName,UserConfig.LoginPwd);
//		}
//		

		
		/**
		 * 手势滑动侧边栏与拨号页、联系人、信息切换。
		 */
		public void testCase_other_001() {
			//返回
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
		
//		
//		//------------------------拨号模块测试用------------------------------------//
//		
//		
//		/**
//		 * 通话记录-陌生人-新建联系人 拨号盘中，创建联系人,输入号码，添加为联系人，并保存
//		 */
//		
//		public void testCase_call_001() {
//			
//			setCallShockAndVoice(false);
//			// 清理
//			deleteAllContacts();
//			deleteAllCall();
//			ElementManager.clickById("tab_call");
//
//			// 点击拨号
//			ElementManager.clickById("tab_call");
//
//			// 点击联系人
//			ElementManager.clickById("tab_contacts");
//
//			// 点击拨号
//			ElementManager.clickById("tab_call");
//
//			// 点击输入框
//			ElementManager.clickById("digits");
//
//			// 点击键盘数字
//			// tab_dialer 拨号
//			// action_sms 发短信
//			touchCallNumber("13822138001");
//
//			// 验证拨号页没有改号码
//			// Assert.assertTrue(driver.findElementByName("添加为联系人").isDisplayed());
//			// 环境准备
//			if (!getElementsByClassAndIndex("android.widget.TextView", 0).equals(
//					"saveAsContact")) {
//
//				sleep(2000);
//				// 点击存在的联系人
//				ElementManager.clickById("call_detail");
//				// 点击菜单，选择删除
//				clickMenuAndSelect(2);
//
//				// 点击确认
//				ElementManager.clickByName("删除");
//			}
//
//			// 点击添加为联系人
//			ElementManager.clickByName("添加为联系人");
//
//			// 添加新建联系人
//			ElementManager.clickByName("新建联系人");
//
//			// 判断当前页面为新建联系人
//			Myassert("没有进入新建联系人页", driver.findElementByName("新建联系人").isDisplayed());
//
//			// 获取界面所有的EditView元素
//			List<WebElement> editText = driver
//					.findElementsByClassName("android.widget.EditText");
//
//			// 第一个元素收入
//			editText.get(0).sendKeys("saveAsContact");
//
//			// 点击屏幕，功能缺陷
//			touchWindows();
//
//			// 点击保存
//			ElementManager.clickById("iab_ib_action");
//
//			sleep(2000);
//
//			// 判读联系是否被创建
//			// Assert.assertTrue(this.searchContact("saveAsContact", 0));
//			Myassert("联系人没有被创建：saveAsContact", searchContact("saveAsContact", 0));
//			sleep(2000);
//
//			// 清理联系人
//			// this.deleteContactsByPhone("13822138001");
//			deleteAllContacts();
//			deleteAllCall();
//			reportLog("拨号盘中，创建联系人,输入号码，添加为联系人，并保存");
//		}
//
//		/**
//		 * 通话记录-陌生人-添加到已有联系人 添加为已有联系人
//		 */
//		
//		public void testCase_call_002() {
//			
//			// 清理
//			deleteAllContacts();
//			deleteAllCall();
//			MainActivity_contact.back("tab_call");
//
//			// 添加测试数据
//			this.createContacts("saveContacts", "13824452646");
//
//			// 点击拨号
//			ElementManager.clickById("tab_call");
//
//			// 点击联系人
//			ElementManager.clickById("tab_contacts");
//
//			// 点击拨号
//			ElementManager.clickById("tab_call");
//
//			// 点击输入框
//			ElementManager.clickById("digits");
//
//			// 点击键盘数字
//			touchCallNumber("84850922");
//
//			// 点击添加为联系人
//			ElementManager.clickByName("添加为联系人");
//
//			// 添加新建联系人
//			ElementManager.clickByName("添加到已有联系人");
//
//			// 判断当前页面为新建联系人
//			Myassert("没有进入新建联系人", driver.findElementByName("新建联系人").isDisplayed());
//
//			intoContentEditTextById("contact_search_bar", "13824452646");
//
//			searchWebElement("saveContacts").click();
//
//			Myassert("没有进入编辑联系人", driver.findElementByName("编辑联系人").isDisplayed());
//
//			// 点击保存
//			ElementManager.clickById("iab_ib_action");
//
//			sleep(2000);
//
//			// deleteContactsByName("saveContacts");
//			// 清理
//			deleteAllContacts();
//			deleteAllCall();
//			reportLog("通话记录-陌生人-添加到已有联系人");
//		}
//
//		/**
//		 * 拨号盘 -搜索本地联系人（按拼音或号码搜索） 本地联系人检测
//		 */
//		
//		public void testCase_call_003() {
//			
//			// boolean bl;
//			// 清理
//			deleteAllContacts();
//			deleteAllCall();
//			MainActivity_contact.back("tab_call");
//
//			// 创建本地联系人
//			createContacts("通讯录", "13800138000");
//
//			// 点击拨号
//			ElementManager.clickById("tab_call");
//
//			// 点击联系人
//			ElementManager.clickById("tab_contacts");
//
//			// 点击拨号
//			ElementManager.clickById("tab_call");
//
//			// 点击输入框
//			ElementManager.clickById("digits");
//
//			// 点击键盘数字
//			touchCallNumber("138001");
//
//			// bl = this.searchContact("通讯录", 0);
//			// Assert.assertTrue(bl);
//			Myassert("搜索失败，没有找到该联系人：通讯录", searchContact("通讯录", 0));
//
//			// 清空输入框内容
//			this.clickLongByIdUseJs("btn_backspace");
//
//			// 点击键盘数字
//			touchCallNumber("001380");
//
//			// bl = this.searchContact("通讯录", 0);
//			// Assert.assertTrue(bl);
//			Myassert("搜索失败，没有找到该联系人：通讯录", searchContact("通讯录", 0));
//
//			// 清空输入框内容
//			this.clickLongByIdUseJs("btn_backspace");
//
//			// 点击键盘数字
//			touchCallNumber("138000");
//
//			// bl = this.searchContact("通讯录", 0);
//			// Assert.assertTrue(bl);
//			Myassert("搜索失败，没有找到该联系人：通讯录", searchContact("通讯录", 0));
//
//			// 清空输入框内容
//			this.clickLongByIdUseJs("btn_backspace");
//
//			// 点击键盘数字,tongx转化为键盘数字为86649
//			touchCallNumber("86649");
//
//			// bl = this.searchContact("通讯录", 0);
//			// Assert.assertTrue(bl);
//			Myassert("搜索失败，没有找到该联系人：通讯录", searchContact("通讯录", 0));
//
//			// 清空输入框内容
//			this.clickLongByIdUseJs("btn_backspace");
//
//			// 点击键盘数字,txl转化为键盘数字为895
//			touchCallNumber("895");
//
//			// bl = this.searchContact("通讯录", 0);
//			// Assert.assertTrue(bl);
//			Myassert("搜索失败，没有找到该联系人：通讯录", searchContact("通讯录", 0));
//
//			// 清空输入框内容
//			this.clickLongByIdUseJs("btn_backspace");
//
//			// 点击键盘数字,xunlu转化为键盘数字为98658
//			touchCallNumber("98658");
//
//			// bl = this.searchContact("通讯录", 0);
//			// Assert.assertTrue(bl);
//			Myassert("搜索失败，没有找到该联系人：通讯录", searchContact("通讯录", 0));
//
//			// 清空输入框内容
//			this.clickLongByIdUseJs("btn_backspace");
//
//			sleep(3000);
//
//			// 删除联系人
//			// deleteContactsByPhone("13800138000");
//			deleteAllContacts();
//
//			reportLog("拨号盘 -搜索本地联系人（按拼音或号码搜索）");
//		}
//
//		/**
//		 * 将拨号记录中一号码添加到黑名单 通话记录-陌生人-加入黑名单（详细页，选择加入黑名单）
//		 */
//		
//		public void testCase_call_004() {
//			
//			// 清理
//			deleteAllContacts();
//
//			MainActivity_contact.back("tab_call");
//
//			// 进入管理黑名单
//			OpenTabMenu("防打扰", "黑名单");
//
//			// 搜索当前页面是否含有该号码记录
//			if (searchContact("13813881499", 0)) {
//				// 点击清空
//				ElementManager.clickById("iab_ib_action");
//
//				// 点击清空
//				ElementManager.clickByName("清空");
//			}
//
//			// 返回主界面
//			MainActivity_contact.back("tab_call");
//
//			// 清空所有通话记录
//			deleteAllCall();
//
//			// 添加数据
//			callNumber("13813881499");
//
//			// 点击拨号详细记录
//			ElementManager.clickById("call_detail");
//
//			// 点击加入黑名单
//			clickMenuAndSelect(4);
//
//			// 返回主界面
//			driver.sendKeyEvent(AndroidKeyCode.BACK);
//			sleep(1000);
//
//			// 进入管理黑名单
//			OpenTabMenu("防打扰", "黑名单");
//
//			// 检测当前界面为防打扰页
//			Myassert("没有进入黑名单管理页", driver.findElementByName("管理黑名单").isDisplayed());
//
//			boolean bl = searchContact("13813881499", 0);
//
//			// 检测当前是否存储骚扰电话
//			// Assert.assertTrue(bl);
//			Myassert("黑名单中，没有找到该联系人：13813881499", bl);
//
//			sleep(1000);
//
//			// 清空数据
//			if (bl) {
//				// 点击清空
//				ElementManager.clickById("iab_ib_action");
//
//				// 点击清空
//				ElementManager.clickById("dialog_btn_positive");
//			}
//			// 返回主界面
//			MainActivity_contact.back("tab_call");
//
//			// 清空所有通话记录
//			deleteAllCall();
//
//			reportLog("通话记录-陌生人-加入黑名单（详细页，选择加入黑名单）");
//		}
//
//		/**
//		 * 1标记为广告推销且勾选加入黑名单 通话记录-陌生人-标记
//		 */
//		
//		public void testCase_call_005() {
//			
//			MainActivity_contact.back("tab_call");
//			// 清空所有通话记录
//			deleteAllCall();
//
//			// 添加数据
//			callNumber("13813881423");
//
//			// 点击拨号详细记录
//			ElementManager.clickById("call_detail");
//
//			// 点击标记
//			clickMenuAndSelect(3);
//
//			// 广告推销
//			ElementManager.clickByName("广告推销");
//
//			// 同时加入黑名单
//			ElementManager.clickByName("同时加入黑名单");
//
//			// 点击确定
//			ElementManager.clickByName("确定");
//
//			sleep(3000);
//
//			// 验证号码是否标记
//			// Assert.assertTrue(getTextViewNameById("call_stranger_detail_company").contains("广告推销"));
//			boolean b0 = getTextViewNameById("call_stranger_detail_company")
//					.contains("广告推销");
//			Myassert("没有标记", b0);
//
//			// 返回主界面
//			MainActivity_contact.back("tab_call");
//
//			// 进入管理黑名单
//			OpenTabMenu("防打扰", "黑名单");
//
//			// 检测当前界面为防打扰页
//			Myassert("没有进入黑名单管理页", driver.findElementByName("管理黑名单").isDisplayed());
//
//			boolean bl = searchContact("13813881423", 0);
//
//			// 检测当前是否存储骚扰电话
//			// Assert.assertTrue(bl);
//			Myassert("黑名单中，没有找到该联系人：13813881423", bl);
//
//			sleep(1000);
//
//			// 清空数据
//			if (bl) {
//				// 点击清空
//				ElementManager.clickById("iab_ib_action");
//
//				// 点击清空
//				ElementManager.clickById("dialog_btn_positive");
//			}
//			// 返回主界面
//			MainActivity_contact.back("tab_call");
//
//			// 点击拨号详细记录
//			ElementManager.clickById("call_detail");
//
//			// 点击取消标记
//			clickMenuAndSelect(3);
//
//			// 返回主界面
//			MainActivity_contact.back("tab_call");
//
//			// 清空记录
//			deleteAllCall();
//
//			reportLog("通话记录-陌生人-标记");
//		}
//
//		/**
//		 * 长按号码，将其添加到黑名单 拨号 - 更多操作- 加入黑名单（长按记录，选择加入黑名单）
//		 */
//		
//		public void testCase_call_006() {
//			
//			MainActivity_contact.back("tab_call");
//			// 清空黑名单管理内容
//			deleteBlacklist();
//
//			// 清空所有通话记录
//			deleteAllCall();
//
//			// 添加数据
//			callNumber("13813881423");
//
//			// 长按号码
//			this.clickLongByElementUseJs(this.searchWebElement("13813881423"));
//
//			// 点击加入黑名单按钮
//			ElementManager.clickById("mca_msg_txt");
//
//			// 长按号码
//			this.clickLongByElementUseJs(this.searchWebElement("13813881423"));
//
//			sleep(1000);
//
//			// 验证
//			// Assert.assertTrue(getTextViewNameById("mca_msg_txt").contains("取消黑名单"));
//			Myassert("取消黑名单失败", getTextViewNameById("mca_msg_txt")
//					.contains("取消黑名单"));
//
//			// 点击加入取消黑名单
//			ElementManager.clickById("mca_msg_txt");
//
//			// 清空所有通话记录
//			deleteAllCall();
//
//			reportLog("拨号 - 更多操作- 加入黑名单（长按记录，选择加入黑名单）");
//		}
//
//		/**
//		 * 添加IP拨号，选择17951 拨号 - 更多操作 - IP拨号-选择已有的前缀
//		 */
//		
//		public void testCase_call_007() {
//			
//			MainActivity_contact.back("tab_call");
//			// 清空所有通话记录
//			deleteAllCall();
//
//			// 添加数据
//			callNumber("13813881420");
//
//			// 长按号码
//			this.clickLongByElementUseJs(this.searchWebElement("13813881420"));
//
//			// 点击IP拨号
//			ElementManager.clickById("mca_call_txt");
//
//			// 判断是否存在多个自定义前缀
//			if (isExistenceById("del_voip_phone")) {
//				// 点击清除
//				ElementManager.clickById("del_voip_phone");
//
//				// 点击删除
//				ElementManager.clickByName("删除");
//
//				// 长按号码
//				this.clickLongByElementUseJs(this.searchWebElement("13813881420"));
//
//				// 点击IP拨号
//				ElementManager.clickById("mca_call_txt");
//			}
//
//			// 在弹窗选择
//			menuList("add_text", 1);
//
//			sleep(3000);
//			// 点击点击确定
//			ElementManager.clickByName("确定");
//
//			// Assert.assertTrue(getTextViewNameById("line1").contains("17951"));
//			Myassert("没有找到拨号记录中，含有IP号码：17951", getTextViewNameById("line1")
//					.contains("17951"));
//
//			// 清空所有通话记录
//			deleteAllCall();
//
//			reportLog("拨号 - 更多操作 - IP拨号-选择已有的前缀");
//		}
//
//		/**
//		 * 添加IP拨号，添加自定义前缀 拨号 - 更多操作 - IP拨号-选择手动添加的前缀
//		 */
//		
//		public void testCase_call_008() {
//			
//			MainActivity_contact.back("tab_call");
//			String tmpNum = "13813771420";
//			// 清空所有通话记录
//			deleteAllCall();
//
//			// 添加数据
//			callNumber(tmpNum);
//
//			// 长按号码
//			this.clickLongByElementUseJs(this.searchWebElement(tmpNum));
//
//			// 点击IP拨号
//			ElementManager.clickById("mca_call_txt");
//
//			// 判断是否存在多个自定义前缀
//			if (isExistenceById("del_voip_phone")) {
//				// 点击清除
//				ElementManager.clickById("del_voip_phone");
//
//				// 点击删除
//				ElementManager.clickByName("删除");
//
//				// 长按号码
//				this.clickLongByElementUseJs(this.searchWebElement(tmpNum));
//
//				// 点击IP拨号
//				ElementManager.clickById("mca_call_txt");
//
//			}
//
//			// 点击添加前缀号码
//			ElementManager.clickById("add_voip_phone");
//
//			// 输入内容
//			this.intoContentEditTextById("content", "138438");
//
//			// 点击确定
//			ElementManager.clickByName("确定");
//
//			sleep(3000);
//
//			// 点击点击确定
//			ElementManager.clickByName("确定");
//
//			// Assert.assertTrue(getTextViewNameById("line1").contains("138438"));
//			Myassert("没有找到拨号记录中，含有IP号码：138438", getTextViewNameById("line1")
//					.contains("138438"));
//
//			reportLog("拨号 - 更多操作 - IP拨号-选择手动添加的前缀");
//		}
//
//		/**
//		 * 拨打本地联系人号码 拨号- 拨打本地联系人
//		 */
//		
//		public void testCase_call_009() {
//			
//			deleteAllContacts();
//			MainActivity_contact.back("tab_call");
//
//			// 准备数据，创建联系人
//			this.createContacts("testCase_call_009", "13504168016");
//
//			// 点击拨号
//			displaykeyboardCall();
//
//			// 点击输入框
//			ElementManager.clickById("digits");
//
//			// 点击键盘数字
//			touchCallNumber("13504");
//
//			// 点击搜索记录，
//			ElementManager.clickById("listview_rl");
//
//			sleep(2000);
//			// 点击确定
//			ElementManager.clickByName("确定");
//
//			sleep(2000);
//
//			// Assert.assertTrue(this.searchContact("testCase016", 0));
//			Myassert("没有找到测试数据：testCase_call_009",
//					searchContact("testCase_call_009", 0));
//
//			// 清空拨号记录
//			this.deleteAllCall();
//
//			// 删除联系人
//			// this.deleteContactsByName("testCase016");
//			deleteAllContacts();
//			reportLog("拨号- 拨打本地联系人");
//		}
//
//		/**
//		 * 本地联系人通话记录，加入白名单 拨号 - 加入白名单
//		 */
//		
//		public void testCase_call_010() {
//			
//
//			deleteAllContacts();
//			MainActivity_contact.back("tab_call");
//
//			this.createContacts("testCase_call_010", "13533168167");
//
//			// 点击显示拨号盘
//			displaykeyboardCall();
//
//			// 点击输入框
//			ElementManager.clickById("digits");
//
//			// 点击键盘数字
//			touchCallNumber("13533");
//
//			// 点击搜索记录，
//			ElementManager.clickById("listview_rl");
//
//			sleep(2000);
//			// 点击确定
//			ElementManager.clickByName("确定");
//
//			sleep(2000);
//
//			// 点击拨号详细记录
//			ElementManager.clickById("call_detail");
//
//			// 点击加入白名单
//			clickMenuAndSelect(4);
//
//			// 返回主界面
//			MainActivity_contact.back("tab_call");
//
//			// 进入管理白名单
//			OpenTabMenu("防打扰", "白名单");
//
//			// 检测当前界面为防打扰页
//			Myassert("没有进入白名单管理页", driver.findElementByName("管理白名单").isDisplayed());
//
//			boolean bl = searchContact("13533168167", 0);
//
//			// 检测当前是否存储骚扰电话
//			// Assert.assertTrue(bl);
//			this.Myassert("没有找到联系人：13533168167", bl);
//
//			sleep(1000);
//
//			// 清空数据
//			if (bl) {
//				// 点击清空
//				ElementManager.clickById("iab_ib_action");
//
//				// 点击清空
//				ElementManager.clickById("dialog_btn_positive");
//			}
//			// 返回主界面
//			MainActivity_contact.back("tab_call");
//
//			// this.deleteContactsByName("testCase017");
//			deleteAllContacts();
//			deleteAllCall();
//
//			reportLog("拨号 - 加入白名单");
//		}
//
//		/**
//		 * 拨号修改编辑 通话记录-本地联系人-编辑
//		 */
//		
//		public void testCase_call_011() {
//			
//			deleteAllContacts();
//			String casename = getTestCaseName();
//			String casephone = sendPhone;
//			
//			MainActivity_contact.back("tab_call");
//
//			this.createContacts(casename, casephone);
//
//			// 点击拨号
//			displaykeyboardCall();
//
//			// 点击输入框
//			ElementManager.clickById("digits");
//
//			// 点击键盘数字
//			touchCallNumber(casephone);
//
//			// 点击搜索记录，
//			getLisWebElementById("listview_rl").get(0).click();
//
//			sleep(2000);
//			// 点击确定
//			ElementManager.clickByName("确定");
//
//			sleep(2000);
//
//			// 点击拨号详细记录
//			ElementManager.clickById("call_detail");
//
//			// 点击编辑
//			ElementManager.clickById("iab_ib_action");
//
//			// 获取界面所有的EditView元素
//			List<WebElement> editText = driver
//					.findElementsByClassName("android.widget.EditText");
//
//			// clearText(editText.get(4).getAttribute("text"));
//			editText.get(4).sendKeys("13522168199");
//
//			// 点击保存
//			ElementManager.clickById("iab_ib_action");
//
//			sleep(3000);
//
//			// 返回拨号页
//			MainActivity_contact.back("tab_call");
//
//			displaykeyboardCall();
//
//			// 点击输入框
//			ElementManager.clickById("digits");
//
//			// 点击键盘数字
//			touchCallNumber("13522168199");
//
//			// Assert.assertTrue(this.searchContact("testCase018", 0));
//			Myassert("没有找到联系人：testCase018", searchContact("testCase_call_011", 0));
//
//			ElementManager.clickById("tab_contacts");
//
//			// this.deleteContactsByName("testCase018");
//			deleteAllContacts();
//			// 进入拨号
//			ElementManager.clickById("tab_call");
//
//			// 清除记录
//			this.deleteAllCall();
//
//			reportLog("通话记录-本地联系人-编辑");
//		}
//
//		/**
//		 * 拨号页，删除联系人 通话记录-本地联系人-删除联系人
//		 */
//		
//		public void testCase_call_012() {
//			
//
//			deleteAllContacts();
//			MainActivity_contact.back("tab_call");
//			this.createContacts("testCase_call_012", "13500168169");
//
//			displaykeyboardCall();
//
//			// 点击输入框
//			ElementManager.clickById("digits");
//
//			// 点击键盘数字
//			touchCallNumber("13500");
//
//			// 点击搜索记录，
//			ElementManager.clickById("listview_rl");
//
//			sleep(2000);
//			// 点击确定
//			ElementManager.clickByName("确定");
//
//			sleep(2000);
//
//			// 点击拨号详细记录
//			ElementManager.clickById("call_detail");
//
//			// 点击删除联系人
//			clickMenuAndSelect(2);
//
//			// 点击删除
//			ElementManager.clickByName("删除");
//
//			// 切换到联系人页
//			ElementManager.clickById("tab_contacts");
//
//			// 搜索当前页面
//			// Assert.assertTrue(!this.searchContact("13500168169", 0));
//			Myassert("联系人删除失败：13500168169", !this.searchContact("13500168169", 0));
//			// 进入拨号
//			ElementManager.clickById("tab_call");
//
//			// 清除记录
//			this.deleteAllCall();
//
//			reportLog("通话记录-本地联系人-删除联系人");
//		}
//
//		/**
//		 * 一键拨号-设置快捷拨号-从联系人列表选择
//		 */
//		@Test(groups = { "call","fixed" })
//		public void testCase_call_013() {
//			
//			MainActivity_contact.back("tab_call");
//			String name = "num";
//			String phone = "1353316816";
//			// 创建数据
//			createDate(name, phone);
//
//			// 已经包含清除
//			List<Point> poList = getPointList();
//
//			// 切换到拨号页
//			ElementManager.clickById("tab_call");
//
//			// 选择一键拨号
//			clickMenuAndSelect(2);
//
//			// 验证当前页
//			Myassert("当前页面不在一键拨号设置页", driver.findElementByName("一键拨号设置")
//					.isDisplayed());
//
//			int i = 0;
//			for (Point point : poList) {
//				sleep(3000);
//				i++;
//				// 不执行第一个元素
//				if (i == 1) {
//					continue;
//				}
//
//				// 点击屏幕
//				touchScreen(point);
//
//				// 从联系人列表获得
//				contextMenuTitleSelect(1);
//
//				// 在搜索框内输入
//				intoContentEditTextById("contact_search_bar", name + i);
//
//				// 选中联系人
//				searchWebElement(name + i).click();
//
//				// 点击添加
//				ElementManager.clickById("selection_ok");
//
//				Myassert("没有找到该联系人：" + (name + i),
//						driver.findElementByName(name + i).isDisplayed());
//
//			}
//
//			// 清除一键拨号设置
//			deleteAllOneCall();
//
//			MainActivity_contact.back("tab_call");
//
//			// 清除数据
//			deleteAllContacts();
//			reportLog("一键拨号-设置快捷拨号-从联系人列表选择");
//		}
//
//		/**
//		 * 一键拨号-设置快捷拨号-键盘输入
//		 */
//		@Test(groups = { "call","fixed" })
//		public void testCase_call_014() {
//			
//			MainActivity_contact.back("tab_call");
//			String name = "num";
//			String phone = "1353316816";
//			// 创建数据
//			createDate(name, phone);
//
//			// 已经包含清除
//			List<Point> poList = getPointList();
//
//			// 切换到拨号页
//			ElementManager.clickById("tab_call");
//
//			// 选择一键拨号
//			clickMenuAndSelect(2);
//
//			// 验证当前页
//			Myassert("没有进入一键拨号设置页", driver.findElementByName("一键拨号设置")
//					.isDisplayed());
//
//			int i = 0;
//			for (Point point : poList) {
//				sleep(3000);
//				i++;
//				// 不执行第一个元素
//				if (i == 1) {
//					continue;
//				}
//
//				// 点击屏幕
//				touchScreen(point);
//
//				// 从联系人列表获得
//				contextMenuTitleSelect(2);
//
//				// 在搜索框内输入
//				intoContentEditTextById("content", phone + i);
//
//				// 点击添加
//				ElementManager.clickById("dialog_btn_positive");
//
//				Myassert("没有找到该联系人：" + (name + i),
//						driver.findElementByName(name + i).isDisplayed());
//
//			}
//
//			// 清除一键拨号设置
//			deleteAllOneCall();
//
//			MainActivity_contact.back("tab_call");
//
//			// 清除数据
//			deleteAllContacts();
//
//			reportLog("一键拨号-设置快捷拨号-键盘输入");
//
//		}
//
//		/**
//		 * 一键拨号-拨打快捷拨号
//		 */
//		@Test(groups = { "call","fixed" })
//		public void testCase_call_015() {
//			
//			MainActivity_contact.back("tab_call");
//			String name = "num";
//			String phone = "1353316816";
//
//			// 创建数据
//			createDate(name, phone);
//
//			// 已经包含清除
//			List<Point> poList = getPointList();
//			ArrayList<String> strArray = getNumberList();
//
//			// 切换到拨号页
//			ElementManager.clickById("tab_call");
//
//			// 选择一键拨号
//			clickMenuAndSelect(2);
//
//			// 验证当前页
//			// Assert.assertTrue(driver.findElementByName("一键拨号设置").isDisplayed());
//			Myassert("没有进入一键拨号设置页", driver.findElementByName("一键拨号设置")
//					.isDisplayed());
//
//			int i = 0;
//			for (Point point : poList) {
//				sleep(3000);
//				i++;
//				// 不执行第一个元素
//				if (i == 1) {
//					continue;
//				}
//
//				// 点击屏幕
//				touchScreen(point);
//
//				// 从联系人列表获得
//				contextMenuTitleSelect(2);
//
//				// 在搜索框内输入
//				intoContentEditTextById("content", phone + i);
//
//				// 点击添加
//				ElementManager.clickById("dialog_btn_positive");
//
//				// Assert.assertTrue(driver.findElementByName(name +
//				// i).isDisplayed());
//
//				Myassert("没有找到该联系人：" + (name + i),
//						driver.findElementByName(name + i).isDisplayed());
//			}
//			MainActivity_contact.back("tab_call");
//
//			int j;
//			for (j = 0; j < 8; j++) {
//
//				displaykeyboardCall();
//				// 长按菜单
//				clickLongByIdUseJs(strArray.get(j));
//
//				sleep(2000);
//
//				ElementManager.clickByName("确定");
//
//				// Assert.assertTrue(searchContact("num"+(j+2), 0));
//				Myassert("没有找到联系人：" + "num" + (j + 2),
//						searchContact("num" + (j + 2), 0));
//				deleteAllCall();
//
//			}
//
//			// 清除一键拨号设置
//			deleteAllOneCall();
//
//			MainActivity_contact.back("tab_call");
//
//			// 清除数据
//			deleteAllContacts();
//
//			reportLog("一键拨号-拨打快捷拨号");
//		}
//
//		/**
//		 * 一键拨号-未设置-手动输入
//		 */
//		@Test(groups = { "call","fixed" })
//		public void testCase_call_016() {
//			
//			MainActivity_contact.back("tab_call");
//			String name = "num";
//			String phone = "1353316816";
//
//			// 创建数据
//			createDate(name, phone);
//
//			// 切换到拨号页
//			ElementManager.clickById("tab_call");
//
//			// 选择一键拨号
//			clickMenuAndSelect(2);
//
//			// 清空所有已设置按钮
//			deleteAllOneCall();
//			ArrayList<String> strArray = getNumberList();
//
//			MainActivity_contact.back("tab_call");
//
//			for (int i = 0; i < 8; i++) {
//
//				displaykeyboardCall();
//
//				// 长按数字按钮
//				clickLongByIdUseJs(strArray.get(i));
//
//				// 验证弹窗
//				// Assert.assertTrue(driver.findElementByName("温馨提示").isDisplayed());
//				this.Myassert("没有弹出提示", driver.findElementByName("温馨提示")
//						.isDisplayed());
//				// 点击确认
//				ElementManager.clickByName("是");
//
//				// 手动输入
//				contextMenuTitleSelect(2);
//
//				// 输入框添加号码
//				intoContentEditTextById("content", phone + (i + 2));
//
//				// 点击添加
//				ElementManager.clickById("dialog_btn_positive");
//
//				// Assert.assertTrue(searchContact("num"+(i+2), 0));
//				this.Myassert("没有找到测试数据：" + "num" + (i + 2),
//						searchContact("num" + (i + 2), 0));
//
//				// 返回
//				MainActivity_contact.back("tab_call");
//			}
//
//			// 清除数据
//			deleteAllContacts();
//			reportLog("一键拨号-未设置-手动输入");
//		}
//
//		/**
//		 * 一键拨号-未设置-从联系人列表获得
//		 */
//		@Test(groups = { "call","fixed" })
//		public void testCase_call_017() {
//			
//			MainActivity_contact.back("tab_call");
//			String name = "num";
//			String phone = "1353316816";
//
//			// 创建数据
//			createDate(name, phone);
//
//			// 切换到拨号页
//			ElementManager.clickById("tab_call");
//
//			// 选择一键拨号
//			clickMenuAndSelect(2);
//
//			// 清空所有已设置按钮
//			deleteAllOneCall();
//			ArrayList<String> strArray = getNumberList();
//
//			MainActivity_contact.back("tab_call");
//
//			for (int i = 0; i < 8; i++) {
//				// 显示
//				displaykeyboardCall();
//
//				// 长按数字按钮
//				clickLongByIdUseJs(strArray.get(i));
//
//				// 验证弹窗
//				Myassert("没有弹出提示", driver.findElementByName("温馨提示").isDisplayed());
//
//				// 点击确认
//				ElementManager.clickByName("是");
//
//				// 手动输入
//				contextMenuTitleSelect(1);
//
//				// 在搜索框内输入
//				intoContentEditTextById("contact_search_bar", name + (i + 2));
//
//				// 选中联系人
//				searchWebElement(name + (i + 2)).click();
//
//				// 点击添加
//				ElementManager.clickById("selection_ok");
//
//				Myassert("没有找到测试数据：" + (name + (i + 2)),
//						driver.findElementByName(name + (i + 2)).isDisplayed());
//
//				// 返回
//				MainActivity_contact.back("tab_call");
//			}
//
//			// 清除数据
//			deleteAllContacts();
//			reportLog("一键拨号-未设置-从联系人列表获得");
//		}
//
//		
//		/**
//		 * 通话记录-陌生人(发短信)
//		 */
//		
//		public void testCase_call_018(){
//			
//			String testphone = sendPhone;
//			// 清空
//			deleteAllCall();
//			deleteAllMMs();
//			deleteAllContacts();
//			prepareUnreadCall(testphone, 15, 3, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			sleep(2000);
//			
//			Myassert("没有生成测试用的号码：" + testphone, isExistenceById("line1") && getTextViewNameById("line1").equals(testphone));
//			
//			ElementManager.clickById("call_detail");
//			
//			Myassert("没有进入陌生人详情页", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("陌生人详情"));
//			
//			//点击信息
//			ElementManager.clickById("sms");
//			
//			Myassert("没有进入新建信息页", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("陌生人"));
//			
//			//输入短信内容
//			intoContentEditTextById("embedded_text_editor", "testCase_call_018");
//			
//			//点击发送
//			sendMMS();
//
//			
//			MainActivity_contact.back("tab_mms");
//			
//			Myassert("没有发送短信", isExistenceById("from") && getTextViewNameById("from").contains(testphone));
//			
//			reportLog("通话记录-陌生人(发短信)");
//			
//			deleteAllCall();
//			deleteAllMMs();
//			deleteAllContacts();
//			
//		}
//		
//		/**
//		 * 通话记录-本地联系人(分享名片)
//		 */
//		
//		public void testCase_call_019(){
//			
//			String casephone = sendPhone;
//			String casename = getTestCaseName();
//			
//			// 清空
//			deleteAllCall();
//			deleteAllMMs();
//			deleteAllContacts();
//			//准备数据
//			createContacts(casename, casephone);
//			prepareUnreadCall(casephone, 15, 3, 1);
//
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			Myassert("没有进入联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//			
//			//分享名片
//			clickMenuAndSelect(1);
//			
//			Myassert("没有弹出选择分享软件", getTextViewNameById("android:id/alertTitle").equals("选择分享"));
//			
//			ElementManager.clickByName("和通讯录");
//			
//			sleep(1000);
//			
//			Myassert("没有进入新信息页", isExistenceById("iab_title") && getTextViewNameById("iab_title").equals("新信息"));
//			
//			intoContentEditTextByName("收件人:", phone);
//			
//			//点击发送
//			sendMMS();
//			
//			MainActivity_contact.back("tab_mms");
//			
//			Myassert("没有发送短信", isExistenceById("from") && getTextViewNameById("from").contains(phone));
//			
//			ElementManager.clickById("from");
//			
//			String text = getTextViewNameById("text_view");
//			String adr = "http://pim.10086.cn/wapdownload.php ";
//			
//			Myassert("分享名片内容没有对应手机号" + casename, text.contains(casename));
//			Myassert("分享名片内容没有对应名称" + casephone, text.contains(casephone));
//			Myassert("分享名片内容没有对应地址" + adr, text.contains(adr));
//			
//			reportLog("通话记录-本地联系人(分享名片)");
//			MainActivity_contact.back("tab_call");
//			deleteAllCall();
//			deleteAllMMs();
//			deleteAllContacts();
//			
//		}
//		
//		/**
//		 * 通话记录-本地联系人(群组选择-选择已有)
//		 */
//		
//		public void testCase_call_020(){
//			
//			String casephone = sendPhone;
//			String casename = getTestCaseName();
//			String casegroup = getTestGroupName();
//			
//			clearGroup();
//			// 清空
//			deleteAllCall();
//			deleteAllMMs();
//			deleteAllContacts();
//			//准备数据
//			createContacts(casename, casephone);
//			prepareUnreadCall(casephone, 15, 3, 1);
//
//			MainActivity_contact.back("tab_contacts");
//			createGroup(casegroup, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			Myassert("没有进入联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//			
//			//分
//			clickMenuAndSelect(3);
//			
//			Myassert("没有进入分组选择", getTextViewNameById("iab_title").equals("分组选择"));
//
//			//选择分组
//			getLisWebElementById("check_group_select").get(getGroupNum(casegroup)).click();
//			
//			sleep(2000);
//			
//			Myassert("没有选择分组", getLisWebElementById("group_choice_ok_btn").get(0).getAttribute("enabled").equals("true"));
//			
//			ElementManager.clickById("group_choice_ok_btn");
//			
//			//自动返回联系人详情页
//			Myassert("没有自动返回联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//			
//			Myassert("联系人分组中，没有还有分组信息：" + casegroup, getTextViewNameById("contact_detail_groups_name").contains(casegroup));
//			
//			MainActivity_contact.back("tab_contacts");
//			
//			clearGroup();
//			
//			reportLog("通话记录-本地联系人(群组选择-选择已有)");
//			
//			deleteAllCall();
//			deleteAllMMs();
//			deleteAllContacts();
//		}
//		
//		
//
//		/**
//		 * 通话记录-本地联系人(群组选择-选择新建)
//		 */
//		
//		public void testCase_call_021(){
//			
//			String casephone = sendPhone;
//			String casename = getTestCaseName();
//			String casegroup = getTestGroupName();
//			
//			clearGroup();
//			// 清空
//			deleteAllCall();
//			deleteAllMMs();
//			deleteAllContacts();
//			//准备数据
//			createContacts(casename, casephone);
//			prepareUnreadCall(casephone, 15, 3, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			Myassert("没有进入联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//			
//			//
//			clickMenuAndSelect(3);
//			
//			Myassert("没有进入分组选择", getTextViewNameById("iab_title").equals("分组选择"));
//
//			//点击新增
//			ElementManager.clickById("iab_ib_more");
//			
//			//新建分组
//			Myassert("没有进入新建分组", getTextViewNameById("title").equals("新建分组"));
//			
//			//输入分组名
//			intoContentEditTextById("content", casegroup);
//			
//			//点击保存
//			ElementManager.clickById("dialog_btn_positive");
//			
//			//点击确定
//			ElementManager.clickById("group_choice_ok_btn");
//			
//			sleep(2000);
//			
//			//自动返回联系人详情页
//			Myassert("没有自动返回联系人详情页", getTextViewNameById("iab_title").equals("联系人详情"));
//			
//			Myassert("联系人分组中，没有还有分组信息：" + casegroup, getTextViewNameById("contact_detail_groups_name").contains(casegroup));
//			
//			MainActivity_contact.back("tab_contacts");
//			
//			clearGroup();
//			
//			reportLog("通话记录-本地联系人(群组选择-选择新建)");
//			
//			deleteAllCall();
//			deleteAllMMs();
//			deleteAllContacts();
//		}
//		
//		/**
//		 * 更多操作(一键拨号-1号按钮不可设置)
//		 */
//		@Test(groups = { "call" ,"fixed"})
//		public void testCase_call_022(){
//			
//
//			// 切换到拨号页
//			MainActivity_contact.back("tab_call");
//
//			// 选择一键拨号
//			clickMenuAndSelect(2);
//
//			// 验证当前页
//			Myassert("没有进入一键拨号设置页", driver.findElementByName("一键拨号设置")
//					.isDisplayed());
//			
//			Myassert("语音信箱能设置的1号数字", !isExistenceById("title"));
//			
//			MainActivity_contact.back("tab_call");
//			
//			reportLog("更多操作(一键拨号-1号按钮不可设置)");
//		}
//		
//		/**
//		 * 拨号盘-拨打陌生人
//		 */
//		
//		public void testCase_call_023(){
//			
//			String casephone = phone;
//			
//			deleteAllCall();
//			deleteAllContacts();
//			
//			// 切换到拨号页
//			MainActivity_contact.back("tab_call");
//			
//			//显示键盘
//			displaykeyboardCall();
//			
//			//点击键盘
//			touchCallNumber(casephone);
//			
//			//点击拨号
//			ElementManager.clickById("tab_dialer");
//			
//			sleep(1000);
//			
//			// 点击点击确定
//			ElementManager.clickByName("确定");
//			
//			// 切换到拨号页
//			MainActivity_contact.back("tab_call");
//			
//			Myassert("没有找到拨号记录", getTextViewNameById("line1").contains(casephone));
//			
//			deleteAllCall();
//			
//			reportLog("拨号盘-拨打陌生人");
//		}
//		
//		/**
//		 * 拨号盘-拨打USSD(*#06#)
//		 */
//		
//		public void testCase_call_024(){
//			
//			String casephone = "*#06#";
//			
//			deleteAllCall();
//			deleteAllContacts();
//			
//			// 切换到拨号页	
//			MainActivity_contact.back("tab_call");
//			
//			//显示键盘
//			displaykeyboardCall();
//			
//			//点击键盘
//			touchCallNumber(casephone);
//			
//			sleep(1000);
//
//			Myassert("没有弹出国际移动设备识别码", getTextViewNameById("title").contains("国际移动设备识别码"));
//			
//			// 点击点击确定
//			ElementManager.clickByName("确定");
//			
//			ElementManager.clickById("tab_contacts");
//			//切换模块，消除拨号
//			ElementManager.clickById("tab_call");
//			
//			sleep(1000);
//			
//			deleteAllCall();
//			
//			reportLog("拨号盘-拨打USSD(*#06#)");
//		}
//		
//		
//		/**
//		 * 通话记录-未接来电页-最新记录显示标识-列表顶部
//		 */
//		
//		public void testCase_call_025(){
//			
//			String casephone = sendPhone;
//			String casephone2 = phone;
//			
//			
//			deleteAllCall();
//			deleteAllContacts();
//			
//			//准备测试数据
//			prepareUnreadCall(casephone, 15, 3, 1);
//			
//			prepareUnreadCall(casephone2, 15, 3, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			Myassert("最新拨号记录没有标注： " + casephone2, getFirstCallRecorder().contains(casephone2));
//			
//			sleep(2000);
//			
//			deleteAllCall();
//			
//			reportLog("通话记录-未接来电页-最新记录显示标识-列表顶部");
//		}
//		
//		/**
//		 * 通话记录-未接来电页-最新记录显示标识-点击后消失
//		 */
//		
//		public void testCase_call_026(){
//			
//			String casephone = sendPhone;
//			
//			deleteAllCall();
//			deleteAllContacts();
//			
//			//准备测试数据
//			prepareUnreadCall(casephone, 15, 3, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			Myassert("没有生成未读的未接来电", isExistenceById("tvStrangeMark"));
//			
//			ElementManager.clickById("line1");
//			
//			sleep(2000);
//			
//			ElementManager.clickByName("确定");
//			
//			MainActivity_contact.back("tab_call");
//			
//			Myassert("未读的未接来电的标识仍存在", !isExistenceById("tvStrangeMark"));
//			
//			sleep(2000);
//			
//			deleteAllCall();
//			
//			reportLog("通话记录-未接来电页-最新记录显示标识-点击后消失");
//		}
//		
//		
//		/**
//		 * 通话记录-回拨-陌生号码
//		 */
//		
//		public void testCase_call_027(){
//			
//			String casephone = sendPhone;
//			
//			deleteAllCall();
//			deleteAllContacts();
//			
//			//准备测试数据
//			prepareUnreadCall(casephone, 15, 3, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("line1");
//			
//			sleep(2000);
//			
//			ElementManager.clickByName("确定");
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			sleep(1000);
//			
//			Myassert("没有对该号码进行回拨：" + casephone, isExistenceById("duration")&&getTextViewNameById("duration").contains("未接通"));
//			
//			MainActivity_contact.back("tab_call");
//			
//			deleteAllCall();
//			
//			reportLog("通话记录-回拨-陌生号码");
//		}
//		
//
//		/**
//		 * 通话记录-回拨-本地联系人号码
//		 */
//		
//		public void testCase_call_028(){
//			
//			String casephone = sendPhone;
//			String casename = this.getTestCaseName();
//			
//			deleteAllCall();
//			deleteAllContacts();
//			
//			//准备测试数据
//			prepareUnreadCall(casephone, 15, 3, 1);
//			createContacts(casename, casephone);
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("line1");
//			
//			sleep(2000);
//			
//			ElementManager.clickByName("确定");
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			sleep(1000);
//			
//			Myassert("没有对该号码进行回拨：" + casephone, getTextViewNameById("duration").contains("未接通"));
//			
//			MainActivity_contact.back("tab_call");
//			
//			deleteAllCall();
//			deleteAllContacts();
//			
//			reportLog("通话记录-回拨-本地联系人号码");
//		}
//		
//		/**
//		 * 通话记录-时间，地区
//		 */
//		
//		public void testCase_call_029(){
//			
//			String casephone = sendPhone;
//			String date;
//			String txttime;
//			
//			deleteAllCall();
//			
//			//准备测试数据
//			date = prepareUnreadCall(casephone, 15, 3, 1);
//			txttime = this.getSubString(date, "_", 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			Myassert("生成时间与显示时间不对应：" + txttime, isExistenceById("date") && getTextViewNameById("date").equals(txttime));
//			
//			Myassert("拨号记录中的地区显示有误(对应手机号)：" + casephone, isExistenceById("loc")&&getTextViewNameById("loc").contains("广州"));
//			
//			deleteAllCall();
//
//			reportLog("通话记录-时间，地区");
//		}
//		
//		
//		/**
//		 * 通话记录-通话记录类型-已接-回拨
//		 * 
//		 */
//		
//		public void testCase_call_030(){
//			
//			String casephone = sendPhone;
//			
//			deleteAllCall();
//			
//			//准备测试数据
//			//准备测试数据
//			prepareUnreadCall(casephone, 15, 1, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("line1");
//			
//			sleep(2000);
//			
//			ElementManager.clickByName("确定");
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			sleep(1000);
//			
//			Myassert("没有对该号码进行回拨：" + casephone, isExistenceById("duration")&&getTextViewNameById("duration").contains("未接通"));
//			
//			MainActivity_contact.back("tab_call");
//			
//			deleteAllCall();
//			
//			reportLog("通话记录-通话记录类型-已接-回拨");
//		}
//		
//		/**
//		 * 通话记录-通话记录类型-已拨-回拨
//		 * 
//		 */
//		
//		public void testCase_call_031(){
//			
//			String casephone = sendPhone;
//			
//			deleteAllCall();
//			
//			//准备测试数据
//			prepareUnreadCall(casephone, 15, 2, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("line1");
//			
//			sleep(2000);
//			
//			ElementManager.clickByName("确定");
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			sleep(1000);
//			
//			Myassert("没有对该号码进行回拨：" + casephone, isExistenceById("duration")&&getTextViewNameById("duration").contains("未接通"));
//			
//			MainActivity_contact.back("tab_call");
//			
//			deleteAllCall();
//			
//			reportLog("通话记录-通话记录类型-已拨-回拨");
//		}
//		
//		/**
//		 * 通话记录-通话记录类型-未接来电-已读-回拨
//		 * 
//		 */
//		
//		public void testCase_call_032(){
//			
//			String casephone = sendPhone;
//			
//			deleteAllCall();
//			
//			//准备测试数据
//			//准备测试数据
//			prepareUnreadCall(casephone, 15, 3, 1);
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("line1");
//			
//			sleep(2000);
//			
//			ElementManager.clickByName("确定");
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			sleep(1000);
//			
//			Myassert("没有对该号码进行回拨：" + casephone, isExistenceById("duration")&&getTextViewNameById("duration").contains("未接通"));
//			
//			MainActivity_contact.back("tab_call");
//			
//			deleteAllCall();
//			
//			reportLog("通话记录-通话记录类型-未接来电-已读-回拨");
//		}
//		
//		/**
//		 * 通话记录-通话记录类型-未接来电-未读-回拨
//		 * 
//		 */
//		
//		public void testCase_call_033(){
//			
//			String casephone = sendPhone;
//			
//			deleteAllCall();
//			
//			//准备测试数据
//			prepareUnreadCall(casephone, 15, 3, 2);
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("line1");
//			
//			sleep(2000);
//			
//			ElementManager.clickByName("确定");
//			
//			MainActivity_contact.back("tab_call");
//			
//			ElementManager.clickById("call_detail");
//			
//			sleep(1000);
//			
//			Myassert("没有对该号码进行回拨：" + casephone, isExistenceById("duration")&&getTextViewNameById("duration").contains("未接通"));
//			
//			MainActivity_contact.back("tab_call");
//			
//			deleteAllCall();
//			
//			reportLog("通话记录-通话记录类型-未接来电-未读-回拨");
//		}
//		
//		
//		
		
		@Override
		protected void tearDown() throws Exception {
			super.tearDown();
			exitApp();
		}
	

	
	
	
}
