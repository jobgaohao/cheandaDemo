package com.cad.carlink.weixin.test.annotation;

@MyAnnotationOneMember(desc = "我是父类注解的元素：class")
public class Person {

    @MyAnnotationOneMember(desc = "我是父类注解的元素：method")
    public  void  sayHi(){
        System.out.println("Person sayHi");
    }
}
