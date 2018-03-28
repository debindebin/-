package com.zdb.test.secondProject.concurrent.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhangdebin on 2018/1/29.
 */
public class Demo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 100; i++){
                    sum += i;
                }
                return sum;
            }
        });
        new Thread(task).start();
        while (task.isDone());
        System.out.println("任务返回结果:" + task.get());
        System.out.println("main end");
    }
}
