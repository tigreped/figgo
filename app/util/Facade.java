package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class Facade {

	/**
	 * Class that receives a string with a date and the desired format and
	 * returns a Date object
	 * 
	 * @param date
	 * @param simpleDateFormat
	 * @return
	 */
	public static Date formatDate(String date, String simpleDateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
		Date formattedDate = new Date();
		try {
			formattedDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formattedDate;
	}
	
	/**
	 * Returns the Date as a String with a simple date format
	 * dd/MM/yyyy
	 * 
	 * @return
	 */
	public static String getFormattedDate(Date date) {
		DateTime dateTime = new DateTime(date);
		String day = Integer.toString(dateTime.getDayOfMonth());
		String month = Integer.toString(dateTime.getMonthOfYear());
		String year = Integer.toString(dateTime.getYear());
		// Add a zero in front of numbers smaller then 10:
		if (dateTime.getDayOfMonth() < 10)
			day = "0" + day;
		if (dateTime.getMonthOfYear() < 10)
			month = "0" + month;
		return day + "/" + month + "/" + year;
	}
}