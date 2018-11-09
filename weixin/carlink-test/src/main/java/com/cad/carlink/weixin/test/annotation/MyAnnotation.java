package com.cad.carlink.weixin.test.annotation;

import java.io.IOException;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnnotation {
    //String desc(int num);//注解不能定义有参的方法
    //String desc() throws IOException;//注解不能以无参数有异常的方式声明
    ELiteratureType literatureType();//枚举
    String author();//
    boolean nullable();//boolean
    long[] enumeratel() default {};//数组
    int age() default 18;//可以用default为成员指定一个默认值
    Class<Person> style();//Class
    MyAnnotationOneMember myAnnotationOneMember();//注解
}
