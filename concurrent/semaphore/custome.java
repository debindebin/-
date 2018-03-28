package com.zdb.test.secondProject.concurrent.semaphore;

/**
 * Created by zhangdebin on 2018/1/23.
 */
public class custome implements  Runnable{

    ShowerRoom showerRoom;
    public custome(ShowerRoom showerRoom) {
        this.showerRoom = showerRoom;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        showerRoom.bathe(name);
    }
}
