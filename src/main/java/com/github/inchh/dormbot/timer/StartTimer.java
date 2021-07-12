package com.github.inchh.dormbot.timer;

import catcode.CatCodeUtil;
import catcode.CodeTemplate;
import com.github.inchh.dormbot.util.Dormitories;
import love.forte.common.ioc.annotation.Beans;
import love.forte.common.ioc.annotation.Depend;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.bot.BotManager;
import love.forte.simbot.timer.Cron;
import love.forte.simbot.timer.EnableTimeTask;

import java.util.List;

/**
 * 开始报寝定时任务类
 * @author In_Chh
 * @since 1.0
 */
@Beans
@EnableTimeTask
public class StartTimer {

    @Depend
    private BotManager botManager;

    /**
     * 初始化寝室列表并发送开始报寝消息
     * @since 1.0
     */
    @Cron(value = "5 0 21 * * ? *")
    public void startTimer() {
        Dormitories.init();
        List<Bot> bots = botManager.getBots();
        CatCodeUtil catCodeUtil = CatCodeUtil.INSTANCE;
        CodeTemplate<String> stringTemplate = catCodeUtil.getStringTemplate();
        String atAll = stringTemplate.atAll();
        for (Bot bot : bots) {
            //TODO: 增加配置文件替换固定群号
            bot.getSender().SENDER.sendGroupMsg(1158255260, "到点了，懂得都懂" + atAll);
            bot.getSender().SENDER.sendGroupMsg(1158255260, "如果人齐请输入：#齐\n不齐请输入：#x人，xxx，yyy未归\n（中文逗号，请一定要按照这个格式发消息）");
        }
    }
}
