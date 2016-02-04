package au.co.pactera.getweather.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 * Class to define constants which are being used across project
 */
public class Common {

	/**
	 * According to a date,return week
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {

		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate) {
		String str = "";
		str = getWeek(sdate);
		if ("1".equals(str)) {
			str = "Sunday";
		} else if ("2".equals(str)) {
			str = "Mondy";
		} else if ("3".equals(str)) {
			str = "Tuesday";
		} else if ("4".equals(str)) {
			str = "Wednesday";
		} else if ("5".equals(str)) {
			str = "Tuesday";
		} else if ("6".equals(str)) {
			str = "Friday";
		} else if ("7".equals(str)) {
			str = "Saturday";
		}
		return str;
	}

	/**
	 * concert Date formate yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static String formatDateHMA(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
		return sdf.format(date);
	}
	
	public static String formatDateYYYYMMDD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	/**
	 * Temperature conversion function (from absolute temperature to centigrade)
	 * 
	 * @param abs
	 *            - absoulte temperature
	 * @return - centigrade
	 */
	public static String absToCel(String abs) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		Double floatFar = Double.valueOf(abs);
		Double centigrade = (floatFar - 273.16f);
		return df.format(centigrade) + "°C";

	}
	
	public static JSONObject parseJson(String jsonString) throws JSONException {
		return new JSONObject(jsonString);
	}
}
