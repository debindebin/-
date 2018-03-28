package com.zdb.test.secondProject.concurrent.CallableAndFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhangdebin on 2018/1/29.
 * FutureTask 的参数是 Runnable 和 固定返回值，
 * 只能返回固定值。
 */
public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");
        FutureTask task = new FutureTask(new Runnable() {
            @Override
            public void run() {
                    int i=1/0;
                    System.out.println("执行子任务");
                }
        },"hello");
        new Thread(task).start();
        while (task.isDone());
        System.out.println("任务返回结果:" + task.get());
        System.out.println("main end");
    }
}
