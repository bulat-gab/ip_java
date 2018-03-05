package com.company.proxySample.model;

public class USATax implements TaxCalculator {
    @Override
    public double getTax(double summ) {
        return summ * 0.2;
    }
}
