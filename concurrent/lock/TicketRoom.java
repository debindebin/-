package com.zdb.test.secondProject.concurrent.lock;

/**
 * Created by zhangdebin on 2018/1/18.
 */
public class TicketRoom {
    private static final int DEFAULT_TICKET_COUNT = 1000;
    private int count = DEFAULT_TICKET_COUNT; //票的总数
    private int buyedCount = 0;
    private Object o = new Object();
    public  boolean buyTicket(int count) throws InterruptedException {

        if (this.count - count < 0){
            Thread.sleep(10);
            return false;
        }else{
            this.count = this.count - count;
            Thread.sleep(1);
            this.buyedCount = this.buyedCount + count;
            return true;
        }

    }

    public int getCount() {
        return count;
    }

    public int getBuyedCount() {
        return buyedCount;
    }

    public int getAllCount(){
        return count + buyedCount;
    }


}
