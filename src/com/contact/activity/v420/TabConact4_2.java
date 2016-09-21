package com.contact.activity.v420;

import com.android.uiautomator.core.UiObject;
import com.contact.activity.MainActivity_contact;

public class TabConact4_2 extends MainActivity_contact {

	@Override
	public  void newContact(String name, String phone) {
		// TODO Auto-generated method stub
		super.newContact(name, phone);
	}

	@Override
	public void swipeDownNewContact(String name, String phone) {
		// TODO Auto-generated method stub
		super.swipeDownNewContact(name, phone);
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

}
