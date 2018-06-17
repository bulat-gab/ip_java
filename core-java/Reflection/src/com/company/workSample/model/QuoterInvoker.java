package com.company.workSample.model;

import com.company.workSample.utils.SilenceTimeout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QuoterInvoker {
    public static void sayQuote(Quoter quoter){
        try {
            Method method
                    = quoter.getClass().getMethod("sayQuote");
            SilenceTimeout silenceTimeout =
                    method.getAnnotation(SilenceTimeout.class);
            if(silenceTimeout != null){
                try {
                    Thread.sleep(silenceTimeout.timeout());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            method.invoke(quoter);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
