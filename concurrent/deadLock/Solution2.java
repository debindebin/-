package com.zdb.test.secondProject.concurrent.deadLock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class Solution2 {

    public static void main(String[] args) {
        final Lock bigGate = new ReentrantLock();
        final Lock smallGate = new ReentrantLock();
        final Random random = new Random();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                bigGate.lock();
                try {
                    System.out.println(name + ":我把大门给锁了...然后我休息一下...");
                    Thread.sleep(100);
                    System.out.println(name + ":我现在要进入小门.....");
                    if(smallGate.tryLock(random.nextInt(500), TimeUnit.MILLISECONDS)){
                        try {
                            System.out.println(name + ":我终于进来了.....");
                        }finally {
                            smallGate.unlock();
                        }
                    }else{
                        System.out.println(name + ":我进不去小门,算了,不进了...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    bigGate.unlock();
                }
            }
        },"小明").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                smallGate.lock();
                try {
                    System.out.println(name + ":我把小门给锁了...然后我休息一下...");
                    Thread.sleep(100);
                    System.out.println(name + ":我现在要进入大门.....");
                    if(bigGate.tryLock(random.nextInt(500), TimeUnit.MILLISECONDS)){
                        try {
                            System.out.println(name + ":我终于进来了.....");
                        }finally {
                            bigGate.unlock();
                        }
                    }else{
                        System.out.println(name + ":我进不去大门,算了,不进了...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    smallGate.unlock();
                }
            }
        },"小红").start();
    }
}
