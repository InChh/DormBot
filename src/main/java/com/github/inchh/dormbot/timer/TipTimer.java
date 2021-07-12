package com.github.inchh.dormbot.timer;

import catcode.CatCodeUtil;
import catcode.CodeTemplate;
import love.forte.common.ioc.annotation.Beans;
import love.forte.common.ioc.annotation.Depend;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.bot.BotManager;
import love.forte.simbot.timer.Cron;
import love.forte.simbot.timer.EnableTimeTask;

/**
 * 定时器事件类，用于定时发送一些提示信息
 * @author In_Chh
 * @since 1.0
 */
@Beans
@EnableTimeTask
public class TipTimer {
    @Depend
    private BotManager botManager;

    /**
     * 催宿舍长们报寝
     * @since 1.0
     */
    @Cron("0 0 22 * * ? *")
    public void tip() {
        CatCodeUtil catCodeUtil = CatCodeUtil.INSTANCE;
        CodeTemplate<String> stringTemplate = catCodeUtil.getStringTemplate();
        String atAll = stringTemplate.atAll();
        for (Bot bot : botManager.getBots()) {
            //TODO: 增加配置文件替换固定群号
            bot.getSender().SENDER.sendGroupMsg(1158255260, "gkd gkd" + atAll);
            bot.getSender().SENDER.sendGroupMsg(1158255260, "如果人齐请输入：#齐\n不齐请输入：#x人，xxx，yyy未归\n（中文逗号，请一定要按照这个格式发消息）");
        }

    }

    /**
     * 提示熄灯
     * @since 1.0.1
     */
    @Cron("5 0 23 * * ? *")
    public void sleep() {
        for (Bot bot : botManager.getBots()) {
            bot.getSender().SENDER.sendGroupMsg(1158255260, "熄灯~~~~");
        }
    }
}
