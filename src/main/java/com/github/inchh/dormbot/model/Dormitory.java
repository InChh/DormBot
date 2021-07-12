package com.github.inchh.dormbot.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


/**
 * 寝室类
 * @author In_Chh
 */
@Getter
@Setter
public class Dormitory {
    private int buildingId;
    private int dormitoryNumber;
    private int totalPersonCount;
    private int currentPersonCount;
    private ArrayList<String> personNotBack = new ArrayList<>();
    private String dormMaster;

    public Dormitory() {
    }

    public Dormitory(int buildingId, int dormitoryNumber, int totalPersonCount, String dormMaster) {
        this.buildingId = buildingId;
        this.dormitoryNumber = dormitoryNumber;
        this.totalPersonCount = totalPersonCount;
        this.dormMaster = dormMaster;
    }

    @Override
    public String toString() {
        return buildingId + "栋" + dormitoryNumber + "：" + currentPersonCount + "/" + totalPersonCount
                + "，未归寝：" + personNotBack;
    }

}
