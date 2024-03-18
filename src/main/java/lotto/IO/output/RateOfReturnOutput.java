package lotto.IO.output;

public class RateOfReturnOutput {

    private final double rate;

    public RateOfReturnOutput(double rate) {
        this.rate = Math.round(rate);
    }

    public void Print() {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
