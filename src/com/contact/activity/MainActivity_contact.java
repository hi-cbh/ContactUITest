package com.contact.activity;

import org.xmlpull.v1.sax2.Driver;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.contact.activity.*;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;


public class MainActivity_contact{
/**
 * 
 *  拨号盘页面：
	 属性：
		常用固定号码如：10086、10010、10000
		常用暗码：*#06#、*#*#4636#*#*
		组件ID: 页面各个组件ID按功能命名
		页面对象：页面各个UI对象
	 方法：
		创建联系人（仅名称、号码）
 * 		创建联系人（名称、号码、其他）
 * 		删除联系人（）
 * 		清空联系人（）
 */
	//页面元素
	private static String addBtnId = "iab_ib_action"; //新增按钮
	private static String contactBtnId = "tab_contacts"; //联系人模块
	private static String contactName = "contact_name"; //列表中的用户名
	private static String contactPhone = "contact_number"; //列表中的号码名
	private static String searchEtId = "contact_search_bar"; //搜索框
	private static String searchContactPhone = "contact_search_content"; //搜索页面联系人号码
	
	//长按元素，屏幕选项
	private static String deleteLayout = "mca_delete_layout"; //删除
	private static String shareLayout = "mca_share_layout"; //分享名片
	private static String msgLayout = "mca_msg_layout"; //发短信
	private static String callLayout = "mca_call_layout"; //加入白名单
	private static String selectAll = "mca_ib_select"; //全选
	
	//搜索页
	private static String noContact = "contact_empty_view"; //没记录时，背景显示的id
	private static String searchDel = "contact_search_del_btn"; //搜索框的情况记录按钮
	private static String searchCancel = "contact_search_cancel_btn"; //取消搜索按钮
	
	private static String confirmBtnId = "dialog_btn_positive"; //确认按钮 
	
	public void newContact(String name, String phone){
		ElementManager.clickById(contactBtnId);
		//点击添加
		ElementManager.clickById(addBtnId);
		sleep(2000);
		EditContactActivity.setContactName(name);
		sleep(2000);
		EditContactActivity.setPhone(phone);
		EditContactActivity.saveContact();
		sleep(2000);
	}
	
	public void swipeDownNewContact(String name, String phone){
		ElementManager.clickById(contactBtnId);
		//点击添加
		DriverManager.swipeToDown();
		sleep(2000);
		EditContactActivity.setContactName(name);
		sleep(2000);
		EditContactActivity.setPhone(phone);
		EditContactActivity.saveContact();
		sleep(2000);
	}
	
	
	/**
	 * 通过姓名删除
	 * @param name
	 */
	public void deleteContactByName(String name){
		
		ElementManager.clickById(contactBtnId);
		
		//联系人个数为零
		if(ElementManager.isExistById("btResolve")){
			return;
		}
		System.out.println("one");
		int num = ElementManager.getChildCountByClassId("ListView", contactName);
		//只有一个联系人，且名称相同，删除
		if(num == 1 && ElementManager.getViewTextById(contactName).equals(name)){
			//如果相等，删除
			deleteOneOper(ElementManager.getUiObjectByResourceIdMatches(contactName));
			return;
		}else if(num > 1 && search(name)){
			//查找，并删除
			deleteOneOper(ElementManager.getUiObjectByResourceIdMatchesIndex(contactName, 0));
			clearRecord();
			searchCancel();
			return;
		}else{
			return;
		}

	}
	
	/**
	 * 通过号码删除 
	 * @param name
	 */
	public void deleteContactByPhone(String phone){
		
		ElementManager.clickById(contactBtnId);
		
		//联系人个数为零
		if(ElementManager.isExistById("btResolve")){
			return;
		}
		System.out.println("one");
		
		int num = ElementManager.getChildCountByClassId("ListView",contactPhone);
		//只有一个联系人，且名称相同，删除
		if(num == 1 && ElementManager.getViewTextById(contactPhone).equals(phone)){
			//如果相等，删除
			deleteOneOper(ElementManager.getUiObjectByResourceIdMatches(contactPhone));
			return;
		}else if(num > 1 && search(phone)){
			//查找，并删除
			deleteOneOper(ElementManager.getUiObjectByResourceIdMatchesIndex(contactPhone, 1));
			clearRecord();
			searchCancel();
			return;
		}else{
			return;
		}

	}
	/**
	 * 根据条件搜索联系人，存在返回true,否则返回false
	 * @param name
	 */
	public boolean search(String name){
		ElementManager.clickById(contactBtnId);
		
		//联系人个数为零
		if(ElementManager.isExistById("btResolve")){
			return false;
		}
		
		//输入条件
		ElementManager.inputTextById(searchEtId, name);
		
		//获取list数量
		//结果列表返回数量为0
		if(ElementManager.isExistById(noContact)){
			return false;
		}
		
		//返回一个或多条记录都定义为true
		return true;
		
	}
	
	/**
	 * 清除记录
	 */
	public void clearRecord(){
		ElementManager.clickById(searchDel);
	}
	
	/**
	 * 取消搜索
	 */
	public void searchCancel(){
		ElementManager.clickById(searchCancel);
	}
	
	
	
	/**
	 * 清理所有联系人
	 */
	public void clearContact(){
		
		ElementManager.clickById(contactBtnId);
		
		//联系人个数为零
		if(ElementManager.isExistById("btResolve")){
			return;
		}

		int cnt = ElementManager.getChildCountByClassId("ListView", contactName);
		
		System.out.println("collection: " + cnt);
		
		UiObject uo ;
		//删除联系人
		if(cnt == 1){
			uo = ElementManager.getUiObjectByResourceIdMatches(contactName);
			deleteOneOper(uo);
		}else if(cnt > 1){
			//获取元素
			uo = ElementManager.getUiObjectByResourceIdMatchesIndex(contactName, 0);
			deleteAllOper(uo);
		}else{
			
		}
	}
	
	//删除单个联系的操作
	public void deleteOneOper(UiObject uo){
		//长按元素
		ElementManager.clickLongByUiObject(uo);
		// 点击删除
		ElementManager.clickById(deleteLayout);
		// 点击确认删除
		ElementManager.clickById(confirmBtnId);
	}
	
	//删除所有联系的操作
	public void deleteAllOper(UiObject uo){
		
		//长按元素
		ElementManager.clickLongByUiObject(uo);

		// 点击全选
		ElementManager.clickById(selectAll);

		// 点击删除
		ElementManager.clickById(deleteLayout);

		// 点击确认删除
		ElementManager.clickById(confirmBtnId);
	}
	

	
	
	/**
	 * 获取列表中第一个名称
	 * @return
	 */
	public UiObject getListViewFirstName(){
		return ElementManager.getUiObjectByResourceIdMatchesIndex(contactName, 0);
	}
	
	public UiObject getListViewFirstPhoneInMain(){
		return ElementManager.getUiObjectByResourceIdMatchesIndex(contactPhone, 1);
	}
	
	public UiObject getListViewFirstPhoneInSearch(){
		return ElementManager.getUiObjectByResourceIdMatchesIndex(searchContactPhone, 1);
	}
	
	///////////////////////////////////////////////
	
	public static void back(String name) {
		System.out.println("[start] back");
		int i = 0;
		for (; i < 7; i++) {
			//首页
			if(rootFloor()){
				ElementManager.clickById(name);
				ElementManager.clickById(name);
				//sleep(500);
				System.out.println("[ end ] back");
				return;
			}else if(!notRootFloor() || 
					!settingPage() || !searchPage()) {
				//返回上一层
				System.out.println("notRootFloor or settingPage or searchPage");
				UiDevice.getInstance().pressBack();
				sleep(500);
			}
			//弹窗
			else if(isPopup() && ElementManager.getViewTextById("title").equals("短信发送失败")){
				//取消
				ElementManager.clickById("dialog_btn_negative");
			}
			else if(isPopup()){
				//确定
				ElementManager.clickById("dialog_btn_positive");				
			}
			else{
				ElementManager.clickById("tab_contacts");
				
				sleep(2000);
				
				ElementManager.clickById("tab_call");
			}
			//不在首层
			sleep(500);
		}
	}
	
	private static void sleep(int i) {
			//System.out.println("no sleep time");
			//UiDevice.getInstance().wait(i);
	}

	//不在首层
	public static boolean notRootFloor(){
		if(ElementManager.isExistById("iab_back")) {
			return true;
		}
		return false;
	}
	
	public static boolean searchPage(){
		if(ElementManager.isExistById("contact_search_cancel_btn")){
			return true;
		}
		return false;
	}
	
	/**
	 * 在首层
	 * @return
	 */
	public static boolean rootFloor(){
		if(ElementManager.isExistById("tab_bar") && ElementManager.isExistById("iab_view") && (!ElementManager.isExistById("user_info_layout")))
		{
			System.out.println("rootFloor");
			return true;
		}
		System.out.println("not rootFloor");
		return false;
	}
	
	/**
	 * s设置页面
	 * @return
	 */
	public static boolean settingPage(){
		if(ElementManager.isExistById("user_info_layout")){
			return true;
		}
		return false;
	}
	
	//判断是否为弹窗
	public static boolean isPopup(){
		if(ElementManager.isExistById("title")){
			return true;
		}
		return false;
	}
	
	///////////////////////////////
	
}
