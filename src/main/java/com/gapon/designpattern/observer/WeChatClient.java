package com.gapon.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class WeChatClient implements Observer {
    private String username;

    public WeChatClient(String username) {
        this.username = username;
    }

    @Override
    public void update(Observable o, Object arg) {
        //WeChatAccounts weChatAccounts = (WeChatAccounts) o;
        WechatNotice notice = (WechatNotice) arg;
        System.out.println(String.format("用户<%s> 接收到 <%s>微信公众号 的推送，文章标题为 <%s>", username, notice.getPublisher(), notice.getArticleName()));
    }
}
