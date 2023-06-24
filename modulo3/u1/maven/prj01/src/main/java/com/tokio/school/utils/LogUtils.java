package com.tokio.school.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogUtils {
	public enum TLOG {DEBUG, INFO, TRACE, WARN, ERROR};
	private static Logger Log;
	
	public static void registerLog(TLOG type, String msg) {
		Log = LogManager.getFormatterLogger(LogUtils.class);
		printLog(type,msg);
	}
	
	public static void registerLog(Class<?> clazz, TLOG type, String msg) {
		Log = LogManager.getFormatterLogger(clazz);
		printLog(type,msg);
	}
	
	private static void printLog(TLOG type, String msg) {
		switch (type) {
		case INFO:
			Log.info(msg);
			break;
		case DEBUG:
			Log.debug(msg);
			break;
		case WARN:
			Log.warn(msg);
			break;
		case TRACE:
			Log.trace(msg);
			break;
		case ERROR:
			Log.error(msg);
			break;
		}
	}	
}
