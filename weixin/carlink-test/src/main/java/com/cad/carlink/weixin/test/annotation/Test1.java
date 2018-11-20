package com.cad.carlink.weixin.test.annotation;

import java.lang.reflect.Method;

@SuppressWarnings("all")
public class Test1 {

    public static void main(String[] args) {
       //jdk 提供的注解
       Children children=new Children();
       children.sayHi();
       children.sayHello();//@Deprecated

       //验证注解的继承性（子类会覆盖父类的注解）
       testAnnotationInherited();
    }

    /**
     * 验证注解的继承性
     */
    public static void testAnnotationInherited(){
        try {
            //使用类加载器加载类
            Class<?> c=Class.forName("com.cad.carlink.weixin.test.annotation.Children");
            //判断类是否有注解
            boolean isExist=c.isAnnotationPresent(MyAnnotationOneMember.class);
            if(isExist){
                //获取类的注解
                MyAnnotationOneMember myAnnotationOneMember=c.getAnnotation(MyAnnotationOneMember.class);
                System.out.println("Class desc:"+myAnnotationOneMember.desc());
            }

            //遍历方法获取方法的注解
            Method[] methods=c.getMethods();
            for(Method method:methods){
                boolean methodIsExit=method.isAnnotationPresent(MyAnnotationOneMember.class);
                if(methodIsExit){
                    MyAnnotationOneMember myAnnotationOneMember=(MyAnnotationOneMember) method.getAnnotation(MyAnnotationOneMember.class);
                    System.out.println("Method desc:"+myAnnotationOneMember.desc());
                }
            }
        }catch (Exception ex){
           ex.printStackTrace();
        }
    }
}
