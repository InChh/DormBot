package com.github.inchh.dormbot.util;

import com.github.inchh.dormbot.model.Dormitory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 消息输出工具类
 * @author In_Chh
 * @since 1.0
 */
public class OutputUtil {
    /**
     * 输出各寝室归寝情况
     * @param dormitoryList 寝室列表
     * @return String
     * @since 1.0
     */
    public static String output(ArrayList<Dormitory> dormitoryList) {
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        stringBuilder.append(sdf.format(date))
                .append("\n归寝情况：\n");
        for (Dormitory d : dormitoryList) {
            stringBuilder.append(d.toString())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
