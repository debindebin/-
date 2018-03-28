package com.zdb.test.secondProject.concurrent.waitAndNotifyThread;

import java.util.Random;

/**
 * Created by zhangdebin on 2018/1/4.
 */
public class Boat {

    private int fishCount=0;


    public synchronized  void catchFish(){
        // 如果有鱼，就等待
        while (this.fishCount >0){
            try {
                System.out.println("店长来看了看，还有鱼，没做什么。");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 捕鱼时间
        try {
            Random r=new Random();
            int t= r.nextInt(5);
            Thread.sleep(t);
            System.out.println("店长来看了看，发现没有鱼了，开始捕鱼。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random r=new Random();
        int c= r.nextInt(40)+2;
        System.out.println("呦呵，捕到了"+c+"条鱼，店里又有鱼了。");
        this.fishCount =this.fishCount+ c;

        this.notifyAll();
        try {
            System.out.println("店长去歇着了。");
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  synchronized  void soldFish(String  buyerName){

        while (this.fishCount <=0){
            try {
                if("顾客24号".equals(buyerName)){
                    System.out.println("顾客"+buyerName+"来买鱼，没有鱼了，等等吧。");
                }
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Random r=new Random();
        int c= r.nextInt(10)+1;
        int buyCount=c<this.fishCount?c:this.fishCount;
        if("顾客24号".equals(buyerName)){
            System.out.println("顾客"+buyerName+"来买鱼，买走了"+buyCount+"条鱼。");
        }
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.fishCount = this.fishCount- buyCount;
        System.out.println("----------------还有"+this.fishCount+"条鱼。");
        this.notifyAll();

    }

}
