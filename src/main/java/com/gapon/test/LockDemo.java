package com.gapon.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        Person2 person2 = new Person2();
        Condition condition = person2.lock.newCondition();
        Input2 input2 = new Input2(person2,condition);
        Output2 output2 = new Output2(person2,condition);
        input2.start();
        output2.start();
    }
}

// 写的线程
class Output2 extends Thread {
    private Person2 person;
    private Condition condition;
    public Output2(Person2 person, Condition condition) {
        this.person = person;
        this.condition = condition;
    }
    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                person.lock.lock();
                if (person.flag) {
                    try {
                        condition.await(); // 使线程休眠，作用等于synchronize中的thread.wait()方法
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    person.name = "小明";
                    person.gender = "男";
                } else {
                    person.name = "小红";
                    person.gender = "女";
                }
                count = (count + 1) % 2;
                person.flag = true;
                condition.signal();
            }catch (Exception e){
            }finally {
                person.lock.unlock(); // 必须手动关闭线程
            }
        }
    }
}

// 读的线程
class Input2 extends Thread {
    private Person2 person;
    private Condition condition; // 该接口的作用是精确控制锁的行为
    public Input2(Person2 person, Condition condition) {
        this.person = person;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true) {
            try {
                person.lock.lock();
                if (!person.flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(person.name + "," + person.gender);
                person.flag = false;
                condition.signal();//唤醒线程
            }catch (Exception e){

            }finally {
                person.lock.unlock();
            }
        }
    }
}

class Person2 {
    public String name;
    public String gender;
    public boolean flag = false; // 该属性是用来控制线程之间的通讯
    Lock lock = new ReentrantLock();
}