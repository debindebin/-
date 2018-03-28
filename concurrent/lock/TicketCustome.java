package com.zdb.test.secondProject.concurrent.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 * Created by zhangdebin on 2018/1/18.
 */
public class TicketCustome implements  Runnable{
    private TicketRoom room;
    private Random random;
    private Lock lock;
    public TicketCustome(TicketRoom room, Lock lock) {
        this.room = room;
        this.lock = lock;
        random = new Random();
    }

//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i ++) {
//            lock.lock();
//            try {
//                int count = random.nextInt(10) + 1;
//                boolean success = room.buyTicket(count);
//                System.out.println(String.format("%s打算买%d张票,买票%s了,还剩下%d张票,总共卖掉%d张票, 总票数%d",
//                        Thread.currentThread().getName(), count, success ? "成功" : "失败",
//                        room.getCount(), room.getBuyedCount(), room.getAllCount()));
//                if (!success) {
//                    break;
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


    @Override
    public void run() {
        for (int i = 0; i < 5; ) {

            if(lock.tryLock()){
                try {
                    int count = random.nextInt(10) + 1;
                    boolean success = room.buyTicket(count);
                    System.out.println(String.format("%s打算买%d张票,买票%s了,还剩下%d张票,总共卖掉%d张票, 总票数%d",
                            Thread.currentThread().getName(), count, success ? "成功" : "失败",
                            room.getCount(), room.getBuyedCount(), room.getAllCount()));
                    if (!success) {
                        break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                    i++;
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " 买票系统被占用,尝试获取锁失败.");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
