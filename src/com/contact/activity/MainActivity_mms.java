package com.contact.activity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.uiautomatorUtil.ElementManager;

public class MainActivity_mms extends UiAutomatorTestCase{
/**
 * 
 *  拨号盘页面：
	 属性：
		常用固定号码如：10086、10010、10000
		常用暗码：*#06#、*#*#4636#*#*
		组件ID: 页面各个组件ID按功能命名
		页面对象：页面各个UI对象
	 方法：
		输入号码
		清除号码、删除一个号码
		拨号
		其他设置（添加联系人、暂停、等待、发送短信）
		选择号码
 * 
 * 
 * 
 */
	
	/**
	 * 短信新建，输入号码，短信内容，点击发送。
	 * 
	 * @param phone
	 * @param content
	 */
	public static void createMMs(String phone, String content) {
		
		ElementManager.clickById("tab_mms");
		
		//点击新建
		ElementManager.clickById("iab_ib_action");
		
		// 向输入框收入内容
		ElementManager.inputTextByName("收件人:", phone);
		
		// 输入短信内容
		ElementManager.inputTextById("embedded_text_editor", content);
		
		// 点击确定
		ElementManager.clickByName("发送");
		
	}

	/**
	 * 获取短信列表中，联系人图标坐标列表，空值返回null
	 * 
	 * @return
	 */
	public static List<Point> getMMsPoint() {

		List<Point> list = new ArrayList<Point>();

		for (WebElement webElement : getAllImageView()) {
			String str = webElement.getAttribute("resourceId");
			String subStr = str.substring(str.indexOf('/') + 1);
			if (subStr.equals("avatar")) {
				// System.out.println(webElement.getAttribute("resourceId"));
				// System.out.println(webElement.getLocation());
				list.add(webElement.getLocation());
			}
		}
		// 如果没有联系人
		if (list.size() == 0) {
			// 返回null
			return null;
		} else {
			// 否则返回列表null
			return list;
		}
	}

	/**
	 * 获取短信列表中的数量，通过获取头像的控件来获取数量，超于一页的联系人数量无法获取。
	 */
	public static int getMMsCount() {
		if(isExistenceById("btResolve")){
			System.out.println("短信数量为0");
			return 0;
		}
		
		// 获取列表个数
		List<Point> list = getMMsPoint();

		// 判断返回列表个数
		if (list == null) {
			System.out.println("getMMsCount(): " + 0);
			return 0;
		} else {
			System.out.println("getMMsCount(): " + list.size());
			return list.size();
		}
	}

	/**
	 * 清除联系人列表中所有的短信
	 */
	public static void deleteAllMMs() {
		System.out.println("[start] deleteAllMMs");
		back("tab_mms");

		// 如果发现无短信，马上退出
		if (isExistenceById("btResolve")) {
			System.out.println("[ end ] deleteAllMMs");
			return;
		}

		for (int i = 0; i < 3; i++) {
			sleepTime(2000);
			// 第一次获取，清除列表中异常短信
			clearSpecialMMs(driver.findElementsById("from"));

			// 如果发现无短信，马上退出
			if (isExistenceById("btResolve")) {
				System.out.println("[ end ] deleteAllMMs");
				return;
			}

			// 再次获取列表
			List<WebElement> list = driver.findElementsById("from");

			// 获取列表长度
			int size = list.size();

			if (size > 1) {
				// 点击一个联系人，全选-删除
				clickLongByElementUseJs(list.get(0));

				// 点击全选
				clickById("mca_ib_select");

				// 点击删除
				clickById("mca_del");

				// 点击确认删除
				clickById("dialog_btn_positive");

				// 去除信息回收站
				if (isExistenceById("tv_title")) {
					clickById("notice_delete");
				}
				sleepTime(2000);
			} else if (size == 1) {
				// 只有条短信
				clickLongByIdUseJs("from");

				// 点击删除
				clickById("mca_del");

				// 点击确认删除
				clickById("dialog_btn_positive");

				// 去除信息回收站
				if (isExistenceById("tv_title")) {
					clickById("notice_delete");
				}
				sleepTime(2000);
			} else {
				// 没有联系人
				System.out.println("[ end ] deleteAllMMs");

				sleepTime(2000);
				return;
			}
		}
		System.out.println("[ end ] deleteAllMMs");
		sleepTime(2000);
	}

	/**
	 * 清除特殊类型的短信
	 */
	public static void clearSpecialMMs(List<WebElement> list) {
		System.out.println("[start] clearSpecialMMs");

		WebElement we = getWebElementInList(list, "139邮件提醒");
		if (we != null) {
			// 点击元素
			we.click();

			Assert.assertTrue(isExistenceByName("139邮件提醒"));

			// 清空记录
			clickMenuAndSelect(1);

			// 点击清空
			clickById("dialog_btn_positive");
			sleepTime(15000);

			back("tab_mms");
		}

		WebElement we1 = getWebElementInList(list, "通知短信归档");

		if (we1 != null) {
			// 点击元素
			we1.click();

			Assert.assertTrue(isExistenceByName("通知短信归档"));

			// 批量删除
			clickMenuAndSelect(1);

			// 点击更多
			clickById("mca_ib_select");

			// 点击删除
			clickById("mca_sure");

			// 确认删除
			clickById("dialog_btn_positive");

			sleepTime(30000);

			back("tab_mms");
		}

		System.out.println("[ end ] clearSpecialMMs");
	}

	
	
	
}
