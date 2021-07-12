package com.github.inchh.dormbot.listener;

import com.github.inchh.dormbot.filter.TimeChecker;
import com.github.inchh.dormbot.model.Dormitory;
import com.github.inchh.dormbot.util.Dormitories;
import com.github.inchh.dormbot.util.OutputUtil;
import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.Filters;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.sender.MsgSender;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 监听群消息：人不齐的情况
 *
 * @author In_Chh
 * @since 1.0
 */
@Beans
public class NotAllReachListener {
    @OnGroup
    @Filters(customFilter = "notAllReachFilter")
    public void notAllReachListener(GroupMsg msg, MsgSender msgSender) {
        if (TimeChecker.check()) {
            //获取群消息
            String text = msg.getText();
            //获取发送群消息的qq账号
            String accountCode = msg.getAccountInfo().getAccountCode();
            //获取宿舍对象列表
            ArrayList<Dormitory> dormitoryList = Dormitories.getDormitoryList();
            //去除无用字符，保留到寝人数，未归名单（以中文逗号分隔）
            String s1 = text.replaceAll("[#人未归]", "");
            //以中文逗号为分隔符，切分s1字符串
            String[] strings = s1.split("，");

            for (Dormitory d : dormitoryList) {
                if (accountCode.equals(d.getDormMaster())) {
                    ArrayList<String> personNotBack = d.getPersonNotBack();
                    if (!personNotBack.isEmpty()) {
                        personNotBack.clear();
                    }
                    d.setCurrentPersonCount(Integer.parseInt(strings[0]));
                    personNotBack.addAll(Arrays.asList(strings).subList(1, strings.length));
                    msgSender.SENDER.sendGroupMsg(msg, OutputUtil.output(dormitoryList));
                    msgSender.SENDER.sendGroupMsg(msg, "如果人齐请输入：#齐；\n不齐请输入：#x人，xxx，yyy未归\n（中文逗号，请一定要按照这个格式发消息）");
                    return;
                }
            }
        } else {
            msgSender.SENDER.sendGroupMsg(msg, "当前不在报寝时间内！");
        }
    }
}
