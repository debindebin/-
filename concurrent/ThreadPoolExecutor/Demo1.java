package com.zdb.test.secondProject.concurrent.ThreadPoolExecutor;


import java.util.concurrent.*;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class Demo1 {

    public  static void  main(String[] args){

        BlockingQueue<Runnable> queue =new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        RejectedExecutionHandler handler1= new ThreadPoolExecutor.DiscardPolicy();
        RejectedExecutionHandler handler2= new ThreadPoolExecutor.DiscardOldestPolicy();
        RejectedExecutionHandler handler3= new ThreadPoolExecutor.CallerRunsPolicy();
        RejectedExecutionHandler handler4 = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                if (!executor.isShutdown()){
                    try {
                        executor.getQueue().put(r);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ThreadPoolExecutor poolExecutor =new ThreadPoolExecutor(3,3,0, TimeUnit.SECONDS,queue,handler4);

        for(int i=0;i<20;i++){
            final int temp =i;
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"客户" + temp + "来了.......");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
