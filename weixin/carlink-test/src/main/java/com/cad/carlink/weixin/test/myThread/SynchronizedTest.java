package com.cad.carlink.weixin.test.myThread;

public class SynchronizedTest implements Runnable {

    private int tick=30;

    @Override
    public void run() {
        while (true) {
            synchronized (this){
                if(tick<=0){
                    System.out.println(Thread.currentThread().getName()+" -->售票结束!");
                    break;
                }

                try {
                    Thread.sleep(1000*1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" -->售出第 "+tick+" 张票");
                tick--;
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest=new SynchronizedTest();
        new Thread(synchronizedTest,"1号售票窗口").start();
        new Thread(synchronizedTest,"2号售票窗口").start();
        new Thread(synchronizedTest,"3号售票窗口").start();
    }
}
