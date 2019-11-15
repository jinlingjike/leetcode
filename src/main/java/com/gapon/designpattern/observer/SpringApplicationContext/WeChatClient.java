package com.gapon.designpattern.observer.SpringApplicationContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class WeChatClient implements ApplicationListener {
    private String username;

    public WeChatClient(String username) {
        this.username = username;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof WechatNotice) {
            WechatNotice notice = (WechatNotice) event;
            System.out.println(String.format("用户<%s> 接收到 <%s>微信公众号 的推送，文章标题为 <%s>", username, notice.getPublisher(), notice.getArticleName()));
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
