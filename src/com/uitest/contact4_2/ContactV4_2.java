package com.uitest.contact4_2;
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
		String testName = "testCase_001";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		openContact();
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
	 * 创建联系人
	 */
	public void testCase_001() {
		TabConact4_2 tc = new TabConact4_2();
		tc.newContact("chen","1353333");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		exitApp();
	}
}
