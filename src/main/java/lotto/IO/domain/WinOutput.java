package lotto.IO.domain;

import lotto.IO.output.OutputService;

import java.util.Arrays;
import java.util.List;

public class WinOutput {

    private final List<Integer> winPrice;
    private final List<Integer> correctCounts;

    public WinOutput(List<Integer> correctCounts) {
        this.winPrice = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000);
        this.correctCounts = correctCounts;
    }


    public List<Integer> getWinPrice() {
        return winPrice;
    }


}
