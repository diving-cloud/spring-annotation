package com.atguigu.test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

/**
 * @author hezongkui <hezongkui@kuaishou.com>
 * Created on 2022-03-14
 */
public class DateTest {

    @Test
    public  void testDate() throws ParseException {

        Date date = DateUtils.parseDate("2021-07-15", "yyyy-MM-dd");
        Date date1 = DateUtils.addDays(date, 1);//加一天
        System.out.println(date1);

        boolean sameDay = DateUtils.isSameDay(date, new Date());//比较
        System.out.println(sameDay);
    /*
        获取一段日期
        RANGE_WEEK_SUNDAY 从周日开始获取一周日期
        RANGE_WEEK_MONDAY 从周一开始获取一周日期
        RANGE_WEEK_RELATIVE 从当前时间开始获取一周日期
        RANGE_WEEK_CENTER 以当前日期为中心获取一周日期
        RANGE_MONTH_SUNDAY 从周日开始获取一个月日期
        RANGE_MONTH_MONDAY 从周一开始获取一个月日期
        */
        Iterator<Calendar> iterator = DateUtils.iterator(date, DateUtils.RANGE_WEEK_CENTER);
        while (iterator.hasNext()) {
            Calendar next = iterator.next();
            System.out.println(DateFormatUtils.format(next, "yyyy-MM-dd"));
        }
    }
}
