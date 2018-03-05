package com.company.workSample;

import com.company.workSample.model.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        while (true){
            switch (random.nextInt(4)){
                case 0:
                    QuoterInvoker.sayQuote(new NavalnyQuoter());
                    break;
                case 1:
                    QuoterInvoker.sayQuote(new DjirinovkyQuoter());
                    break;
                case 2:
                    QuoterInvoker.sayQuote(new MedvedQuoter());
                    break;
                default:
                    QuoterInvoker.sayQuote(new ChernimirdinQuoter());
                    break;
            }
        }
    }
}
