package com.gapon.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: takumiCX
 * @create: 2018-08-01
 **/
public class NoFairLockTest {


    public static void main(String[] args) {

        //创建非公平锁
        ReentrantLock lock = new ReentrantLock(false);

        try {

            //加锁
            lock.lock();

            //模拟业务处理用时
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            //释放锁
            lock.unlock();
        }

    }
}