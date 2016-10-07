package com.uitest.otherapk;

import com.uitest.contact4_2.testcase.SimpleCode420;
import com.uitest.contact4_2.testcase.TestContactBaseV420;
import com.uitest.uiautomatorUtil.ElementManager;

public class OtherApk {

	/**
	 * 通话记录生成
	 * @param phone 需要输入号码，生成该号码的记录
	 * @param time 通话时间大于0
	 * @param type 选择记录类型分别为：已接/已拨/未接来电，对应值(1/2/3)
	 * @param isRead type选择3后才有效，选择记录是否为已读/未读(1/2)
	 * <p>实例：prepareUnreadCall("13800138000", 15, 3, 2),生成一条未读的未接来电
	 */
	public String prepareUnreadCall(String phone, int time, int type, int isRead) {
		TestContactBaseV420 tcb = new TestContactBaseV420();
		String str = "";
		// 创建未读短信数量
		tcb.findAndOpenApp("通话记录生成器");
		str = callHistory(phone, time, type, isRead);
		tcb.findAndOpenApp("和通讯录");
		return str;
	}

	/**
	 * 通话记录生成
	 * @param phone 需要输入号码，生成该号码的记录
	 * @param time 通话时间大于0
	 * @param type 选择记录类型分别为：已接/已拨/未接来电，对应值(1/2/3)
	 * @param isRead type选择3后才有效，选择记录是否为已读/未读(1/2)
	 * <p>实例：callHistory("13800138000", 15, 3, 2),生成一条未读的未接来电
	 */
	public String callHistory(String phone, int time, int type, int isRead){
		SimpleCode420 sc = new SimpleCode420();
		String date = "";
		
		sc.sleep(1000);
		
		//输入号码
		sc.inputTextById("etxMobileNum", phone);
		
		//输入通话时间
		sc.inputTextById("etxDuration", time+"");
		
		//点击未接来电(1/2/3)
		sc.clickId("rg_OutOrIn_"+type);
		
		if(type == 3){
			//点击未读(1/2)
			sc.clickId("rg_IsRead_"+isRead);
		}
		
		//点击生成记录
		sc.clickId("btnCreate");
		
		//点击确定
		sc.clickId("button1");
		
		sc.sleep(1000);
		
//		date = ElementManager.getViewTextById("com.ktls.tonghuaweizao:id/txtDate")
//				+ "_" + ElementManager.getViewTextById("com.ktls.tonghuaweizao:id/txtTime");
//		
		date = "";
		
		return date;
	}
	
	

	/**
	 * 准备未读短信,创建含多条的短信
	 */
	public static void prepareUnreadMMS(String num1, String num2) {
		TestContactBaseV420 tcb = new TestContactBaseV420();
		// 创建未读短信数量
		tcb.findAndOpenApp("SMSToolDemo");
		setSmsToolDemo(num1, num2);
		tcb.findAndOpenApp("和通讯录");

	}
	
	
	/**
	 * 短信生成器，输入两个参数，分别是会话条数，信息数量。
	 * 
	 * @param cscnt
	 * @param msscnt
	 */
	public static void setSmsToolDemo(String cscnt, String msscnt) {

		// 输入数字		
		ElementManager.inputTextById("com.er.zjj.demo.outbox:id/edit_create_input", cscnt);
		ElementManager.inputTextById("com.er.zjj.demo.outbox:id/edit_sms_count", msscnt);

		// 点击创建
		ElementManager.clickById("com.er.zjj.demo.outbox:id/btn_create");
		
		// 清除
		ElementManager.inputTextById("com.er.zjj.demo.outbox:id/edit_create_input", "");
		ElementManager.inputTextById("com.er.zjj.demo.outbox:id/edit_sms_count", "");
	}
	
}
