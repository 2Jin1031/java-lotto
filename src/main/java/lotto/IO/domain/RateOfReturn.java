package lotto.IO.domain;

public class RateOfReturn {

    private final double rateOfReturn;

    public RateOfReturn(double price, double benefit) {
        this.rateOfReturn = (benefit / price) * 100;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
