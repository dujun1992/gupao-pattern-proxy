package com.gupao.myproxy;

import java.lang.reflect.Method;

/**
 * Created by DJ on 2019年07月23日 19:59
 **/
public class ProductServiceMyProxy implements MyInvocationHandler {
    private Object target;

    public Object getInstance(Object object){
        this.target = object;
        Class<?> clazz = target.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj =  method.invoke(this.target,args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("MyProxy 前置处理");
    }

    private void after(){
        System.out.println("MyProxy 后置处理");
    }
}
