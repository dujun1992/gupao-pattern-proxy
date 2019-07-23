package com.gupao.myproxy;

import java.lang.reflect.Method;

/**
 * Created by DJ on 2019年07月23日 20:52
 **/
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
