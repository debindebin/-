package com.zdb.test.secondProject.concurrent.phaser3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * Created by zhangdebin on 2018/1/25.
 */
public class TestMain {

    public static void main(String[] args) {
        String name = "明刚红丽黑白";
        Phaser phaser = new SubPhaser(name.length());
        List<Thread> tourismThread = new ArrayList<>();
        for (char ch : name.toCharArray()){
            tourismThread.add(new Thread(new TourismRunnable(phaser), "小" + ch));
        }
        for (Thread thread : tourismThread){
            thread.start();
        }
//        int i=3;
//        switch (i){
//            case 0:System.out.println("--------------"+0);
//            case 1:System.out.println("--------------"+1);
//            case 2:System.out.println("--------------"+2);
//            case 3:System.out.println("--------------"+3);
//            case 4:System.out.println("--------------"+4);
//            case 5:System.out.println("--------------"+5);
//        }
    }
    public static class SubPhaser extends Phaser{
        public SubPhaser(int parties) {
            super(parties);
        }

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {

            System.out.println(Thread.currentThread().getName() + ":全部"+getArrivedParties()+"个人都到齐了,现在是第"+(phase + 1)
                    +"次集合准备去下一个地方.................."+"------"+phase);
            return super.onAdvance(phase, registeredParties);
        }
    }
}
