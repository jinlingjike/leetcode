package com.gapon.designpattern.observer.SpringApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        WeChatAccounts accounts = (WeChatAccounts) context.getBean("WeChatAccounts");
        accounts.setName("小旋锋");
        accounts.setApplicationContext(context);

        accounts.publishArticles("设计模式 | 观察者模式及典型应用", "观察者模式的内容...");
    }
}
