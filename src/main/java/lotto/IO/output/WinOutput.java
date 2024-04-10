package lotto.IO.output;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinOutput {

    private final List<Integer> winPrice;
    private final List<Integer> correctCounts;

    NumberFormat numberFormat = NumberFormat.getInstance();

    public WinOutput(List<Integer> correctCounts) {
        this.winPrice = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000);
        this.correctCounts = correctCounts;
    }

    public void print() {
        int i;
        for (i = 3; i < 6; i++) {
            System.out.println(i + "개 일치 (" + numberFormat.format(winPrice.get(i)) + "원) - " + correctCounts.get(i) + "개");
        }
        System.out.println(i - 1 + "개 일치, 보너스 볼 일치 (" + numberFormat.format(winPrice.get(6)) + "원) - " + correctCounts.get(7) + "개");
        System.out.println(i + "개 일치 (" + numberFormat.format(winPrice.get(7)) + "원) - " + correctCounts.get(6) + "개");
    }

    public List<Integer> getWinPrice() {
        return winPrice;
    }
}
