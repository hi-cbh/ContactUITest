package com.uitest.util;

import android.net.ParseException;
import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.uiautomatorUtil.FileManager;
import com.uitest.uiautomatorUtil.TestListenerManager;
import com.uitest.uiautomatorUtil.TimeUtil;

public class TestContactBase extends TestListenerManager {
	
	String packageName = UserConfig.packageName;

	/**
	 * 打开和通讯录
	 */
	public void openContact() {
		 findAndOpenApp("和通讯录");
		 sleep(2000);
		 
		 String curpackageName=UiDevice.getInstance().getCurrentPackageName();
		 assertEquals("openContact error ",packageName, curpackageName);
	}
	

	
	/**
	 * 输入用户、密码，登录
	 * 
	 * @param username
	 * @param password
	 */
	public void Login(String username, String password) {

		// 点击和通讯录
		ElementManager.clickById("iab_title");

		// 判断是否为登录状态，若未登录状态，进行下一步；否则返回
		if (!isLoginState()) {
			// 点击设置
			ElementManager.clickById("setting_layout");
			// 点击登录
			ElementManager.clickById("setting_item_login");
			// 点击互联网登录
			ElementManager.clickById("btn_login_dynamic");

			// 输入用户名
			ElementManager.inputTextById("setting_new_login_mobile_et_num", username);

			// 输入密码
			ElementManager.inputTextById("setting_new_login_mobile_et_password",
					password);

			
			String startime = TimeUtil.getCurrentSysTime();
			System.out.println("startime: " + startime);
			// 点击登录
			ElementManager.clickById("setting_new_login_mobile_btn_login");
			
			if(!ElementManager.waitForExiststById("setting_item_login_logout_text")){
				FileManager.saveToFile("LoginTime.txt","run time: 0 ms, Login failed!");
				assertEquals("Login failed! login time more than 20s", true, false);
			}
			
			String endtime = TimeUtil.getCurrentSysTime();
			System.out.println("endtime: " + endtime);
			try {
				long runtime =  TimeUtil.getTimeDistance(endtime , startime);
				FileManager.saveToFile("LoginTime.txt","runtime: " + runtime + "ms");
				System.out.println("run time: " + runtime);
				
						
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 等待登录时间(根据网络状态)
			//sleep(10000);
			//ElementManager.waitForExiststById("setting_item_login_logout_text");
			
		}

		//MainActivity_contact.back("tab_contacts");
		backHome(2);
	}

	
	/**
	 * 是否在登录状态，false为未登录状态，true为已登录
	 * 
	 * @param username
	 * @return
	 */
	public boolean isLoginState() {
		int num = ElementManager.getChildCountByClassClass("ViewFlipper", "TextView");
		//System.out.println("num2: " + num);
		if(num == 2){
			return true;
		}

		return false;
	}
	
	/**
	 * 退出登录
	 * 
	 */
	public void Logout() {

		// 点击和通讯录
		ElementManager.clickById("iab_title");

		// 判断是否为已登录，若已登录状态，直接返回
		if (isLoginState()) {
			// 点击设置
			ElementManager.clickById("setting_layout");
			// 点击退出
			ElementManager.clickById("setting_item_login_logout_text");
			// 点击确认
			ElementManager.clickById("dialog_btn_positive");
		}

		//MainActivity_contact.back("tab_contacts");
		//backHome(2);
		//sleep(5000);
	}	
	
	public void home(){
		for(int i=0; i< 5; i++){
			if(ElementManager.isExistByName("应用程序")){
				break;
			}else{
				UiDevice.getInstance().pressHome();
			}
			sleep(1000);
		}
		sleep(2000);
	}
	
	
	public void backHome(int num){
		for(int i=0; i<num; i++){
			UiDevice.getInstance().pressBack();
			sleep(000);
		}
		
	}
	
	
	/**
	 * 需求：根据name打开应用
	 * @param name
	 */
	public void findAndOpenApp(String name) {
		System.out.println("[start] findAndOpenApp" + name);

		home();
		
		if (ElementManager.getUiObjectByText("应用程序").exists()) {
			ElementManager.clickByName("应用程序");
		}
		UiObject uo;
		try {
			for (int i = 0; i < 3; i++) {
				uo = ElementManager.getUiObjectByText(name);
				if (uo.exists()) {
					uo.click();
					System.out.println("click " + name);
					return;
				} else {
					DriverManager.swipeToRight();
				}
			}
			System.out.println("UiObject name: " + name + " not exists");
		} catch (UiObjectNotFoundException e) {
			System.out.println("openApp error");
		}
	}

	
	/**
	 * 关闭所有应用
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 */
	 public void exitApp() {
		 System.out.println("[start] close app");
	        try {
	        	UiDevice.getInstance().pressHome();
	        	
	        	sleep(1000);
				UiDevice.getInstance().pressRecentApps();
				
				//调出任务管理器
				UiObject recentapp = ElementManager.getUiObjectByResourceId("com.android.systemui:id/recents_root");
				
				if(recentapp.exists()){
					recentapp.waitForExists(2000); 
			        System.out.println("调出任务管理器");
				}
		        
		        sleep(2000);
		  
		        //点击关闭
		        //UiObject close = getUiObjectByResourceId("com.android.systemui:id/recents_RemoveAll_button");
		        UiObject close = ElementManager.getAllViewByClassName("android.widget.ImageButton", 1);
		        if(close.exists()){
		        	close.click();
					System.out.println("点击关闭");
				}
		        //sleep(2000);
		        
		        //UiDevice.getInstance().pressHome();
		        
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
	        System.out.println("[end] close app");
	    }
	
	public void openApp(String name) {
		System.out.println("openApp");
		UiObject uo;
		try {
			uo = ElementManager.getUiObjectByDescription(name);
			if (uo.exists()) {
				uo.click();
			} else {
				System.out.println("UiObject name: " + name + " not exists");
			}
		} catch (UiObjectNotFoundException e) {
			System.out.println("openApp error");
		}
	}

}
