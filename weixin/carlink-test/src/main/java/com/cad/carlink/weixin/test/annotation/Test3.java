package com.cad.carlink.weixin.test.annotation;

/**
 * 解析注解
 */
public class Test3 {
    public static void main(String[] args) {
        try{
            //1.使用类加载器加载类
            Class c=Class.forName("com.cad.carlink.weixin.test.annotation.Test2");
            //2.判断类上面是否有注解
            boolean isExist=c.isAnnotationPresent(MyAnnotation.class);
            if(isExist){
                //3.拿到注解
                MyAnnotation myAnnotation=(MyAnnotation)c.getAnnotation(MyAnnotation.class);
                System.out.println("author:"+myAnnotation.author());
                System.out.println("age:"+myAnnotation.age());
                System.out.println("Literature:"+myAnnotation.literatureType().GetDesc());
                System.out.println("nullable:"+myAnnotation.nullable());
                System.out.println("myAnnotationOneMember:"+myAnnotation.myAnnotationOneMember().desc());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
