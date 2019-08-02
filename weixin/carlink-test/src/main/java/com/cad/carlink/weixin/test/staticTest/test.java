package com.cad.carlink.weixin.test.staticTest;

import com.cad.carlink.common.support.redis.RedisCacheUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        for (String student: Student.students) {
            System.out.println("第一次："+student);
        }

        for (String student: Student.students) {
            System.out.println("第二次："+student);
        }


        List<Integer> l1=new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2=new ArrayList<>();
        l2.add(1);
        l2.add(5);
        l2.add(6);

       Map<Integer,List<Integer>> map=new HashMap<>();
        map.put(1,l1);
        map.put(2,l2);

        if(map.containsKey(1)){
            boolean con=map.get(1).contains(1);
            boolean con1=map.get(1).contains(2);
            boolean con2=map.get(1).contains(7);
            System.out.println(con);
            System.out.println(con1);
            System.out.println(con2);
        }
    }
}
