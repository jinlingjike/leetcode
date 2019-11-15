package com.gapon.designpattern.observer.SpringApplicationContext;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class WechatNotice extends ApplicationEvent {
    private String publisher;
    private String articleName;

    public WechatNotice(Object source, String publisher, String articleName) {
        super(source);
        this.publisher = publisher;
        this.articleName = articleName;
    }
}
