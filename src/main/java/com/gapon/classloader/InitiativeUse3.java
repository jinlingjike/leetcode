package com.gapon.classloader;


class YeYe1{
    static {
        System.out.println("YeYe静态代码块");
    }
}

class Father1 extends YeYe1{
    public final static String strFather="HelloJVM_Father";

    static{
        System.out.println("Father静态代码块");
    }
}

class Son1 extends Father1{
    public static String strSon="HelloJVM_Son";

    static{
        System.out.println("Son静态代码块");
    }
}

public class InitiativeUse3 {
    public static void main(String[] args) {
        System.out.println(Son1.strFather);
    }
}
