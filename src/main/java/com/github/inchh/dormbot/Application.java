package com.github.inchh.dormbot;

import love.forte.simbot.annotation.SimbotApplication;
import love.forte.simbot.core.SimbotApp;
import love.forte.simbot.core.SimbotContext;

/**
 * 程序入口类
 * @author In_Chh
 */
@SimbotApplication
public class Application {
    public static void main(String[] args) {
        final SimbotContext context = SimbotApp.run(Application.class,args);
    }
}
