package com.contact.activity.v420;

import com.uitest.contact4_2.SimpleCode420;

public class Setting420 {
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

}
