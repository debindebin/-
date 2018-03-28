package com.zdb.test.secondProject.concurrent.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhangdebin on 2018/1/29.
 * 工作线程报错时
 * runnable 会在主线程即时抛出异常。
 * callnable 只有在调用get()方法时，才会抛出异常。
 */
public class Demo3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("正在执行子任务");
                int i = 1 / 0;
                return 0;
            }
        });
        new Thread(task).start();
        while (task.isDone());
        System.out.println("任务返回结果:" + task.get());
        System.out.println("main end");
    }
}
