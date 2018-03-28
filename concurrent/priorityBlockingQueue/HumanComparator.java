package com.zdb.test.secondProject.concurrent.priorityBlockingQueue;

import java.util.Comparator;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class HumanComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o2.getManey() - o1.getManey();
    }

}
