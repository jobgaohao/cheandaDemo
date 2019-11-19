package com.cad.carlink.weixin.test.AOP.StaticProxy;

public class Student implements Person {

    private String name;
    public Student(String name){
        this.name=name;
    }


    @Override
    public void giveTask() {
        System.out.println(name+"交语文作业。");
    }
}
