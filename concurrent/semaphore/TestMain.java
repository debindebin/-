package com.zdb.test.secondProject.concurrent.semaphore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangdebin on 2018/1/23.
 */
public class TestMain {

    public static void main(String[] args) {
        Set<Thread> customes = new HashSet<>();
        ShowerRoom showerRoom = new ShowerRoom();
        for (int i = 0; i < 10; i ++){
            customes.add(new Thread(new custome(showerRoom), "小明" + i + "号"));
        }
        for (Thread thread : customes){
            thread.start();
        }
    }
}
