//package com.uitest.uiautomatorUtil;
//
//import java.awt.Color;
//import java.io.File;
//import java.io.IOException;
//
//import com.study.code.AndroidDriver;
//import com.study.code.TakesScreenshot;
//import com.study.code.WebElement;
//
//
//
//
//
//public class AssertUtil {
//	/**
//	 * 判断是否通过验证，如果不通过结束并截图,并添加具体问题描述
//	 * 
//	 * @param bl
//	 * @param caseName
//	 */
//	public static void Myassert(String message, boolean bl, String caseName) {
//		if (bl == false) {
//			AppUtil.snapshot(driver, caseName, message);
//		}
//		sleepTime(3000);
//		Assert.assertTrue(message, bl);
//	}
//	
//	public static void snapshot(AndroidDriver<WebElement> driver,
//			String testCasename, String text){
//		
//		System.out.println("snapshot");
//		// 获取当前工作路径
//		String currentPath = System.getProperty("user.dir");
//
//		//String tmpfile = currentPath + "tmp.png";
//		//System.out.println("user.dir" + tmpfile);
//		
////		 利用 TakesScreenshot接口提供的 getScreenshotAs()方法捕捉屏幕,会将获取到的截图存放到一个临时文件中
//		File scrFile = ((TakesScreenshot) driver)
//				.getScreenshotAs(OutputType.FILE);
//		
//		System.out.println("TakesScreenshot");
//
//		//第一种张图片，源图像地址
//		String filePath = currentPath + imagePath;
//		String srcPath = filePath + "tmp.jpg";
//		try {
//			FileUtils.copyFile(scrFile, new File(srcPath));
//			
//			//第二种张图片，目标图像地址
//			String filename = testCasename + "_" + getCurrentDateTime() + ".jpg";
//			String newpath = filePath +  filename;
//			new File(newpath);
//			
//			pressText2(text, srcPath, newpath, "黑体", 36, Color.RED, 50, 0, 0, 0.5f);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	
//	
//	
//}
