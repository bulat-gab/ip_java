package com.company.workSample.model;

import com.company.workSample.utils.SilenceTimeout;

public class NavalnyQuoter implements Quoter {
    @Override
    @SilenceTimeout(timeout = 3000)
    public void sayQuote() {
        System.out.println("Pora vidirat");
    }
}
