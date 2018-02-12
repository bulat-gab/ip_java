package com.company.baseSample.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionInvoker {
    public static void invokeMethodWithOutArgs(Object container,
                                        Class containerClass,
                                        String methodName){
        try {
            Method method = containerClass.getDeclaredMethod(methodName);

            boolean isAccessible = method.isAccessible();
            if(!isAccessible)
                method.setAccessible(true);

            method.invoke(container, null);

            if(!isAccessible)
                method.setAccessible(false);
        } catch (NoSuchMethodException e) {
            if(containerClass.getSuperclass() != null){
                invokeMethodWithOutArgs(container,
                                        containerClass.getSuperclass(),
                                        methodName);
            } else {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
