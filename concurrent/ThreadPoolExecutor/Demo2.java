package com.zdb.test.secondProject.concurrent.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * Created by zhangdebin on 2018/1/29.
 *
 * ThreadPoolExecutor,我们在执行任务的时候使用了execute,这个是没有返回值的.而且如果任务抛出异常,则会直接在主线程打印出错误堆栈的.
 * 其实ThreadPoolExecutor还有另外一个提交任务的方法,就是submit(Runnable task, T result)和submit(Callable<T> task)
 */
public class Demo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");
        BlockingQueue<Runnable> queue =new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor   poolExecutor =new ThreadPoolExecutor(3,5,0,TimeUnit.SECONDS,queue,handler);

        Future<Integer> future= poolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 100; i++){
                    sum += i;
                }
                return sum;
            }
        });
        System.out.println("任务返回结果:" + future.get());
        System.out.println("main end");
    }
}
