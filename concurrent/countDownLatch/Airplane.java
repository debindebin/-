package com.zdb.test.secondProject.concurrent.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangdebin on 2018/1/23.
 */
public class Airplane {

    private CountDownLatch countDownLatch;
    private Random random;
    public Airplane(int peopleNum){
        countDownLatch = new CountDownLatch(peopleNum);
        random = new Random();
    }

    /**
     * 下机
     */
    public void getOffPlane(){
        try {
            String name = Thread.currentThread().getName();
            Thread.sleep(random.nextInt(500));
            System.out.println(name + " 在飞机在休息着....");
            Thread.sleep(random.nextInt(500));
            System.out.println(name + " 下飞机了");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork(){
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + "准备做 清理 工作");
            countDownLatch.await();
            System.out.println("飞机的乘客都下机," + name + "可以开始做 清理 工作");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
