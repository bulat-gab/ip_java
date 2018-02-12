package com.company.workSample.model;

import com.company.workSample.utils.SilenceTimeout;

public class ChernimirdinQuoter implements Quoter {
    @Override
    @SilenceTimeout(timeout = 5000)
    public void sayQuote() {
        System.out.println("Никогда такого не было и вот опять!");
    }
}
