package com.cad.carlink.weixin.test.staticTest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -2);
        System.out.println(sdf.format(getStartTime(calendar)));
        System.out.println(sdf.format(getEndTime(calendar)));

        test();
        test1();
    }

    private static Date getStartTime(Calendar todayStart) {
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    private static Date getEndTime(Calendar todayEnd) {
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public  static  void test(){
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));    //获取东八区时间
        int year = c.get(Calendar.YEAR);    //获取年
        int month = c.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
        int day = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        int first = c.getActualMinimum(c.DAY_OF_MONTH);    //获取本月最小天数
        int last = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数
        int time = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
    }

    public static void test1(){
        String beginTime = "2018-07-28 14:42:32";
        String endTime = "2018-07-29 12:26:32";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(beginTime);
            Date date2 = format.parse(endTime);
            Date dateNow=new Date();
            long beginMillisecond = date1.getTime();
            long endMillisecond = date2.getTime();
            System.out.println(dateNow.getTime());
            System.out.println(beginMillisecond > endMillisecond);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
