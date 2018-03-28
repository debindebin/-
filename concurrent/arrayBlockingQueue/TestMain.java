package com.zdb.test.secondProject.concurrent.arrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class TestMain {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        new Thread(new LuFeiRunnable(queue)).start();
        new Thread(new ShanZhiRunnable(queue)).start();
    }
}
