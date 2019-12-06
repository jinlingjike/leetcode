package com.gapon.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static Map<String, String> userPhoneConvert = new HashMap<String, String>();

    public static void main(String[] args) {
        int i = 0;
        while(i<1000000){
            userPhoneConvert.put("11111","21111111");
            i++;

        }
        System.out.println(userPhoneConvert.size());
    }
}
