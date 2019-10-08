package com.cad.carlink.weixin.test.myThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 张老板找工人挖矿挣钱，引用传递
 */
public class Mining {
    private static final int THREAD_COUNT=5;

    public static void main(String[] args) {
        Boss boss=new Boss();
        boss.setMoney(10);
        boss.setWorkerName("张三丰");

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch doneSignal = new CountDownLatch(5);


            for ( int i = 0; i <5 ; i++) {
                executorService.execute(() -> {
                  doMining(boss);
                } );
            }


        try {
            //等待张三丰的工人们挖矿完成
            doneSignal.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("多线程处理异常"+e);
        }

        System.out.println(String.format("老板姓名：%s,今天收益:%s",boss.getWorkerName(),boss.getMoney()));
    }


    public static void doMining(Boss boss){
        try {
            Worker worker=new Worker();
            worker.setWorkerName("worker");
            int goldCoins=(int)(1+Math.random()*10);//每次增加1-10以内的随机数
            System.out.println(String.format("%s发现金币：%s",worker.getWorkerName(),goldCoins));
            Thread.sleep(goldCoins*100);
            System.out.println(String.format("%s挖完金币：%s",worker.getWorkerName(),goldCoins));
            boss.setMoney(boss.getMoney()+goldCoins);
        }catch (Exception ex){
            System.out.println("error--->"+ex);
        }
    }
}
