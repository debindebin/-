package com.zdb.test.secondProject.concurrent.arrayBlockingQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        final List<String> list = new ArrayList<>();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i ++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j < 100; j ++){
//                        synchronized (list){
                            list.add(Thread.currentThread().getName() + ":" + j);
//                        }
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        System.out.println(list.size());
    }
}
