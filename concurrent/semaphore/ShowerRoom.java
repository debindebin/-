package com.zdb.test.secondProject.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by zhangdebin on 2018/1/23.
 */
public class ShowerRoom {

    private static final int MAX_SIZE = 3;
    Semaphore semaphore = new Semaphore(MAX_SIZE);

    public void bathe(String name){
        try {
            semaphore.acquire();
            System.out.println(name + " 洗唰唰啊..洗唰唰... ");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(name + " 终于洗完澡了...");
            semaphore.release();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
