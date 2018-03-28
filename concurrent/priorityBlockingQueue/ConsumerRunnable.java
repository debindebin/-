package com.zdb.test.secondProject.concurrent.priorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class ConsumerRunnable implements Runnable{

    private PriorityBlockingQueue<Human> queue;
    public ConsumerRunnable(PriorityBlockingQueue<Human> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            Human take = queue.poll();
            if (take == null){
                break;
            }
            System.out.println(take + " 办理业务.");
        }
    }
}
