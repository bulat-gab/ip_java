package com.company.proxySample.utils;

import com.company.proxySample.model.TaxCalculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TaxInvocationHandler implements InvocationHandler {
    private TaxCalculator taxCalculator;

    public TaxInvocationHandler(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public Object invoke(Object proxy,
                         Method method,
                         Object[] args) throws Throwable {
        Object result = null;
        long startTime = System.currentTimeMillis();

        result = method.invoke(taxCalculator, args);

        System.out.println(method.getName()
                            + " costs "
                            + (System.currentTimeMillis() - startTime));
        return result;
    }
}
