package com.zdb.test.secondProject.concurrent.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class ShanZhiRunnable implements Runnable{

    Exchanger<String> exchanger;
    Random random = new Random();
    public ShanZhiRunnable(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true){
            try {
                String food = Food.getRandomFood();
                System.out.println("==>山治开始做 " + food);
                Thread.sleep(random.nextInt(500));
                System.out.println("==>山治把 " + food + " 给做好了,给路飞送过去");
                String exchange = exchanger.exchange(food);
                System.out.println("==>山治收到路飞的评语:" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
