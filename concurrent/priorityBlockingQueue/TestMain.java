package com.zdb.test.secondProject.concurrent.priorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {

        PriorityBlockingQueue<Human> queue = new PriorityBlockingQueue<>(200, new HumanComparator());
        Thread thread = new Thread(new ProducerRunnable(queue));
        thread.start();
        thread.join();
        new Thread(new ConsumerRunnable(queue)).start();
    }
}
