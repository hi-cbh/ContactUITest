package com.testCode;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ParseException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ImageTestCase extends UiAutomatorTestCase {

	public void saveBitMapToSdcard(Bitmap bitmap, String newName) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("/mnt/sdcard/" + newName + ".jpg");
			if (out != null) {
				bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
				out.close();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 需求：截取一张图片后，另外为
	 * 
	 * @param rect
	 * @param path
	 */
	public void cutBitmap(Rect rect, String path) {
		Bitmap m = BitmapFactory.decodeFile(path);
		m = Bitmap.createBitmap(m, rect.left, rect.top, rect.width(),
				rect.height());
		saveBitMapToSdcard(m, "cutImg_888");
	}

	/**
	 * 需求：获取某个坐标点的颜色值
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int getColorPicel(int x, int y) {
		String path = "/mnt/sdcard/testcolor.png";
		File file = new File(path);
		UiDevice.getInstance().takeScreenshot(file);
		Bitmap m = BitmapFactory.decodeFile(path);
		int color = m.getPixel(x, y);
		return color;
	}

	public void screenshotAndDrawText(String path, String imageName, String text) {
		File file = new File(path);
		UiDevice.getInstance().takeScreenshot(file);
		Bitmap bitmap = BitmapFactory.decodeFile(path);
		Bitmap drawBitmap = drawTextBitmap(bitmap, text);
		saveBitMapToSdcard(drawBitmap, imageName);

	}

	public Bitmap drawTextBitmap(Bitmap bitmap, String text) {
		int x = bitmap.getWidth();
		int y = bitmap.getHeight();

		// 创建一个比原来图片更大的位图
		Bitmap newBitmap = Bitmap.createBitmap(x, y + 80,
				Bitmap.Config.ARGB_8888);
		Canvas canvans = new Canvas(newBitmap);
		Paint paint = new Paint();
		// 在原图位置（0，0）叠加一张图片
		canvans.drawBitmap(bitmap, 0, 0, paint);
		// 画笔颜色
		paint.setColor(Color.parseColor("#FF0000"));
		paint.setTextSize(30);
		canvans.drawText(text, 20, y + 55, paint);
		canvans.save(Canvas.ALL_SAVE_FLAG);
		canvans.restore();
		return newBitmap;
	}

	public boolean imageSameAs(String targetImagePath, String comPath,
			double percent) {
		try {
			Bitmap m1 = BitmapFactory.decodeFile(targetImagePath);
			Bitmap m2 = BitmapFactory.decodeFile(comPath);

			int width = m2.getWidth();
			int height = m2.getHeight();
			int numDiffPixels = 0;
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (m2.getPixel(x, y) != m1.getPixel(x, y)) {
						numDiffPixels++;
					}
				}
			}

			double totalPicels = height * width;
			double diffPercent = numDiffPixels / totalPicels;

			return percent <= 1.0 - diffPercent;

		} catch (Exception e) {
		}

		return false;
	}

	public String getCurrentSysTime() {
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS");
		// long ctime = System.currentTimeMillis();
		long ctime = System.nanoTime() / 1000000L;
		String currenttime = formattime1.format(new Date(ctime));
		return currenttime;
	}

	public long getTimeDistance(String time1, String time2)
			throws ParseException, java.text.ParseException {
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS");
		Date t1 = formattime1.parse(time1);
		Date t2 = formattime1.parse(time2);
		long d = t1.getTime() - t2.getTime();
		return d;

	}

}
