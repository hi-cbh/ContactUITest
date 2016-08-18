package com.uitest.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MyLogcatHelper {

	private static LogcatHelper INSTANCE = null;
	private static String PATH_LOGCAT;
	private LogDumper mLogDumper = null;
	private int mPId;

	public MyLogcatHelper() {

		mPId = android.os.Process.myPid();
	}

	public void start() {
		if (mLogDumper == null)
			mLogDumper = new LogDumper(String.valueOf(mPId));
		mLogDumper.start();
	}

	public void stop() {
		if (mLogDumper != null) {
			mLogDumper.stopLogs();
			mLogDumper = null;
		}
	}

	private class LogDumper extends Thread {

		private Process logcatProc;
		private BufferedReader mReader = null;
		private boolean mRunning = true;
		String cmds = null;
		private String mPID;
		private FileOutputStream out = null;

		public LogDumper(String pid) {
			mPID = pid;
			try {
				out = new FileOutputStream(new File("/mnt/sdcard/logc",
						"log.txt"));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		}

		public void stopLogs() {
			mRunning = false;
		}

		@Override
		public void run() {

			String line = null;
			try {
				logcatProc = Runtime.getRuntime().exec("logcat");
				mReader = new BufferedReader(new InputStreamReader(
						logcatProc.getInputStream()), 1024);

				while ((line = mReader.readLine()) != null) {
					if (!mRunning) {
						break;
					}
					if (line.length() == 0) {
						continue;
					}
					if (out != null) {
						out.write((line + "\n").getBytes());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (logcatProc != null) {
					logcatProc.destroy();
					logcatProc = null;
				}
				if (mReader != null) {
					try {
						mReader.close();
						mReader = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					out = null;
				}

			}
		}
	}

}
