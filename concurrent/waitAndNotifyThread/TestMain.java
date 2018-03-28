package com.zdb.test.secondProject.concurrent.waitAndNotifyThread;

import com.zdb.test.secondProject.concurrent.waitAndNotifyThread.threads.Customer;
import com.zdb.test.secondProject.concurrent.waitAndNotifyThread.threads.FishMan;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangdebin on 2018/1/17.
 */
public class TestMain {

    public static void main(String[] args) {
        Boat boat = new Boat();
        Thread fishMan = new Thread(new FishMan(boat));
        Set<Thread> customerThreads = new HashSet<Thread>();
        for (int i = 0; i < 60; i ++){
            customerThreads.add(new Thread(new Customer(boat,"顾客"+i+"号")));
        }

        fishMan.start();
        for (Thread customer : customerThreads){
            customer.start();
        }

    }




}
