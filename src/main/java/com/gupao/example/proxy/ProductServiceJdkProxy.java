package com.gupao.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by DJ on 2019年07月23日 19:59
 **/
public class ProductServiceJdkProxy  implements InvocationHandler {
    private Object target;

    public Object getInstance(Object object){
        this.target = object;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj =  method.invoke(this.target,args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("前置处理");
    }

    private void after(){
        System.out.println("后置处理");
    }
}
