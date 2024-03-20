package lotto.IO.domain;

public class Rate {

    private final double rate;

    public Rate(double price, double benefit) {
        this.rate = (benefit / price) * 100;
    }

    public double getRate() {
        return rate;
    }
}
