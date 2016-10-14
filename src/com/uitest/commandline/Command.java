package com.uitest.commandline;

import java.io.IOException;

import com.uitest.data.UserConfig;

public class Command
{
	/**
	 * 运行命令行
	 * @param cmd
	 */
    public static void cmdLine(String cmd){
    	try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void callPhone(String phone){
    	cmdLine("am start -a android.intent.action.CALL -d tel:"+phone);
    }
    
    /**
     * 
     * @param num
     */
    public static void setShurufa(int num){
    	switch (num) {
		case 1:
			cmdLine("adb shell ime set jp.jun_nama.test.utf7ime/.Utf7ImeService");
			break;

		case 2:
			cmdLine("com.samsung.inputmethod/.SamsungIME");
			break;
		default:
			break;
		}

    	//使用adb shell ime list -s 列出输入法列表
    	
    }
    
    /**
     * 清除和通讯录缓存
     */
    public static void clear(){
    	cmdLine("adb shell pm clear " + UserConfig.packageName);
    }
    
    
    /**
     * 停止脚本运行
     */
    public static void stop(){
    	cmdLine("adb shell am force-stop " + UserConfig.packageName);
    }
    
    
}