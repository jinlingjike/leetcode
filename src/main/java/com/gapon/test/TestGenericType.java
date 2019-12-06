package com.gapon.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

abstract class GenericType<T> {

}

public class TestGenericType extends GenericType<String> {


    private Map<String, Integer> map;

    public Map<String,Integer> getMap(){
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {

        //获取Class对象
        Class<TestGenericType> clazz = TestGenericType.class;


        System.out.println("获取类的参数化类型信息:");
        //1.获取类的参数化类型信息
        Type type = clazz.getGenericSuperclass();//获取带泛型的父类类型
        if (type instanceof ParameterizedType) { //判断是否参数化类型
            Type[] types = ((ParameterizedType) type).getActualTypeArguments(); //获得参数的实际类型
            for (Type type1 : types) {
                System.out.println(type1);
            }

        }

        System.out.println("--------------------------");

        System.out.println("获取字段上的参数化类型信息:");

        //获取字段上的参数化类型信息
        Field field = clazz.getDeclaredField("map");
        Type type1 = field.getGenericType();
        Type[] types = ((ParameterizedType) type1).getActualTypeArguments();
        for(Type type2:types){
            System.out.println(type2);
        }

        System.out.println("--------------------------");

        System.out.println("获取方法参数的参数化类型信息:");
        //获取方法参数的参数化类型信息
        Method method = clazz.getDeclaredMethod("setMap",Map.class);
        Type[] types1 = method.getGenericParameterTypes();
        for(Type type2:types1){
            if(type2 instanceof ParameterizedType){
                Type[] typeArguments = ((ParameterizedType) type2).getActualTypeArguments();
                for(Type type3:typeArguments){
                    System.out.println(type3);
                }
            }
        }
        System.out.println("--------------------------");

        System.out.println("获取方法返回值的参数化类型信息:");
        //获取方法返回值得参数化类型信息
        Method method1 = clazz.getDeclaredMethod("getMap");

        Type returnType = method1.getGenericReturnType();

        if(returnType instanceof ParameterizedType){
            Type[] arguments = ((ParameterizedType) returnType).getActualTypeArguments();
            for(Type type2:arguments){
                System.out.println(type2);
            }
        }

    }
}
