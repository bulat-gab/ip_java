package com.company.proxySample;

import com.company.proxySample.model.RusTax;
import com.company.proxySample.model.TaxCalculator;
import com.company.proxySample.model.USATax;
import com.company.proxySample.utils.TaxInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        double summ = random.nextDouble() * 200000;
        //RusTax rusTax = new RusTax();
        TaxCalculator proxyCalculator =
                (TaxCalculator) Proxy.newProxyInstance(
                        TaxCalculator.class.getClassLoader(),
                        new Class[]{TaxCalculator.class},
                        new TaxInvocationHandler(new RusTax())
                );

        USATax usaTax = new USATax();
        while (true) {
            if (summ < 100000) {
                System.out.println("Rus tax = " + proxyCalculator.getTax(summ));
            } else {
                System.out.println("USA tax = " + usaTax.getTax(summ));
            }
            summ = random.nextDouble() * 200000;
        }
    }
}
