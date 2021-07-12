package com.github.inchh.dormbot.listener;

import com.github.inchh.dormbot.filter.TimeChecker;
import com.github.inchh.dormbot.util.Dormitories;
import com.github.inchh.dormbot.model.Dormitory;
import com.github.inchh.dormbot.util.OutputUtil;
import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.Filters;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.api.message.containers.GroupAccountInfo;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.filter.MatchType;
import love.forte.simbot.filter.MostMatchType;
import love.forte.simbot.listener.ListenerContext;

import java.util.ArrayList;

/**
 * 监听群消息：人齐
 *
 * @author In_Chh
 * @since 1.0
 */
@Beans
public class AllReachListener {

    @OnGroup
    @Filters(value = {
            @Filter(value = "#", matchType = MatchType.STARTS_WITH),
            @Filter(value = "齐", matchType = MatchType.CONTAINS)
    }, mostMatchType = MostMatchType.ALL)
    public void allReach(GroupMsg msg, MsgSender msgSender, ListenerContext context) {
        if (TimeChecker.check()) {
            GroupAccountInfo accountInfo = msg.getAccountInfo();
            String accountCode = accountInfo.getAccountCode();
            ArrayList<Dormitory> dormitoryList = Dormitories.getDormitoryList();
            for (Dormitory d : dormitoryList) {
                if (accountCode.equals(d.getDormMaster())) {
                    ArrayList<String> personNotBack = d.getPersonNotBack();
                    if (!personNotBack.isEmpty()) {
                        personNotBack.clear();
                    }
                    d.setCurrentPersonCount(d.getTotalPersonCount());
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
