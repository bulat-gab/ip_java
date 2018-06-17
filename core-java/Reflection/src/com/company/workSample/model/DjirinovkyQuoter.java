package com.company.workSample.model;

import com.company.workSample.utils.SilenceTimeout;

public class DjirinovkyQuoter implements Quoter {
    @Override
    @SilenceTimeout(timeout = 1000)
    public void sayQuote() {
        System.out.println("Podonki!!!!");
    }
}
