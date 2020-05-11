package com.cad.carlink.weixin.test.AOP.Proxy;

import com.cad.carlink.weixin.test.AOP.StaticProxy.Person;
import com.cad.carlink.weixin.test.AOP.StaticProxy.Student;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 * 代理可以让调用者和实现者之间解耦
 */
public class ProxyTest {
    public static void main(String[] args) {
        //创建一个实例对象，这个对象是被代理的对象
        Person zhangsan=new Student("张三");
        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler=new StuInvocationHandler<Person>(zhangsan);
        //创建一个代理对象stuProxy 来代理张三
        Class<?>[] interfaces=new Class<?>[]{Person.class};
        Person monitor = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), interfaces, stuHandler);
        //代理执行提交作业的方法
        monitor.giveTask();

        saveProxyTempFile("$PersonProxy",interfaces);
    }


    /**
     * 动态代理类保存成文件
     * @param proxyName
     * @param interfaces
     */
    public static void saveProxyTempFile(String proxyName ,Class<?>[] interfaces){
        try {
            String path="G:/"+proxyName+".class";
            byte[] bts = ProxyGenerator.generateProxyClass(proxyName, interfaces);
            FileOutputStream fos = new FileOutputStream(new File(path));
            fos.write(bts);
            fos.flush();
            fos.close();
            System.out.println("动态代理类文件生成成功："+path);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
