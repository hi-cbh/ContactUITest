package com.uitest.contact.traversal;

import java.util.ArrayList;
import java.util.List;

import android.os.RemoteException;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManagerLog;
import com.uitest.util.UiAutomatorHelper;

/**
 * 没有 算法的遍历，实验V1.0
 * @author Administrator
 *
 */
public class TraversalNoalgorithm extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "Traversal";
		String testClass = "com.uitest.contact.traversal.Traversal";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testTraversal() throws RemoteException {

		DriverManager.pressHome();

		ElementManagerLog.clickByName("和通讯录");
		
		sleep(5000);
		
		List<UiObject> uol = getListObject("com.chinamobile.contacts.im:id/tab_bar_view","android.widget.RelativeLayout");
		
		for(int i = 0; i < uol.size(); i++){
			ElementManagerLog.clickbyObject(uol.get(i));
			sleep(1000);
		}
	
	}

	public void testCall_001(){
		DriverManager.pressHome();

		ElementManagerLog.clickByName("和通讯录");
		
		sleep(5000);
		
		ElementManagerLog.clickByName("拨号");
		
		
		////清空通话记录
		//取消
		ElementManagerLog.clickById("iab_ib_more");
		ElementManagerLog.clickByName("清空通话记录");
		ElementManagerLog.clickById("dialog_btn_negative");
		
		//确定
		ElementManagerLog.clickById("iab_ib_more");
		ElementManagerLog.clickByName("清空通话记录");
		ElementManagerLog.clickById("dialog_btn_positive");
		
		
		////点击未接来电
		ElementManagerLog.clickById("iab_ib_more");
		ElementManagerLog.clickByName("未接来电");
		DriverManager.pressBack();
		
		
		////点击通话设置
		ElementManagerLog.clickById("iab_ib_more");
		ElementManagerLog.clickByName("通话设置");
		
		List<UiObject> uol = getListObject("android:id/content","android.widget.CheckBox");
		
		//点击两次
		for(int i = 0; i < uol.size(); i++){
			ElementManagerLog.clickbyObject(uol.get(i));
			sleep(1000);
			
			ElementManagerLog.clickbyObject(uol.get(i));
			sleep(1000);
		}
		
		DriverManager.pressBack();

	}
	
	public void testCall_002(){
		DriverManager.pressHome();

		ElementManagerLog.clickByName("和通讯录");
		
		sleep(3000);
		
		ElementManagerLog.clickByName("拨号");
		
		
		if(ElementManagerLog.isExistById("btn_backspace")){
			
		}
		else
		{
			ElementManagerLog.clickByName("拨号");
		}
		
		//
		List<UiObject> uol = getListObject("com.chinamobile.contacts.im:id/dialpad_layout","android.widget.ImageButton");
		
		for(int i = 0; i < uol.size(); i++){
			ElementManagerLog.clickbyObject(uol.get(i));
			sleep(500);
		}

		//新建联系人
		ElementManagerLog.clickByName("添加为联系人");
		
		ElementManagerLog.clickByName("新建联系人");
		
		ElementManagerLog.clickByName("完成");
		
		sleep(3000);
		
		DriverManager.pressBack();
		
		ElementManagerLog.clickByName("取消");
		
		DriverManager.pressBack();
		
		ElementManagerLog.clickByName("确定");
		
		//添加到已有联系人
		ElementManagerLog.clickByName("添加为联系人");
		
		ElementManagerLog.clickByName("添加到已有联系人");
		
		DriverManager.pressBack();
		
		//点击发短信
		ElementManagerLog.clickByName("发短信");
		
		//
		ElementManagerLog.clickByName("发送");
		
		DriverManager.pressBack();
	}
	
	
	/**
	 * 获取对象中，加入list中
	 * 
	 * @param id       父控件
	 * @param destClass 子控件
	 * @return
	 */
	public List<UiObject> getListObject(String id, String destClass) {
		UiCollection collection = new UiCollection(
				new UiSelector().resourceId(id));
		UiObject CheckObject = null;

		int num1 = collection.getChildCount(new UiSelector()
				.className(destClass));

		System.out.println("cnt: " + num1);

		List<UiObject> uolist = new ArrayList<UiObject>();

		try {
			if (num1 == 0) {
				return null;
			}

			for (int i = 0; i < num1; i++) {
				CheckObject = collection.getChildByInstance(
						new UiSelector().className(destClass), i);
				uolist.add(CheckObject);
			}

		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
		return uolist;
	}

}
