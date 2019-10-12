package com.cad.carlink.weixin.test.OOP;

public abstract class Animal implements Behaved {
    @Override
    public void eat() {
        if(this instanceof Cat ){
            System.out.println("猫吃鱼");
        }else if(this instanceof  Dog){
            System.out.println("狗吃骨头");
        }
    }
}
