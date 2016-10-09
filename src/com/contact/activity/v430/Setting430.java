package com.contact.activity.v430;

import com.uitest.contact4_2.testcase.SimpleCode420;

public class Setting430 {
	/**
	 * 进入防打扰设置
	 */
	public void OpenTabMenu(String tab1, String tab2) {
		SimpleCode420 sc = new SimpleCode420();
		// 点击和通讯录
		sc.clickId("iab_title");

		sc.sleep(1000);

		// 点击防打扰
		sc.clickText(tab1);
		
		// 点击更多
		sc.clickId("iab_ib_more");

		sc.sleep(1000);

		// 点击黑名单
		sc.clickText(tab2);

	}

	/**
	 * 清空黑名单内容
	 */
	public void ClearBackList(){
		// 进入管理黑名单
		OpenTabMenu("防打扰", "黑名单");
		//iab_ib_action  /iab_ib_more
		ClearBlack();
	}
	
	
	public void ClearBlack(){
		SimpleCode420 sc = new SimpleCode420();
		//是否存在
		if (sc.isExistId("iab_ib_action")) {
			// 点击清空
			sc.clickId("iab_ib_action");

			sc.sleep(1000);
			// 点击清空
			sc.clickId("dialog_btn_positive");
		}
		sc.sleep(1000);
		// 返回主界面
		sc.back();
		sc.back();
		sc.back();
		sc.back();
	}
	
}
