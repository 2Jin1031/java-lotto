package lotto.IO.domain;

public class LottoRate {

    private final double rate;

    public LottoRate(double price, double benefit) {
        this.rate = (benefit / price) * 100;
    }

    public double getRate() {
        return rate;
    }
}
