package lotto.IO.output;

public class RateOfReturnOutput {

    private final String rate;

    public RateOfReturnOutput(double rate) {
        this.rate = String.format("%.1f", rate);
    }

    public void Print() {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
