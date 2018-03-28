package com.zdb.test.secondProject.concurrent.waitAndNotifyThread.threads;

import com.zdb.test.secondProject.concurrent.waitAndNotifyThread.Boat;

/**
 * Created by zhangdebin on 2018/1/17.
 */
public class FishMan implements Runnable {

    private Boat boat;
    public FishMan(Boat boat) {
        this.boat = boat;
    }

    @Override
    public void run() {
        while (true){
            boat.catchFish();
        }
    }

}
