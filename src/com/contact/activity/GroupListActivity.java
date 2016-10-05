package com.contact.activity;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.UiAutomatorHelper;

public class GroupListActivity extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "GroupListActivity";
		String testClass = "com.contact.activity.GroupListActivity";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testDemo() {

		createGroup("testGroup");

	}

	/**
	 * 创建分组
	 */
	public  void createGroup(String name){

		ElementManager.clickByName("新建分组");
		
		ElementManager.inputTextById("content", name);
		
		ElementManager.clickByName("保存");
		

	}
	
	
	/**
	 * 清除所有不相干的分组
	 */
	public  void clearGroup() {

		int num = 0;
		int cnt;
		for (; num < 3; num++) {

			cnt = ElementManager.getChildCountByClassId("ListView",
					"txt_group_name");
			// System.out.println("cnt: " + cnt);

			if (cnt <= 5) {
				return;
			} else if (cnt >= 9) {
				cnt = 8;
			}

			UiObject uo = null;
			String name = "";

			try {
				for (int i = cnt; i > 0; i--) {

					uo = ElementManager.getUiObjectByClassId("ListView",
							"txt_group_name", i);
					name = uo.getText();

					if (!isContains(name)) {
						// 长按分组名
						ElementManager.clickLongByUiObject(uo);
						// 点击解散分组
						ElementManager.clickByName("解散分组");
						// 点击解散
						ElementManager.clickByName("解散");
					}
				}
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 判断字符含有字符
	 * 
	 * @param name
	 * @return
	 */
	public  boolean isContains(String name) {
		if (name.contains("未分组") || name.contains("紧急联系人")
				|| name.contains("家人") || name.contains("好友")
				|| name.contains("同事")) {
			return true;
		}
		return false;
	}

}
