package com.wkang;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	final static SimpleDateFormat FORMAT_YY_M = new SimpleDateFormat("yy-M");

	final static SimpleDateFormat FORMAT_MM_DD_HH_MM = new SimpleDateFormat(
			"MM-dd HH:mm");
	final static SimpleDateFormat FORMAT_YYYY_MM = new SimpleDateFormat(
			"yyyy-MM");
	final static SimpleDateFormat FORMAT_YYYY_MM_DD = new SimpleDateFormat(
			"yyyy-MM-dd");
	final static SimpleDateFormat FORMAT_YYYY_MM_DD_HH_mm_ss = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	final static SimpleDateFormat FORMAT_YYYYMMDDHHmmssSSS = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	final static SimpleDateFormat FORMAT_YYYY_MM_DD_CN = new SimpleDateFormat(
			"yyyy年MM月dd日");
	final static SimpleDateFormat FORMAT_MM_DD_CN = new SimpleDateFormat(
			"yyyy年MM月dd日");
	final static SimpleDateFormat FORMAT_WEEK_CN = new SimpleDateFormat("EEEE", Locale.US);  
	
    // /
    // 定义时间日期显示格式
    // /
    private final static String MONTH_FORMAT = "yyyy-MM";
	
    private final static String DATE_FORMAT = "yyyy-MM-dd";
    
    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public final static int TIME_DAY_MILLISECOND = 86400000;

	public static String format_YY_M(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YY_M.format(date);
	}

	public static Long getTime(Date date) {
		if (date == null) {
			return null;
		}
		return date.getTime();
	}
	
	public static String format_MM_DD_HH_MM(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_MM_DD_HH_MM.format(date);
	}

	public static String format_YYYY_MM(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYY_MM.format(date);
	}

	public static String format_YYYY_MM_DD(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYY_MM_DD.format(date);
	}

	public static String format_YYYY_MM_DD_CN(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYY_MM_DD_CN.format(date);
	}

	public static String format_MM_DD_CN(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_MM_DD_CN.format(date);
	}
	
	public static String format_WEEK_CN(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_WEEK_CN.format(date);
	}
	
	public static String format_YYYY_MM_DD_HH_mm_ss(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYY_MM_DD_HH_mm_ss.format(date);
	}

	public static String format_YYYYMMDDHHmmssSSS(Date date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYYMMDDHHmmssSSS.format(date);
	}

	public static String format_YY_M(Long date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YY_M.format(date);
	}

	public static String format_YYYY_MM(Long date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYY_MM.format(date);
	}

	public static String format_YYYY_MM_DD(Long date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYY_MM_DD.format(date);
	}

	public static String format_YYYY_MM_DD_HH_mm_ss(Long date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYY_MM_DD_HH_mm_ss.format(date);
	}

	public static String format_YYYYMMDDHHmmssSSS(Long date) {
		if (date == null) {
			return null;
		}
		return FORMAT_YYYYMMDDHHmmssSSS.format(date);
	}

	public static Date getFrom_YYYY_MM_DD_HH_mm_ss(String date)
			throws ParseException {
		if (date == null || "".equals(date)) {
			return null;
		}
		return FORMAT_YYYY_MM_DD_HH_mm_ss.parse(date);
	}

	public static Date getFrom_YYYY_MM_DD(String date) throws ParseException {
		if (date == null || "".equals(date)) {
			return null;
		}
		return FORMAT_YYYY_MM_DD.parse(date);
	}

	public static Date getFrom_YYYY_MM(String date) throws ParseException {
		if (date == null || "".equals(date)) {
			return null;
		}
		return FORMAT_YYYY_MM.parse(date);
	}
	
	public static Date getFrom_WEEK_CN(String date) throws ParseException {
		if (date == null || "".equals(date)) {
			return null;
		}
		return FORMAT_WEEK_CN.parse(date);
	}

	public static Calendar getCalendar(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static Calendar getCalendar(Long millis) {
		if (millis == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar;
	}

	public static Date UTCToCST(Date UTCDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(UTCDate);
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
		return calendar.getTime();
	}

	public static boolean equals_Y_M(Date date1, Date date2) {
		Calendar calendar1 = getCalendar(date1);
		Calendar calendar2 = getCalendar(date2);
		if (calendar1.get(Calendar.YEAR) != calendar2.get(Calendar.YEAR)) {
			return false;
		}
		if (calendar1.get(Calendar.MONTH) != calendar2.get(Calendar.MONTH)) {
			return false;
		}
		return true;
	}

	public static Date addYear(Date date, int dyear) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		calendar.add(Calendar.YEAR, dyear);
		return calendar.getTime();
	}

	public static Date addYear(Long date, int dyear) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		calendar.add(Calendar.YEAR, dyear);
		return calendar.getTime();
	}

	public static Date addMonth(Date date, int dmonth) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		calendar.add(Calendar.MONTH, dmonth);

		return calendar.getTime();
	}

	public static Date addMonth(Long date, int dmonth) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		calendar.add(Calendar.MONTH, dmonth);

		return calendar.getTime();
	}

	public static Date addDay(Date date, int dday) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		calendar.add(Calendar.DAY_OF_MONTH, dday);
		return calendar.getTime();
	}

	public static Date addDay(Long date, int dday) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		calendar.add(Calendar.DAY_OF_MONTH, dday);
		return calendar.getTime();
	}

	/**
	 * 截取时间年月
	 */
	public static Date simpleYEARMONTH(Date date, int dmonth) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.add(Calendar.MONTH, dmonth);
		return calendar.getTime();
	}

	/**
	 * 截取时间年月
	 */
	public static Date simpleYEARMONTH(Long date, int dmonth) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.add(Calendar.MONTH, dmonth);
		return calendar.getTime();
	}

	/**
	 * 截取时间年月
	 */
	public static Date simpleYY_MM_DD(Long date, int dmonth, int dday) {
		Calendar calendar = getCalendar(date);
		if (calendar == null) {
			return null;
		}
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.add(Calendar.MONTH, dmonth);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.add(Calendar.DAY_OF_MONTH, dday);
		return calendar.getTime();
	}

	// public static int compareToCurrent_Y_M(Date date) {
	// if (date == null) {
	// return -1;
	// }
	// return compareToCurrent_Y_M(date.getTime());
	// }
	//
	// public static int compareToCurrent_Y_M(long date) {
	// Calendar src = Calendar.getInstance();
	// src.setTimeInMillis(date);
	// return compareToCurrent_Y_M(src);
	// }
	//
	// public static int compareToCurrent_Y_M(Calendar src) {
	// Calendar curr = Calendar.getInstance();
	// curr.setTimeInMillis(System.currentTimeMillis());
	// if (src.get(Calendar.YEAR) < curr.get(Calendar.YEAR)) {
	// return -1;
	// }
	// if (src.get(Calendar.MONTH) < curr.get(Calendar.MONTH)) {
	// return -1;
	// }
	// if (src.get(Calendar.YEAR) == curr.get(Calendar.YEAR)
	// && src.get(Calendar.MONTH) == curr.get(Calendar.MONTH)) {
	// return 0;
	// }
	// return 1;
	// }
	
    /**
     * 得到格式化后的日期，格式为yyyy-MM-dd，如2006-02-15
     *
     * @param currDate
     *                要格式化的日期
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的日期，默认格式为为yyyy-MM-dd，如2006-02-15
     */
    public static String getFormatDate(Date currDate) {
        return getFormatDate(currDate, DATE_FORMAT);
    }
    
    /**
     * 根据格式得到格式化后的日期
     *
     * @param currDate
     *                要格式化的日期
     * @param format
     *                日期格式，如yyyy-MM-dd
     * @see SimpleDateFormat#format(Date)
     * @return String 返回格式化后的日期，格式由参数<code>format</code>
     *         定义，如yyyy-MM-dd，如2006-02-15
     */
    public static String getFormatDate(Date currDate, String format) {
        if (currDate == null) {
            return "";
        }
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.format(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(DATE_FORMAT);
            try {
                return dtFormatdB.format(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }
    
    /**
     * 根据格式得到格式化后的时间
     *
     * @param currDate
     *                要格式化的时间
     * @param format
     *                时间格式，如yyyy-MM-dd HH:mm:ss
     * @see SimpleDateFormat#parse(String)
     * @return Date 返回格式化后的时间，格式由参数<code>format</code>定义，如yyyy-MM-dd
     *         HH:mm:ss
     */
    public static Date getFormatDateTime(String currDate, String format) {
        if (currDate == null) {
            return null;
        }
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(TIME_FORMAT);
            try {
                return dtFormatdB.parse(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }
    
    /**
     * 得到日期的前或者后几天
     *
     * @param iDate
     *                如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
     * @see Calendar#add(int, int)
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几天
     */
    public static Date getDateBeforeOrAfter(Date curDate, int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.DAY_OF_MONTH, iDate);
        return cal.getTime();
    }
	
    /**
     * @author lenghao
     * @createTime 2008-8-5 下午01:57:09
     * @param first
     * @param second
     * @return 获取两个Date之间的天数的列表
     */
    public static List<Date> getDaysListBetweenDates(Date first, Date second) {
        List<Date> dateList = new ArrayList<Date>();
        Date d1 = getFormatDateTime(getFormatDate(first),DATE_FORMAT);
        Date d2 = getFormatDateTime(getFormatDate(second),DATE_FORMAT);
        if(d1.compareTo(d2)>0) {
            return dateList;
        }
        do {
            dateList.add(d1);
            d1 = getDateBeforeOrAfter(d1, 1);
        } while (d1.compareTo(d2) <= 0);
        return dateList;
    }
    
    /**
     * alahan add 20050825 获取传入时间相差的日期
     *
     * @param dt
     *                传入日期，可以为空
     * @param diff
     *                需要获取相隔diff天的日期 如果为正则取以后的日期，否则时间往前推
     * @return
     */
    public static String getDiffStringDate(Date dt, int diff) {
        Calendar ca = Calendar.getInstance();

        if (dt == null) {
            ca.setTime(new Date());
        } else {
            ca.setTime(dt);
        }

        ca.add(Calendar.DATE, diff);
        return dtSimpleFormat(ca.getTime());
    }
    
    /**
     * yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static final String dtSimpleFormat(Date date) {
        if (date == null) {
            return "";
        }

        return getFormat(DATE_FORMAT).format(date);
    }
    
    // SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final DateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }
    
    /**
     * 获取传入月的总天数
     */
    public static String getDateDiffMonth(Date currentDate,int number) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, number);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }
    
    /**
     * 获取传入月的第一天是星期几
     */
    public static String getFirstDayWeek(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format = new SimpleDateFormat("E");
		
		return format.format(calendar.getTime());
    }

	/**
	 * @return -1 date1 < date2 0 date1 = date2 1 date1 > date2
	 */

	public static int compare_Y_M(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);

		if (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
				&& calendar1.get(Calendar.MONTH) == calendar2
						.get(Calendar.MONTH)) {
			return 0;
		}
		if (calendar1.get(Calendar.YEAR) < calendar2.get(Calendar.YEAR)) {
			return -1;
		}
		if (calendar1.get(Calendar.MONTH) < calendar2.get(Calendar.MONTH)) {
			return -1;
		}

		return 1;
	}
	
	public static int compare_Y_M_D(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);

		if (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
				&& calendar1.get(Calendar.MONTH) == calendar2
						.get(Calendar.MONTH)&& calendar1.get(Calendar.DATE) == calendar2
								.get(Calendar.DATE)) {
			return 0;
		}
		if (calendar1.get(Calendar.YEAR) < calendar2.get(Calendar.YEAR)) {
			return -1;
		}
		if (calendar1.get(Calendar.MONTH) < calendar2.get(Calendar.MONTH)) {
			return -1;
		}
		if (calendar1.get(Calendar.DATE) < calendar2.get(Calendar.DATE)) {
			return -1;
		}

		return 1;
	}
	
	public static int getTotalDay(Date currentDate){
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.set(Calendar.YEAR,cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));//Java月份才0开始算
		int monthTotalDay = cal.getActualMaximum(Calendar.DATE);
		
		return monthTotalDay;
	}
	
    /**
     * 获得两个Date型日期之间相差的天数（第2个减第1个）
     *
     * @param Date
     *                first, Date second
     * @return int 相差的天数
     */
    public static int getDaysBetweenDates(Date first, Date second) {
        Date d1 = getFormatDateTime(getFormatDate(first), DATE_FORMAT);
        Date d2 = getFormatDateTime(getFormatDate(second), DATE_FORMAT);

        Long mils = (d2.getTime() - d1.getTime()) / (TIME_DAY_MILLISECOND);

        return mils.intValue();
    }
    
    /**
     * 得到本日的上月时间 如果当日为2007-9-1,那么获得2007-8-1
     */
    public static String getDateBeforeMonth(Date currentDate, int number) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, number);
        return getFormatDate(cal.getTime(), MONTH_FORMAT);
    }
    
    /**
     * 得到日期的前或者后几小时
     *
     * @param iHour
     *                如果要获得前几小时日期，该参数为负数； 如果要获得后几小时日期，该参数为正数
     * @see Calendar#add(int, int)
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几小时
     */
    public static Date getDateBeforeOrAfterMinute(Date curDate, int iMinute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.MINUTE, iMinute);
        return cal.getTime();
    }
    

    /**
     * 得到格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
     *
     * @param currDate
     *                要格式化的日期
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
     */
    public static String getFirstDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 得到格式化后的当月最后一天，格式为yyyy-MM-dd，如2006-02-28
     *
     * @param currDate
     *                要格式化的日期
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的当月最后一天，格式为yyyy-MM-dd，如2006-02-28
     */
    public static String getLastDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }
    
    public static String getDateBeforeDay(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }
	
	public static void main(String[] args) throws ParseException {	
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date first = sdf.parse("2016-07-19");  
		Date second = sdf.parse("2016-07-17"); 
		Date createTime = sdf.parse("2017-04-15 12:54:55"); 
		System.out.println(getDateBeforeDay(second));
		System.out
				.println(getDaysListBetweenDates(first, second));
		System.out
			.println(format_WEEK_CN(first));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(first);
		cal.set(Calendar.YEAR,cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));//Java月份才0开始算
		int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
		System.out
		.println(dateOfMonth);
		
		System.out
		.println(getDateDiffMonth(first, -1));
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format = new SimpleDateFormat("E");
		System.out.println("本月第一天是：" + format.format(calendar.getTime())); 
		
		System.out.println(getDateBeforeMonth(second, -1));
		
		System.out.println(format_WEEK_CN(second));
		System.out.println(getDateBeforeOrAfterMinute(new Date(), 15));

		Date systemDate = new Date();
		System.out.println(DateUtil.compare_Y_M_D(systemDate, createTime));
		System.out.println("15212783813".substring("15212783813".length()-6, "15212783813".length()));
		
		String str1 = "103000".replaceAll("0*$","");
		String str2 = "13400";
		System.out.println(str2.contains(str1));
		
		DecimalFormat df=new DecimalFormat("0");
		System.out.println(df.format((float)10/0*100));		
		
		String nos = "123213";
		System.out.println(nos.split(",").length);		
		
//		System.out.println(format_YYYY_MM_DD_CN(getCalendar(
//				System.currentTimeMillis()).getTime()));
//
//		System.out.println(format_YYYY_MM_DD_HH_mm_ss(1427763525000l));

		// Calendar start = Calendar.getInstance();
		// start.set(2014, 6, 11);
		// Long startTIme = start.getTimeInMillis();
		//
		// Calendar end = Calendar.getInstance();
		// end.set(2014, 7, 11);
		// Long endTime = end.getTimeInMillis();
		//
		// Long oneDay = 1000 * 60 * 60 * 24l;
		//
		// Long time = startTIme;
		// while (time <= endTime) {
		// Date d = new Date(time);
		// System.out.println(FORMAT_YYYY_MM.format(d));
		// time += oneDay;
		// }
	}
}
