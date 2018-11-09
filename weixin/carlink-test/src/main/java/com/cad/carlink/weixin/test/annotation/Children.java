package com.cad.carlink.weixin.test.annotation;

//@MyAnnotationOneMember(desc ="我是子类注解的元素：class")
public class Children extends Person {

    @Override
    public  void  sayHi(){
        System.out.println("Children sayHi");
    }

    @Deprecated
    public void sayHello(){
        System.out.println("hello");
    }

    @MyAnnotationOneMember(desc = "我是子类注解的元素：method")
    public String call(){
        return "";
    }
}
