package com.cad.carlink.weixin.test.AOP.StaticProxy;

/**
 * 静态代理demo
 * 现在一个班上的学生需要交作业，现在由班长代理交作业，那么班长就是代理，学生就是被代理的对象
 *
 *
 * 这里并没有直接通过张三（被代理对象）来执行交作业的行为，而是通过班长（代理对象）来代理执行了。这就是代理模式。
 *代理模式就是在访问实际对象时引入一定程度的间接性，这里的间接性就是指不直接调用实际对象的方法，那么我们在代理过程中就可以加上一些其他用途。

 比如班长在帮张三交作业的时候想告诉老师最近张三的进步很大，就可以轻松的通过代理模式办到。在代理类的交作业之前加入方法即可。这个优点就可以运用在spring中的AOP，我们能在一个切点之前执行一些操作，在一个切点之后执行一些操作，这个切点就是一个个方法。
 这些方法所在类肯定就是被代理了，在代理过程中切入了一些其他操作。
 *
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //被代理的学生张三，他的作业上交由代理对象monitor完成
        Person zhangsan=new Student("张三");
        //生成代理对象，并将张三传给代理对象
        Person monitor=new StudentProxy(zhangsan);
        //班长代理交作业
        monitor.giveTask();
    }
}
