package com.wdxxl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

	/**
	 * Match (yyyy-MM-dd hh:mm:ss) otherwise return ""
	 * @param dateTime
	 * @return
	 */
	public static String formatDateTime(String dateTime) {
		String regex = "(\\d{4})(\\-)([0]{1}\\d{1}|[1]{1}[0-2]{1})(\\-)([0-2]{1}\\d{1}|[3]{1}[0-1]{1})(\\s)([0-1]{1}\\d{1}|[2]{1}[0-3]{1})(:)([0-5]{1}\\d{1})(:)([0-5]{1}\\d{1})";
		String timeStampString = "";
		Pattern namePattern = Pattern.compile(regex);
    	Matcher nameMatch = namePattern.matcher(dateTime);
    	if (nameMatch.matches()) {
    		timeStampString = dateTime;
    	}
		return timeStampString;
	}
	
	public static Date parseWithDefaultFormat(String date) throws ParseException{
		String format = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.parse(date);
	}
	
}
