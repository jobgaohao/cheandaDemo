package com.cad.carlink.weixin.controller;

import com.cad.carlink.common.support.redis.RedisCacheUtil;
import com.cad.carlink.weixin.dao.DemoUserPOMapper;
import com.cad.carlink.weixin.model.po.DemoUserPO;
import com.cad.carlink.weixin.service.IWeiXinAccSetService;
import com.cad.carlink.weixin.test.myStream.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class DemoUserController {

    private static final String REDIS_KEY="listTest";

    @Autowired
    private DemoUserPOMapper demoUserPOMapper;

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DemoUserPO getUser(@PathVariable ("id") Integer id) {
        return demoUserPOMapper.selectByPrimaryKey(String.valueOf(id));
    }

    @RequestMapping(value = "/getRedisList", method = RequestMethod.GET)
    @ResponseBody
    public void  testRedis(){
        //rightPush();
        leftPop();
    }


    /**
     * 左边出
     */
    public static  void leftPop(){
        try{
            for (int i = 0; i <10 ; i++){
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
