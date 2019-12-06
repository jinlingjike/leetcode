package com.gapon.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {

        Class<User> clazz = User.class;

        //根据构造参数类型获得指定的Constructor对象(包括非公有构造方法)
        Constructor<User> constructor = clazz.getDeclaredConstructor(String.class);

        System.out.println("获得带String参数的Constructor:"+constructor);

        //获得指定字段名的Field对象(包括非公有字段)
        Field name = clazz.getDeclaredField("name");

        System.out.println("获得字段名为name的Field:"+name);

        //根据方法名和方法参数类型获得指定的Method对象(包括非公有方法)
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println("获得带String类型参数且方法名为setName的Method:"+method);


        //获得类上指定的注解
        MyAnnotation myAnnotation = clazz.getAnnotation(MyAnnotation.class);

        System.out.println("获得类上MyAnnotation类型的注解:"+myAnnotation);

        //获得类的所有实现接口
        Class<?>[] interfaces = clazz.getInterfaces();

        System.out.println("获得类实现的所有接口："+interfaces);

        //获得包对象
        Package apackage = clazz.getPackage();
        System.out.println("获得类所在的包:"+apackage);

    }

    @MyAnnotation
    public static class User implements Iuser{

        private String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    static @interface MyAnnotation{

    }

    static interface Iuser {

    }
}
