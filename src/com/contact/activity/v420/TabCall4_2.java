package com.contact.activity.v420;


import com.contact.activity.MainActivity_call;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManagerLog;


public class TabCall4_2 extends MainActivity_call {

	
	/**
	 * 隐藏拨号盘的输入盘
	 */
	public static void hidekeyboardCall(){
		if(ElementManagerLog.isExistById("two")){
			//true为显示键盘，点击键盘隐藏
			ElementManagerLog.clickById("tab_call");
		}
	}
	
	/**
	 * 显示拨号盘的输入键盘
	 */
	public static void displaykeyboardCall(){
		if(ElementManagerLog.isExistById("two"))
		{
				
		}
		else
		{
			//flase为显示键盘，点击键盘显示
			ElementManagerLog.clickById("tab_call");
		}
		
	}
	
	
	/**
	 * 清空通话记录
	 */
	public void deleteAllCall(){
		//点击拨号
		ElementManagerLog.clickById("tab_call");
		
		//隐藏输入盘
		hidekeyboardCall();
		
		//点击清空通话记录
		DriverManager.pressMenu();
		
		ElementManagerLog.clickByName("清空通话记录");
		
		
		//点击清空按钮
		ElementManagerLog.clickById("dialog_btn_positive");
		
	}

	
	
	/**
	 * 拨号盘点击号码
	 * @param str
	 */
	public void touchCallNumber(String str){
		int len = str.length();
		int i;
		for(i = 0; i< len; i++){
			digitsChangeName(Integer.parseInt(str.charAt(i) + "") );
		}
	}

	/**
	 * 仅用于拨号盘点击数字
	 * @param chr
	 */
	public static void digitsChangeName(int chr){
		switch(chr)
		{
		case 1:
			ElementManagerLog.clickById("one");
			break;
		case 2:
			ElementManagerLog.clickById("two");
			break;
		case 3:
			ElementManagerLog.clickById("three");
			break;
		case 4:
			ElementManagerLog.clickById("four");
			break;
		case 5:
			ElementManagerLog.clickById("five");
			break;
		case 6:
			ElementManagerLog.clickById("six");
			break;
		case 7:
			ElementManagerLog.clickById("seven");
			break;
		case 8:
			ElementManagerLog.clickById("eight");
			break;
			
		case 9:
			ElementManagerLog.clickById("nine");
			break;
			
		case 0:
			ElementManagerLog.clickById("zero");
			break;
		}
	}
	
}
