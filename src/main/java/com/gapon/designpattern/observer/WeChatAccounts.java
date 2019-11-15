package com.gapon.designpattern.observer;


import java.util.Observable;

public class WeChatAccounts extends Observable {
    private String name;

    public WeChatAccounts(String name) {
        this.name = name;
    }

    public void publishArticles(String articleName, String content) {
        System.out.println(String.format("\n<%s>微信公众号 发布了一篇推送，文章名称为 <%s>，内容为 <%s> ", this.name, articleName, content));
        setChanged();
        notifyObservers(new WechatNotice(this.name, articleName));
    }
}

