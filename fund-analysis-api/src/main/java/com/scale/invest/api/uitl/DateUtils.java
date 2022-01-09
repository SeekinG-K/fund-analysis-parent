package com.scale.invest.api.uitl;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {
    private DateUtils() {
    }

    public static Date toDate(String value) {
        return toDate(value, "yyyy-MM-dd");
    }

    public static Date toDate(String value, String format) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String stringNow() {
        return stringNow("yyyy-MM-dd");
    }

    public static String stringNow(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static int intNow() {
        return Integer.parseInt(stringNow("yyyyMMdd"));
    }

    public static String intDateTime() {
        String pattern = "yyyyMMddHHmmss";
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static Integer intNowTime() {
        String pattern = "HHmmss";
        return Integer.parseInt(LocalTime.now().format(DateTimeFormatter.ofPattern(pattern)));
    }

    public static String nowTime(boolean mills) {
        String pattern = mills ? "HH:mm:ss.SSS" : "HH:mm:ss";
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String nowDateTime() {
        return nowDateTime(false);
    }

    public static String nowDateTime(boolean mills) {
        String pattern = mills ? "yyyy-MM-dd HH:mm:ss.SSS" : "yyyy-MM-dd HH:mm:ss";
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String nowNumberDateTime(boolean mills) {
        String pattern = mills ? "yyyyMMddHHmmssSSS" : "yyyyMMddHHmmss";
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getMonthDateHourMin() {
        return nowNumberDateTime(false).substring(4, 12);
    }

    public static Date parseDate(int date) throws ParseException {
        return parseDate(String.valueOf(date), "yyyyMMdd");
    }

    public static Date parseDate(String date) throws ParseException {
        return parseDate(date, "yyyy-MM-dd");
    }

    public static Date parseDate(String date, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(date);
    }


    public static void main(String[] args) {
        try {

            System.out.println(parseDate(intNow()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();

        cal.setTime(smdate);

        long time1 = cal.getTimeInMillis();

        cal.setTime(bdate);

        long time2 = cal.getTimeInMillis();

        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(betweenDays));
    }

    /**
     * 计算当前日期的days天数后的日期
     *
     * @param days 天数
     * @throws ParseException
     */
    public static String daysAfter(String currentDate, int days) {
        return doCalculateAfter(currentDate, days, 1);
    }

    /**
     * 计算当前日期的months月后的日期
     *
     * @param months 月数
     * @throws ParseException
     */
    public static String monthsAfter(String currentDate, int months) {
        return doCalculateAfter(currentDate, months, 2);
    }

    private static String doCalculateAfter(String currentDate, int item, int type) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar curr = Calendar.getInstance();
        try {
            curr.setTime(sdf.parse(currentDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (type == 1) {
            curr.add(Calendar.DATE, item);
        } else {
            curr.add(Calendar.MONTH, item);
        }
        Date date = curr.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(date);
    }
}
