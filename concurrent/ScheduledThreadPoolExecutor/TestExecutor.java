package com.zdb.test.secondProject.concurrent.ScheduledThreadPoolExecutor;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangdebin on 2017/12/28.
 */
public class TestExecutor {

    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

    public static void main(String[] args) {
//        testFixedRate();

        testFixedDelay();

    }

    /**
     *  进行scheduleAtFixedRate测试
     */
    public static void testFixedRate(){
        executor.scheduleAtFixedRate(new myRun(), 5, 5, TimeUnit.SECONDS);
    }

    public static void testFixedDelay(){
        executor.scheduleWithFixedDelay(new myRun(), 5, 5, TimeUnit.SECONDS);
    }


    static class myRun implements Runnable{

        int sleepCount=3;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+ "----测试开始--------"+ new Date().toString());
            try {
                Thread.sleep(sleepCount*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "---休眠"+sleepCount+"秒后, 处理结束--------"+new Date().toString());
        }
    }

}
