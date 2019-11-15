package com.gapon.leetcode.algorithm.stackUtils;

import org.springframework.util.StringUtils;

import java.util.Stack;

public class RemoveDuplicates {
    public static String removeDuplicates(String s, int k) {
        if(s.isEmpty()){
            return "";
        }
        char[]  ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stackTemp = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();

        int count = 1;
        char tmp = ch[0];
         stack.push(ch[0]);
        for (int i = 1; i< ch.length; i++){
           stack.push(ch[i]);
           if(tmp == ch[i]){
               count++;
               if(count == k){
                   for(int j = 0;j<k;j++){
                       stack.pop();
                   }
                   if(!stack.empty()){
                       char charcter = stack.pop();
                       count = 1;

                       tmp = charcter;
                     stackTemp.push(tmp);
                       while(tmp == charcter && !stack.empty()){
                           charcter = stack.pop();
                           stackTemp.push(charcter);
                           if(tmp == charcter){
                               count ++;
                           }
                       }
                       while(!stackTemp.empty()){
                          stack.push(stackTemp.pop());
                       }
                   }else{
                       count = 0;
                   }


               }
           }else{
               tmp = ch[i];
               count = 1;
           }
       }
        while(!stack.empty()){
            stringBuffer = stringBuffer.append(stack.pop());
        }
        return stringBuffer.reverse().toString();

    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s,k));
    }
}
