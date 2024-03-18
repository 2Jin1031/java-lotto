package lotto.IO.output;

import java.text.NumberFormat;
import java.util.ArrayList;

public class WinOutput {

    private final int[] WinPrice;
    private final int[] correctCounts;

    NumberFormat numberFormat = NumberFormat.getInstance();

    public WinOutput(int[] correctCounts) {
        this.WinPrice = new int[] {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000};
        this.correctCounts = correctCounts;
    }

    public void Print() {
        int i;
        for (i = 3; i < 6; i++) {
            System.out.println(i + "개 일치 (" + numberFormat.format(WinPrice[i]) + ") - " + correctCounts[i] + "개");
        }
        System.out.println(i + "개 일치, 보너스 볼 일치 (" + numberFormat.format(WinPrice[7]) + ") - " + correctCounts[6] + "개");
        System.out.println(i + "개 일치 (" + numberFormat.format(WinPrice[6]) + ") - " + correctCounts[7] + "개");
    }

    public int[] getWinPrice() {
        return WinPrice;
    }
}