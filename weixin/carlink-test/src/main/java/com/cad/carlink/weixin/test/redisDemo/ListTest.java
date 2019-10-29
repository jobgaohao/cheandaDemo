package com.cad.carlink.weixin.test.redisDemo;

import com.cad.carlink.common.support.redis.RedisCacheUtil;
import com.cad.carlink.weixin.test.myStream.PersonModel;

public class ListTest {
    private static final String REDIS_KEY="listTest";

    public static void main(String[] args) {
        rightPush();
        leftPop();
    }


    public static  void leftPop(){
        try{
            while (true){
                PersonModel personModel= (PersonModel)RedisCacheUtil.leftPopList(REDIS_KEY);
                System.out.println("结果:"+personModel.toString());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    /**
     * 右边进
     */
    public  static  void rightPush(){
        try{
            for (int i = 0; i <10 ; i++) {
                PersonModel personModel=new PersonModel("张三"+i,i,"男");
                RedisCacheUtil.rightPushListValue(REDIS_KEY, personModel);
            }
        }catch (Exception ex){
          ex.printStackTrace();
        }
    }
}
