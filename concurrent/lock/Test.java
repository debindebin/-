package com.zdb.test.secondProject.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangdebin on 2018/1/18.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        TicketRoom ticket = new TicketRoom();
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 20; i ++){
            threads.add(new Thread(new TicketCustome(ticket, lock)));
        }
        for (Thread thread : threads){
            thread.start();
        }
    }
}
