package com.uitest.uiautomatorUtil;


import com.uitest.util.TestContactBase;

/**
 * 用于判断是否通过验证，截图图片并添加说明。
 * 
 * 日志记录：
 * 版本                  日期                         修改者    更新内容
 * 1.0       2016-08-12   cbh  新增Myassert方法
 * 
 */
public class AssertUtil extends TestContactBase{
	/**
	 * 判断是否通过验证，如果不通过结束并截图,并添加具体问题描述
	 * 
	 * @param bl
	 * @param caseName
	 */
	public static void Myassert(String message, boolean bl, String caseName) {

		//bl为false
		if (bl == false) {
			
			String path = "/mnt/sdcard/AppTestReportPic/"+caseName+TimeUtil.getCurrentSysTimeUnsigned()+".jpg";
			ImageManager.snapshot(path,message);
			assertEquals(message, bl, true);
		}
		//bl为true
		assertEquals(message, bl, true);

	}
	

	
	
	
}
