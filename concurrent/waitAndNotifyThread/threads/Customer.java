package com.zdb.test.secondProject.concurrent.waitAndNotifyThread.threads;

import com.zdb.test.secondProject.concurrent.waitAndNotifyThread.Boat;

/**
 * Created by zhangdebin on 2018/1/17.
 */
public class Customer implements  Runnable {

    private Boat boat;
    private String name;
    public Customer(Boat boat, String name) {
        this.boat = boat;
        this.name = name;
    }

    @Override
    public void run() {
        boat.soldFish(name);
    }
}
