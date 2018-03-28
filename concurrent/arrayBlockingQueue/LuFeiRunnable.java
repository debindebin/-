package com.zdb.test.secondProject.concurrent.arrayBlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class LuFeiRunnable implements Runnable{

    ArrayBlockingQueue<String> queue;
    Random random = new Random();
    public LuFeiRunnable(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){
            try {
                String take = queue.take();
                System.out.println("-->路飞拿到 " + take);
                Thread.sleep(random.nextInt(500));
                System.out.println("-->路飞吃完 " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
