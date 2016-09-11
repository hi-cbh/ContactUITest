package com.uitest.contact4_2;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.contact.activity.MainActivity_contact;
import com.uitest.uiautomatorUtil.AssertUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManagerLog;

public class SimpleCode420 extends TestContactBaseV420{

	/**
	 * 点击资源ID
	 * @param id
	 */
	public  void clickId(String id){
		ElementManagerLog.clickById(id);
	}

	/**
	 * 点击屏幕上的文字
	 * @param text
	 */
	public void clickText(String text){
		ElementManagerLog.clickByName(text);
	}
	
	/**
	 * 长按屏幕上的资源ID
	 * @param id
	 */
	public void clickLongId(String id){
		ElementManagerLog.clickLongByUiObject(ElementManagerLog.getUiObjectByResourceIdMatches(id));
	}
	
	
	/**
	 * 长按屏幕上的资源text
	 * @param text
	 */
	public void clickLongText(String text){
		ElementManagerLog.clickLongByUiObject(ElementManagerLog.getUiObjectByText(text));
	}
	
	
	/**
	 * 验收是否存在资源ID
	 * @param message
	 * @param id
	 */
	public void assertId(String id){
		//System.out.println("testcase: "+getTestCaseName());
		AssertUtil.Myassert("没有找到："+ id, ElementManagerLog.isExistById(id), getTestCaseName());
	}
	
	public void assertText(String text){
		AssertUtil.Myassert("没有找到："+ text, ElementManagerLog.isExistByName(text), getTestCaseName());
	}
	
	
	/**
	 * 获取当前运行用例名称
	 * @return
	 */
	private String getTestCaseName(){
		return Thread.currentThread().getStackTrace()[4].getMethodName();
	}
	
	/**
	 * 点击资源文本框ID或文本后，输入内容
	 */
	public void input(String text, String contant){
		UiObject uo = ElementManagerLog.getUiObjectByResourceIdMatches(text);
		//找到点击后输入
		if(uo.exists()){
			ElementManagerLog.inputText(uo, contant);
			return;
		}
		
		//找文本点击后输入
		uo = ElementManagerLog.getUiObjectByText(text);
		if(uo.exists()){
			ElementManagerLog.inputText(uo, contant);
		}
	}
	
	/**
	 * 返回和通讯录主页
	 * @param str
	 */
	public void home(String str){
		MainActivity_contact.back(str);
	}
	
	/*
	 * 右滑
	 */
	public void swipeToRight(){
		DriverManager.swipeToRight();
	}
	
	/*
	 * 左滑
	 */
	public void swipeToLeft(){
		DriverManager.swipeToLeft();
	}
	
	
	

	/**
	 * 按Home键
	 */
	public void home(){
		DriverManager.pressHome();
	}
	/**
	 * 按menu键
	 */
	public void menu(){
		DriverManager.pressMenu();
	}
	/**
	 * 按Back键
	 */
	public void back(){
		DriverManager.pressBack();
	}
	
	
	
	
	
	
}
