package com.gapon.designpattern.observer.SpringApplicationContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WeChatAccounts implements ApplicationContextAware {
    private ApplicationContext ctx;
    private String name;

    public WeChatAccounts(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publishArticles(String articleName, String content) {
        System.out.println(String.format("\n<%s>微信公众号 发布了一篇推送，文章名称为 <%s>，内容为 <%s> ", this.name, articleName, content));
        ctx.publishEvent(new WechatNotice(this.name, this.name, articleName));
    }

}
