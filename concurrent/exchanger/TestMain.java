package com.zdb.test.secondProject.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class TestMain {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new LuFeiRunnable(exchanger)).start();
        new Thread(new ShanZhiRunnable(exchanger)).start();
    }
}
