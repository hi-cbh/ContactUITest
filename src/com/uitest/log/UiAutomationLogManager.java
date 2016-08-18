package com.uitest.log;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UiAutomationLogManager extends UiAutomatorTestCase
{
    /* UiDevice对象*/
    UiDevice mdevice;
    
    /* 添加了是否写入日志，默认为true */
    private static boolean FLAG = true;
    
    public static boolean isFLAG() {
		return FLAG;
	}


	public static void setFLAG(boolean fLAG) {
		FLAG = fLAG;
	}

	/* log地址 */
    public static String m_logpathString = "/mnt/sdcard/PerformanceLog.txt";
    
//    /* 定义“通过哪种方式来获得uiselector”的int标识，
//       如果以后想添加别的方法（例如 通过description 来获取），则可以参考此形式进行扩充 */
//
//    final int CLICK_ID = 2000;
//    final int CLICK_TEXT = 2001;
//
//    /*构造传入UiDevice对象*/
//    public UiAutomationLogManager(UiDevice device)
//    {
//        mdevice =device;
//    }
//    
    
//    /* 实现具体的外部可以调用的函数 */
//
//    // 通过id来进行点击操作
//    public boolean ClickById(String id)
//    {
//        return ClickByInfo(CLICK_ID, id);
//    }
//    // 通过text来进行点击操作
//    public boolean ClickByText(String text)
//    {
//        return ClickByInfo(CLICK_TEXT, text);
//    }
//
//    /* 封装出通用的点击方法，供上面的public函数调用
//       如果以后想添加别的方法（例如 通过description 来获取），则可以在switch中扩充 */
//    private boolean ClickByInfo(int CLICK, String str)
//    {
//        UiSelector uiselector = null;
//        // switch根据不同的CLICK标识，创建出UiSelector的对象
//        switch(CLICK)
//        {
//        case CLICK_ID:      uiselector = new UiSelector().resourceId(str); break;
//        case CLICK_TEXT: uiselector = new UiSelector().text(str); break;
//        default: return false;
//        }
//        // 根据UiSelector对象构造出UiObject的对象
//        UiObject uiobject = new UiObject(uiselector);
//        // 判断该控件是否存在
//        int i = 0;
//        while (!uiobject.exists() && i<5)
//        {
//            SolveProblems();
//            sleep(500);
//            if (i== 4)
//            {
//                TakeScreen(str+"-not-find");
//                return false;
//            }
//            i++;        
//        }
//        // 点击
//        try
//        {
//            UiAutomationLog("click type:"+CLICK+" content:"+str );
//            uiobject.click();
//        } catch (UiObjectNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        return true;
//    }
//    
//    /* 当进不下去的时候，使用该方法，例如可能是出现了一些对话框遮挡，该方法会把对话框干掉 */
//    private void SolveProblems()
//    {        
//        
//    }
//    
//    /* 保存屏幕截图
//         参数descrip 为 描述该截图的内容 */
//    public void TakeScreen(String descrip) 
//    {
//        // 取得当前时间
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        String datestr = calendar.get(Calendar.HOUR_OF_DAY) + "_" + calendar.get(Calendar.MINUTE) + "_" + calendar.get(Calendar.SECOND);
//        
//        // 保存文件
//        File files = new File("/mnt/sdcard/"+datestr+"_"+descrip+".jpg");    
//        UiAutomationLog("TakeScreen: " + datestr+"_"+descrip+".jpg");
//        mdevice.takeScreenshot(files);        
//    }
//    
    /* 打log记录在手机中 */
    public static void UiAutomationLog(String str) 
    {
    	if(isFLAG() != true){
    		return;
    	}
    	
        // 取得当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        String datestr = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) 
        		+ ":" + calendar.get(Calendar.SECOND)+ ":";

        FileWriter fwlog = null;
        try
        {
            fwlog = new FileWriter(m_logpathString, true);
            fwlog.write(datestr + str + "\r\n");
            if(str.contains("成功") || str.contains("失败")
            		|| str.contains("通过") || str.contains("不通过")){
            	fwlog.write("------------------" + "\r\n");
            }
            System.out.println(datestr + str);
            fwlog.flush();

        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                fwlog.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
}