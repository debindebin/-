package com.zdb.test.secondProject.concurrent.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhangdebin on 2018/1/29.
 */
public class Demo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("start 正在执行子任务");
                Thread.sleep(500);
                System.out.println("end 执行子任务");
                return 0;
            }
        });
        new Thread(task).start();
        Thread.sleep(250);
        task.cancel(false);
        System.out.println("main end");


    }
}
