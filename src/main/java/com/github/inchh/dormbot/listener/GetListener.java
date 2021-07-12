package com.github.inchh.dormbot.listener;

import com.github.inchh.dormbot.model.Dormitory;
import com.github.inchh.dormbot.util.Dormitories;
import com.github.inchh.dormbot.util.OutputUtil;
import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.filter.MatchType;

import java.util.ArrayList;

/**
 * get命令监听类
 * @author In_Chh
 * @since 1.0.1
 */
@Beans
public class GetListener {

    /**
     * 监听get命令，发送归寝情况
     *
     * @param msg       群消息
     * @param msgSender 送信器
     */
    @OnGroup
    @Filter(value = "#get", matchType = MatchType.STARTS_WITH)
    public void getListener(GroupMsg msg, MsgSender msgSender) {
        ArrayList<Dormitory> dormitoryList = Dormitories.getDormitoryList();
        msgSender.SENDER.sendGroupMsg(msg, OutputUtil.output(dormitoryList));
    }
}
