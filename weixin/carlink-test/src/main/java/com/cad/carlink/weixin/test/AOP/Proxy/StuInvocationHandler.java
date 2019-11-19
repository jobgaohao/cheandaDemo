package com.cad.carlink.weixin.test.AOP.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {

    //invocationHandler持有的被代理对象
    T target;
    public StuInvocationHandler(T target){
      this.target=target;
    }

    /**
     *
     * @param proxy 代理的对象
     * @param method 正在执行的方法
     * @param args 代表调用目标方法传入的实参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=method.invoke(target,args);
        return result;
    }
}
