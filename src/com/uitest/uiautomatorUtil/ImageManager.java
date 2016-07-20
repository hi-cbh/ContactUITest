package com.uitest.uiautomatorUtil;

import java.io.File;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.android.uiautomator.core.UiDevice;

/**
 * 保存图片，截图等功能
 * 
 * 日志记录：
 * 版本                  日期                         修改者    更新内容
 * 1.0       2016-06-04   cbh  模块重新整理
 * 
 */

public class ImageManager {

	/////////////////图片////////
	
	public static int getColorPicel(int x,int y){
		String path="/mnt/sdcard/testcolor.png";
		File file=new File(path);
		UiDevice.getInstance().takeScreenshot(file);
		Bitmap m=BitmapFactory.decodeFile(path);
		int color=m.getPixel(x, y);
		return color;
	}
	
	/**
	 * 需求：截取一张图片后，另外为
	 * @param rect
	 * @param path
	 */
	public static void cutBitmap(Rect rect,String path, String cutImg){
		Bitmap m=BitmapFactory.decodeFile(path);
		m=Bitmap.createBitmap(m, rect.left, rect.top, rect.width(), rect.height());
		saveBitMapToSdcard(m, cutImg);
	}
	
	
	
	public static void saveBitMapToSdcard(Bitmap bitmap,String newName){
		FileOutputStream out=null;
		try {
			out=new FileOutputStream("/mnt/sdcard/"+newName+".jpg");
			if(out!=null){
				bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
				out.close();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
