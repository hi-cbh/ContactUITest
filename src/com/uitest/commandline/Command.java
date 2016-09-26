package com.uitest.commandline;

import java.io.IOException;

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
    
    
}