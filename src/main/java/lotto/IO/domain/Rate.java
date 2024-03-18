package lotto.IO.domain;

public class Rate {

    private final double rate;

    public Rate(int price, int beneift) {
        this.rate = ((double) (beneift / price) * 100);
    }

    public double getRate() {
        return rate;
    }
}
