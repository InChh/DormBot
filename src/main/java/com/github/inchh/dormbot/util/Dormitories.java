package com.github.inchh.dormbot.util;

import com.github.inchh.dormbot.model.Dormitory;

import java.util.ArrayList;

/**
 * 寝室工具类
 *
 * @author In_Chh
 * @since 1.0
 */
public class Dormitories {
    private static final ArrayList<Dormitory> DORMITORY_LIST = new ArrayList<>();

    /**
     * 初始化寝室列表，添加寝室信息
     *
     * @since 1.0
     */
    public static void init() {
        //TODO:使用配置文件替换硬编码
        DORMITORY_LIST.clear();
        DORMITORY_LIST.add(new Dormitory(13, 101, 4, "2788649891"));
        DORMITORY_LIST.add(new Dormitory(13, 102, 4, "2643484090"));
        DORMITORY_LIST.add(new Dormitory(13, 103, 4, "913276374"));
        DORMITORY_LIST.add(new Dormitory(13, 104, 4, "2319397152"));
        DORMITORY_LIST.add(new Dormitory(13, 105, 4, "1193435893"));
        DORMITORY_LIST.add(new Dormitory(13, 106, 3, "1127369073"));
        DORMITORY_LIST.add(new Dormitory(32, 101, 4, "1243384812"));
        DORMITORY_LIST.add(new Dormitory(32, 132, 4, "3029158184"));
        DORMITORY_LIST.add(new Dormitory(32, 224, 2, "1748178357"));
    }

    /**
     * 返回寝室对象列表
     *
     * @return 寝室对象列表
     */
    public static ArrayList<Dormitory> getDormitoryList() {
        return DORMITORY_LIST;
    }

    /**
     * 得到指定寝室的Dormitory对象
     *
     * @param buildingId      楼号
     * @param dormitoryNumber 寝室房间号
     * @return Dormitory对象, 如果传入无效参数则返回空Dormitory
     */
    public static Dormitory getDormitory(int buildingId, int dormitoryNumber) {
        for (Dormitory d : DORMITORY_LIST) {
            if (d.getBuildingId() == buildingId && d.getDormitoryNumber() == dormitoryNumber) {
                return d;
            }
        }
        return new Dormitory();
    }
}
