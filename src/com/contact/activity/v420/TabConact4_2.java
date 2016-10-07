package com.contact.activity.v420;

import com.android.uiautomator.core.UiObject;
import com.contact.activity.EditContactActivity;
import com.contact.activity.MainActivity_contact;
import com.uitest.contact4_2.testcase.SimpleCode420;
import com.uitest.uiautomatorUtil.DriverManager;

public class TabConact4_2 extends MainActivity_contact {

	@Override
	public  void newContact(String name, String phone) {
		super.newContact(name, phone);
	}

	@Override
	public void swipeDownNewContact(String name, String phone) {
		SimpleCode420 sc = new SimpleCode420();
		DriverManager.swipeToDown();
		sc.sleep(2000);
		EditContactActivity.setContactName(name);
		sc.sleep(2000);
		EditContactActivity.setPhone(phone);
		sc.clickText("完成");
		sc.sleep(2000);
	}

	@Override
	public void deleteContactByName(String name) {
		// TODO Auto-generated method stub
		super.deleteContactByName(name);
	}

	@Override
	public void deleteContactByPhone(String phone) {
		// TODO Auto-generated method stub
		super.deleteContactByPhone(phone);
	}

	@Override
	public boolean search(String name) {
		// TODO Auto-generated method stub
		return super.search(name);
	}

	@Override
	public void clearRecord() {
		// TODO Auto-generated method stub
		super.clearRecord();
	}

	@Override
	public void searchCancel() {
		// TODO Auto-generated method stub
		super.searchCancel();
	}

	@Override
	public void clearContact() {
		// TODO Auto-generated method stub
		super.clearContact();
	}

	@Override
	public void deleteOneOper(UiObject uo) {
		// TODO Auto-generated method stub
		super.deleteOneOper(uo);
	}

	@Override
	public void deleteAllOper(UiObject uo) {
		// TODO Auto-generated method stub
		super.deleteAllOper(uo);
	}

	@Override
	public UiObject getListViewFirstName() {
		// TODO Auto-generated method stub
		return super.getListViewFirstName();
	}

	@Override
	public UiObject getListViewFirstPhoneInMain() {
		// TODO Auto-generated method stub
		return super.getListViewFirstPhoneInMain();
	}

	@Override
	public UiObject getListViewFirstPhoneInSearch() {
		// TODO Auto-generated method stub
		return super.getListViewFirstPhoneInSearch();
	}

	/**
	 * 添加联系人，不做任何检测
	 * @param name
	 * @param phone
	 */
	public static void addContacts(String name, String phone){

		SimpleCode420 sc = new SimpleCode420();
		
		//进入联系人模块
		sc.clickId("tab_contacts");

		//点击创建
		sc.clickId("iab_ib_action");
		//输入姓名
		//sc.inputTextById("edit_contact_name", name);
		sc.inputTextByText("姓名", name);
		//输入号码
		sc.inputTextByText("电话号码", phone);
		//点击完成
		sc.clickText("完成");
		sc.sleep(2000);
		//返回主页
		sc.back();
		
	}
	
	
	/**
	 * 创建联系人
	 * @param name
	 * @param phone
	 */
	public static void createContacts(String name, String phone) {

		SimpleCode420 sc = new SimpleCode420();
		
		//进入联系人模块
		sc.clickId("tab_contacts");
		
		if(!sc.isExistId("check_declaration")){
			//点击搜索框
			sc.clickId("contact_search_bar");
			//搜索联系人
			sc.inputTextById("contact_search_bar", phone);
			//如果联系人存在，则删除，否则返回
			if(sc.isExistId("contact_name")){
				sc.longClickId("contact_icon");
				sc.clickText("删除");
				sc.clickText("删除");
			}
			else{
				sc.clickId("contact_search_del_btn");
			}
		}
		
		//点击创建
		sc.clickId("iab_ib_action");
		//输入姓名
		//sc.inputTextById("edit_contact_name", name);
		sc.inputTextByText("姓名", name);
		//输入号码
		sc.inputTextByText("电话号码", phone);
		//点击完成
		sc.clickText("完成");
		sc.sleep(2000);
		//返回主页
		sc.back();
		
	}

	
}
