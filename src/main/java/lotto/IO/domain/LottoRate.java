package lotto.IO.domain;

public class LottoRate {

    private final double rate;

    public LottoRate(double price, double benefit) {
        this.rate = calculateRate(price, benefit);
    }

    private static double calculateRate(double price, double benefit) {
        return (benefit / price) * 100;
    }

    public double getRate() {
        return rate;
    }
}
