package com.github.inchh.dormbot.filter;

import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.filter.FilterData;
import love.forte.simbot.filter.ListenerFilter;
import org.jetbrains.annotations.NotNull;

/**
 * 自定义消息过滤器类,过滤得到人不齐的消息
 *
 * @author In_Chh
 * @since 1.0
 */
@Beans("notAllReachFilter")
public class NotAllReachFilter implements ListenerFilter {
    @Override
    public boolean test(@NotNull FilterData data) {
        String text = data.getMsgGet().getText();
        if (text != null) {
            return text.startsWith("#") && text.contains("未归");
        }
        return false;
    }
}
