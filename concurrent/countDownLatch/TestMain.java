package com.zdb.test.secondProject.concurrent.countDownLatch;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangdebin on 2018/1/23.
 */
public class TestMain {

    public static void main(String[] args) {
        String visitor = "明刚红丽黑白";
        String kongjie = "美";

        final Airplane airplane = new Airplane(visitor.length());
        Set<Thread> threads = new HashSet<>();
        for (int i = 0; i < visitor.length(); i ++){
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    airplane.getOffPlane();
                }
            }, "小" + visitor.charAt(i)));
        }
        for (int i = 0; i < kongjie.length(); i ++){
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    airplane.doWork();
                }
            }, "小" + kongjie.charAt(i) + "空姐"));
        }

        for (Thread thread : threads){
            thread.start();
        }
    }
}
