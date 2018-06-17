package com.company.workSample.model;

import com.company.workSample.utils.SilenceTimeout;

public class MedvedQuoter implements Quoter {
    @Override
    @SilenceTimeout(timeout = 500)
    public void sayQuote() {
        System.out.println("Deneg net, no vi derjites!!!");
    }
}
