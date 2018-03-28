package com.zdb.test.secondProject.concurrent.arrayBlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class ShanZhiRunnable implements  Runnable{

    ArrayBlockingQueue<String> queue;
    Random random = new Random();
    public ShanZhiRunnable(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                String food = Food.getRandomFood();
                System.out.println("==>山治开始做 " + food);
                Thread.sleep(random.nextInt(500));
                System.out.println("==>山治做好了 " + food);
                queue.put(food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
