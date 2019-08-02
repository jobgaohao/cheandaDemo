package com.cad.carlink.weixin.test.staticTest;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public static List<String> students = new ArrayList<>();

    static {
        initData();
        System.out.println("初始化....");
    }


    public static void initData(){
        students.add("张三");
        students.add("李四");
        students.add("王五");
    }

}
