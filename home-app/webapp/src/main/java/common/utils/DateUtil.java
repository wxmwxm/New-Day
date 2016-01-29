package common.utils;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * This class is used for ...   
 * @author wxm
 * @dateTime 2012-12-9 下午02:33:39
 * @describe 
 *
 */
@SuppressWarnings("unused")
public class DateUtil extends org.apache.commons.lang3.time.DateUtils {
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final Log log = LogFactory.getLog(DateUtil.class);
	public static String MONTH_ENAME[] = { "JAN", "FEB", "MAR", "APR", "MAY",
			"JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	public static String DAY_CNAME[] = { "星期日", "星期一", "星期二", "星期三", "星期四",
			"星期五", "星期六" };
	private static final String parsePatterns[] = { "yyyy-MM-dd HH:mm:ss",
			"yyyy-MM-dd", "HH:mm", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd", "HHmm",
			"ddMMMyy", "yyyyMMddHHmmss" };

	public DateUtil() {}
	
	public static String getMonthEnameNum(String monthEname, int length) {
		int i;
		for (i = 0; i < MONTH_ENAME.length; i++)
			if (MONTH_ENAME[i].equals(monthEname))
				break;

		String monthEnameNum = String.valueOf(++i);
		if (length == 2 && monthEnameNum.length() < length)
			monthEnameNum = (new StringBuilder("0")).append(monthEnameNum)
					.toString();
		return monthEnameNum;
	}

	public static Date parseFlightDate(String dateStr, String format) {
		String yearStr = dateStr.substring(dateStr.length() - 2);
		return parseFlightDate(yearStr, dateStr, "0000", format);
	}

	public static long getTime(Date date, boolean isEnd) {
		return resetTime(date, isEnd).getTime() / 1000L;
	}

	public static Date resetTime(Date date, boolean isEnd) {
		Calendar c = getCalendar(date);
		c.set(11, 0);
		c.set(12, 0);
		c.set(13, 0);
		return c.getTime();
	}

	public static Date parseFlightDate(String yearStr, String dateStr,
			String timeStr, String format) {
		Calendar c = null;
		int year = -1;
		String monthCode = dateStr.substring(2, 5);
		int month = Integer.parseInt(getMonthEnameNum(monthCode, 1));
		int curMonth = -1;
		if (StringUtils.isEmpty(yearStr)) {
			c = getCalendar(new Date());
			year = c.get(1);
			curMonth = c.get(2);
			if (month < curMonth)
				year++;
		} else {
			year = Integer.parseInt(yearStr);
		}
		String dayStr = dateStr.substring(0, 2);
		if (dayStr.startsWith("0"))
			dayStr = dayStr.substring(1, 2);
		String hourStr = timeStr.substring(0, 2);
		if (hourStr.startsWith("0"))
			hourStr = hourStr.substring(1, 2);
		String minuteStr = null;
		minuteStr = timeStr.substring(2, 4);
		if (minuteStr.startsWith("0"))
			minuteStr = minuteStr.substring(1, 2);
		Date flightDate = null;
		try {
			flightDate = getDate(year, monthCode, Integer.parseInt(dayStr),
					Integer.parseInt(hourStr), Integer.parseInt(minuteStr), 0);
		} catch (Exception e) {
			log.error("", e);
		}
		return flightDate;
	}
	
	public static Date parseDate(String str) throws ParseException {
		return parseDate(str, parsePatterns);
	}

	public static Date parseDate(String str, String parsePattern)
			throws ParseException {
		return parseDate(str, new String[] { parsePattern });
	}
	

	public static String pattern(String date , String parsePattern) throws ParseException{
		SimpleDateFormat dateFormat=new SimpleDateFormat(parsePattern);
		return dateFormat.format(dateFormat.parse(date));
	}
	
	public static String format(Date date , String parsePattern){
		SimpleDateFormat dateFormat=new SimpleDateFormat(parsePattern);
		return dateFormat.format(date);
	}

	public static Calendar getCalendar(Date date) {
		if (date == null) {
			return null;
		} else {
			Calendar c = new GregorianCalendar();
			c.setTime(date);
			return c;
		}
	}

	public static Date addMonth(Calendar c, int months) {
		if (c == null) {
			return null;
		} else {
			c.add(2, months);
			return c.getTime();
		}
	}

	public static Date addDay(Calendar c, int days) {
		if (c == null) {
			return null;
		} else {
			c.add(5, days);
			return c.getTime();
		}
	}

	public static Date addMinutes(Calendar c, int minutes) {
		if (c == null) {
			return null;
		} else {
			c.add(12, minutes);
			return c.getTime();
		}
	}

	public static Date addHours(Calendar c, int hours) {
		if (c == null) {
			return null;
		} else {
			c.add(11, hours);
			return c.getTime();
		}
	}

	public static Date addHoursAndMin(Calendar c, int hours, int minutes) {
		if (c == null) {
			return null;
		} else {
			c.add(11, hours);
			c.add(12, minutes);
			return c.getTime();
		}
	}

	public static int getDayOfWeek(Date date) {
		Calendar c = getCalendar(date);
		int dayOfWeek = c.get(7) - 1;
		return dayOfWeek != 0 ? dayOfWeek : 7;
	}

	public static String getDayOfWeekCn(Date date) {
		if (date == null)
			return null;
		int t = getDayOfWeek(date);
		if (t == 7)
			t = 0;
		return DAY_CNAME[t];
	}

	public static Date getDate(String monthCode, int day) {
		if (monthCode == null)
			return null;
		Calendar c = getCalendar(new Date());
		int i = 0;
		String as[];
		int k = (as = MONTH_ENAME).length;
		for (int j = 0; j < k; j++) {
			String monthStr = as[j];
			if (monthStr.equalsIgnoreCase(monthCode))
				break;
			i++;
		}

		c.set(2, i);
		c.set(5, day);
		return c.getTime();
	}

	public static Date getDate(int year, String monthCode, int day) {
		if (monthCode == null)
			return null;
		Calendar c = getCalendar(new Date());
		int i = 0;
		String as[];
		int k = (as = MONTH_ENAME).length;
		for (int j = 0; j < k; j++) {
			String monthStr = as[j];
			if (monthStr.equalsIgnoreCase(monthCode))
				break;
			i++;
		}

		c.set(year, i, day);
		return c.getTime();
	}

	public static Date getDate(int year, String monthCode, int day,
			int hourOfDay, int minute, int second) {
		if (monthCode == null)
			return null;
		Calendar c = new GregorianCalendar();
		int i = 0;
		String as[];
		int k = (as = MONTH_ENAME).length;
		for (int j = 0; j < k; j++) {
			String monthStr = as[j];
			if (monthStr.equalsIgnoreCase(monthCode))
				break;
			i++;
		}

		c.setTimeInMillis(0L);
		c.set(year, i, day, hourOfDay, minute, second);
		return c.getTime();
	}

	public static boolean isLeapYear(int year) {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.isLeapYear(year);
	}

	public static java.sql.Date utilDate2SqlDate(Date date) {
		if (date == null) {
			return null;
		} else {
			Calendar c = getCalendar(date);
			java.sql.Date sqlDate = new java.sql.Date(c.getTimeInMillis());
			return sqlDate;
		}
	}

	@SuppressWarnings("unchecked")
	public static Timestamp getTimestamp(Object value) {
		if (value == null)
			return null;
		Timestamp timestamp = null;
		if (value instanceof Timestamp) {
			timestamp = (Timestamp) value;
		} else {
			Class clz = value.getClass();
			Method m = null;
			try {
				m = clz.getMethod("timestampValue", null);
				timestamp = (Timestamp) m.invoke(value, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return timestamp;
	}

	public static double getIntervalMinutes(Date minDate, Date maxDate) {
		double days = 0.0D;
		if (minDate == null || maxDate == null)
			return days;
		try {
			long interval = maxDate.getTime() - minDate.getTime();
			days = Double.valueOf(interval).doubleValue() / 1000D / 60D;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return days;
	}

	public static double getIntervalHours(Date minDate, Date maxDate) {
		double days = 0.0D;
		if (minDate == null || maxDate == null)
			return days;
		try {
			days = getIntervalMinutes(minDate, maxDate) / 60D;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return days;
	}

	public static boolean checkIsIntervalDay(String startTime, String endTime,
			String format) {
		boolean isIntervalDay = false;
		if (parsePatterns[2].equals(format) && "00:00".compareTo(endTime) < 0
				&& "12:00".compareTo(endTime) >= 0
				&& "12:00".compareTo(startTime) < 0
				&& "23:59".compareTo(startTime) >= 0)
			isIntervalDay = true;
		else if (parsePatterns[5].equals(format)
				&& "0000".compareTo(endTime) < 0
				&& "1200".compareTo(endTime) >= 0
				&& "1200".compareTo(startTime) < 0
				&& "2359".compareTo(startTime) >= 0)
			isIntervalDay = true;
		else
			log.error((new StringBuilder(String.valueOf(startTime)))
					.append(" ").append(endTime).append(" ").append(format)
					.toString());
		return isIntervalDay;
	}

	public static double getIntervalDays(Date minDate, Date maxDate) {
		double days = 0.0D;
		if (minDate == null || maxDate == null)
			return days;
		try {
			days = getIntervalHours(minDate, maxDate) / 24D;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return days;
	}
}
