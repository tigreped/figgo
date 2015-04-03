package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Facade {

	/**
	 * Class that receives a string with a date and the desired format
	 * @param date
	 * @param simpleDateFormat
	 * @return
	 */
	public static Date formatDate(String date, String simpleDateFormat) {
		// Generate default point zero in time (Millenium bug).
		SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
		Date formattedDate= new Date();
		try {
			formattedDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formattedDate;
	}
}