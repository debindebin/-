package com.zdb.test.secondProject.concurrent.arrayBlockingQueue;

import java.util.Random;

/**
 * Created by zhangdebin on 2018/1/26.
 */
public class Food {

    public final static String[] food = {
            "打边炉","奶味芦笋汤","糟片鸭","烤花揽桂鱼","苦中作乐","七星丸","鸭黄豆腐","贝丝扒菜胆","脆炒南瓜丝","龙凤双腿"
    };

    private static Random random = new Random();
    public static String getRandomFood(){
        return food[random.nextInt(food.length)];
    }
}
