package com.contact.activity;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.util.UiAutomatorHelper;

/**
 * 分组activity.4.2版本添加
 * @author Administrator
 *
 */
public class GroupListActivity extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "GroupListActivity";
		String testClass = "com.contact.activity.GroupListActivity";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testDemo() throws UiObjectNotFoundException {

		
		System.out.println("pai "+ getGroupRank("家庭"));

	}

	public int getGroupRank(String groupname){
		
		UiCollection collection = new UiCollection(
				new UiSelector().className("android.widget.ListView"));
		UiObject CheckObject = null;
		
		try {

			for (int i = 0; i < 10; i++) {
				//System.out.println("i: " + i);
				CheckObject = collection.getChildByInstance(
						new UiSelector().resourceId("com.chinamobile.contacts.im:id/txt_group_name"), i);
				if (CheckObject.getText().equals(groupname)) {
					return i+1;
				}
			}
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
			//System.out.println("炸不到");
		}
		return -1;
	}
	
	
	/**
	 * 分组排序
	 * @param groupName  排序名称
	 * @param direction  移动方向，1向上，2向下
	 */
	public void groupSort(String groupName, int direction) {
		//获取分组名对象
		UiObject uo1 = ElementManager.getUiObjectByText(groupName);
		//获取游标对象
		UiObject uo = ElementManager.getSameLineObjectById(uo1, "com.chinamobile.contacts.im:id/drag_handle", 0, 0);
		
		try {
			
			int x1 = uo.getBounds().centerX();
			int y1 = uo.getBounds().centerY();
			
			int x2 = x1;
			
			int y2=y1;
			
			switch(direction){
			case 1:
				y2 = 0;
				break;
				
			case 2:
				y2 = y1 * 5;
				break;
			}
		
			DriverManager.swipe(x1, y1, x2, y2);
			
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
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
			System.out.println("cnt: " + cnt);

			if (cnt <= 5) {
				return;
			} else if (cnt >= 8) {
				cnt = 8;
			}

			UiObject uo = null;
			String name = "";

			try {
				for (int i = cnt-1; i > 0; i--) {
					System.out.println("i: " + i);
					uo = ElementManager.getUiObjectByClassId("ListView","txt_group_name", i);
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
				|| name.contains("家庭") || name.contains("朋友")
				|| name.contains("同事")) {
			return true;
		}
		return false;
	}

}
