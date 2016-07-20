package com.testCode;


import java.io.File;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.ParseException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.uitest.util.UiAutomatorHelper;


public class ImageTest extends ImageTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorHelper("Demo", "com.testCode.ImageTest", "testGetPicelAndCutImg", "4");

	}
	
	public void testCreateBitMap(){
		//截取一张图片
		String path="/mnt/sdcard/testBitMap.png";
		File storePath=new File(path);
		UiDevice.getInstance().takeScreenshot(storePath);
		sleep(3000);
        //创建bitmap
		Bitmap bitmap=BitmapFactory.decodeFile(path);
		//重命名图片，保存
		saveBitMapToSdcard(bitmap,"new-image-88");		
	}
	public void testGetPicelAndCutImg() throws UiObjectNotFoundException, ParseException, java.text.ParseException{
		
		System.out.println("start");
		sleep(2000);
		System.out.println("doing");
		
		String end = "";
		new UiObject(new UiSelector().resourceId("cn.cj.pe:id/txt_send")).click();
		
		String start = getCurrentSysTime();
		//截取图片
		UiObject object=new UiObject(new UiSelector().resourceId("cn.cj.pe:id/hjl_icon_local_contact_title_name"));
		Rect rect=object.getBounds();
		String path="/mnt/sdcard/testcolor.png";
		File file=new File(path);

		UiDevice.getInstance().takeScreenshot(file);
		cutBitmap(rect,path);
		//获取某个点的颜色值
		int bColour = 0;
		
		int color=getColorPicel(rect.centerX(),rect.centerY());
		
		bColour = color;
		
		for(int i=0; i< 30; i++){
			UiDevice.getInstance().takeScreenshot(file);
			cutBitmap(rect,path);
			//获取某个点的颜色值
			color=getColorPicel(rect.centerX(),rect.centerY());
			if(bColour != color)
			{
				end = getCurrentSysTime();
				break;
			}
			System.out.println("COLOR:"+color);
		}
	
		System.out.println("start: " + start);
		System.out.println("end: " + end);
		System.out.println("times: " + getTimeDistance(end, start));
		
	}
	
	public void getColorPicel() throws UiObjectNotFoundException{
		UiObject object=new UiObject(new UiSelector().resourceId("cn.cj.pe:id/actionbar_title_sub"));
		Rect rect=object.getBounds();
		String path="/mnt/sdcard/testcolor.png";
		new File(path);

		Bitmap m=BitmapFactory.decodeFile(path);
		int color=m.getPixel(rect.centerX(),rect.centerY());
		System.out.println("COLOR:"+color);
	}
	
	public void testEmbedText(){
		String path="/mnt/sdcard/testEmbed.png";
		String imageName="testEmbedText_888";
		String text="测试信息:testEmbedText";
		screenshotAndDrawText(path, imageName, text);

	}
	public void testImgComparison(){
		String targetImagePath="/mnt/sdcard/c1.png";
		String comPath="/mnt/sdcard/c2.png";
		
		File f1=new File(targetImagePath);
		File f2=new File(comPath);
		
		UiDevice.getInstance().takeScreenshot(f1);
		sleep(3000);
		UiDevice.getInstance().pressHome();
		sleep(3000);
		UiDevice.getInstance().takeScreenshot(f2);
				
		boolean b=imageSameAs(targetImagePath,comPath,1.0d);
		System.out.println("图像比对结果："+b);
	}

}
