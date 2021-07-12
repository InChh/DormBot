package com.github.inchh.dormbot.filter;

import love.forte.common.ioc.annotation.Beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间检查类
 *
 * @author In_Chh
 * @since 1.0.1
 */
@Beans
public class TimeChecker {
    /**
     * 检查当前时间是否在报寝时间内
     *
     * @return 如在报寝时间内则返回true，否则返回false
     * @since 1.0.1
     */
    public static boolean check() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String nowTimeFormat = sdf.format(new Date());
        try {
            Date now = sdf.parse(nowTimeFormat);
            //TODO:增加配置文件替换固定字符串常量
            Date begin = sdf.parse("18:00:00");
            Date end = sdf.parse("23:59:59");
            Calendar nowCalendar = Calendar.getInstance();
            Calendar beginCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            nowCalendar.setTime(now);
            beginCalendar.setTime(begin);
            endCalendar.setTime(end);
            return nowCalendar.after(beginCalendar) && nowCalendar.before(endCalendar);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
