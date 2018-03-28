package com.zdb.test.secondProject.concurrent.priorityBlockingQueue;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class Human {

    private int maney;
    private String name;
    public Human(int maney, String name){
        this.maney = maney;
        this.name = name;
    }

    public int getManey() {
        return maney;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + "[存款:"+getManey()+"]";
    }
}
