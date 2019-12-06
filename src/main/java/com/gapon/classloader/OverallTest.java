package com.gapon.classloader;

class Father6{
    public static int a = 1;
    static {
        System.out.println("父类粑粑静态代码块");
    }
}
class Son6{
    public static int b = 2;
    static {
        System.out.println("子类熊孩子静态代码块");
    }
}

public class OverallTest {
    static {
        System.out.println("Main方法静态代码块");
    }

    public static void main(String[] args) {
        Father6 father6;
        System.out.println("======");

        father6=new Father6();
        System.out.println("======");

        System.out.println(Father6.a);
        System.out.println("======");

        System.out.println(Son6.b);
        Thread.currentThread().getContextClassLoader();
    }
}
