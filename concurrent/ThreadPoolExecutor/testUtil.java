package com.zdb.test.secondProject.concurrent.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * Created by zhangdebin on 2018/1/29.
 */
public class testUtil {

    static ThreadPoolExecutor   poolExecutor  =new ThreadPoolExecutor(3,5,0, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10),new ThreadPoolExecutor.AbortPolicy());

    public static   String print() throws  Exception{
        Future<String> future= poolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(poolExecutor+"-----------I really missing you,I really want come to see you.");
                return poolExecutor.toString();
            }
        });
        return  future.get();
    }
}
