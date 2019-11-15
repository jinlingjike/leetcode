package com.gapon.designpattern.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WechatNotice {
    private String publisher;
    private String articleName;
}
