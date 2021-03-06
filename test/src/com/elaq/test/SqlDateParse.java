package com.elaq.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SqlDateParse {

	public static void main(String [] args) throws ParseException
	{
	String dateStr = "Mon Jun 18 00:00:00 IST 2012";
	DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
	Date date = (Date)formatter.parse(dateStr);
	System.out.println(date);        

	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
	System.out.println("formatedDate : " + formatedDate);   
}
}