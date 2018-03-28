package com.zdb.test.secondProject.concurrent.ThreadPoolExecutor;

/**
 * Created by zhangdebin on 2018/1/29.
 */
public class Demo3 {

    public  static  void main(String[] args) {
        try{
            System.out.println(testUtil.print());
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

                try{
                    System.out.println(testUtil.print());
                }catch (Exception e){
                    e.printStackTrace();
                }
    }
}
