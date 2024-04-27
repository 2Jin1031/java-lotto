package lotto.IO.inputOutput;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.IntStream;

public class OutputService {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    public static void printPurchaseInfo(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottos(List<List<Integer>> numbers) {
        for (List<Integer> lotto : numbers) {
            System.out.print("[");
            IntStream.range(0, lotto.size()).forEach(i -> {
                System.out.print(lotto.get(i));
                if (i != (lotto.size() - 1)) {
                    System.out.print(", ");
                }
            });
            System.out.println("]");
        }
    }

    public static void printRateOfReturn(double rate) {
        String rateFormatted = String.format("%.1f", rate);
        System.out.println("총 수익률은 " + rateFormatted + "%입니다.");
    }

    public static void printWinStatistics(List<Integer> correctCounts, List<Integer> winPrices) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + numberFormat.format(winPrices.get(i)) + "원) - " + correctCounts.get(i) + "개");
        }
        System.out.println("5개 일치, 보너스 볼 일치 (" + numberFormat.format(winPrices.get(6)) + "원) - " + correctCounts.get(7) + "개");
        System.out.println("6개 일치 (" + numberFormat.format(winPrices.get(7)) + "원) - " + correctCounts.get(6) + "개");
    }
}
