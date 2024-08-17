package com.AdapterPattern;

interface GBRPayment {
    public double getInPounds();
    public double getExchangeRate();
}

class GBPAmount implements GBRPayment {
    double pounds;
    double exchangeRate;

    public GBPAmount(double pounds, double exchangeRate) {
        this.pounds = pounds;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public double getInPounds() {
        return this.pounds;
    }

    @Override
    public double getExchangeRate() {
        return this.exchangeRate;
    }

}

interface INR {
    public double getInRupees();
}


class GBPToINRAdapter implements INR {
    GBPAmount gbpAmount;

    public GBPToINRAdapter(GBPAmount gbpAmount) {
        this.gbpAmount = gbpAmount;
    }

    @Override
    public double getInRupees() {
        double gbp = gbpAmount.getInPounds();
        double exchangeRate = gbpAmount.getExchangeRate();
        gbp=gbp*exchangeRate;
        return gbp;
    }
}
public class AdapterPattern {
    public static void main(String[] args) {
        GBPAmount gbpAmount = new GBPAmount(300,95);
        INR inr = new GBPToINRAdapter(gbpAmount);
        double INR=inr.getInRupees();
        System.out.println(INR);
    }
}
