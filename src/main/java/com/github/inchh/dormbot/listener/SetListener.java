package com.github.inchh.dormbot.listener;

import com.github.inchh.dormbot.util.Dormitories;
import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.FilterValue;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.annotation.Priority;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.filter.MatchType;

/**
 * set命令监听类
 *
 * @author In_Chh
 * @since 1.0.1
 */
@Beans
public class SetListener {
    /**
     * 监听set命令，设置指定寝室的归寝人数
     *
     * @param msg        群消息
     * @param msgSender  送信器
     * @param buildingId 建筑号
     * @param dormNumber 寝室房间号
     * @param currCount  目前归寝人数
     * @since 1.0.1
     */
    @OnGroup
    @Priority()
    @Filter(value = "#set (?<buildingId>\\d+) (?<dormNum>\\d+) (?<currCount>\\d+)", matchType = MatchType.REGEX_MATCHES)
    public void setListener(GroupMsg msg, MsgSender msgSender, @FilterValue("buildingId") int buildingId, @FilterValue("dormNum") int dormNumber, @FilterValue("currCount") int currCount) {
        //TODO:增加配置文件替换魔法值
        //TODO:设置指定寝室未归人员
        if ("2319397152".equals(msg.getAccountInfo().getAccountCode())) {
            Dormitories.getDormitory(buildingId, dormNumber).setCurrentPersonCount(currCount);
        }

    }
}
