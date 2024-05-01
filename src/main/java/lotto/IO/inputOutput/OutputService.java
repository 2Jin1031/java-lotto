package lotto.IO.inputOutput;

import lotto.IO.domain.Rank;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public static void printWinStatistics(LinkedHashMap<Rank, Integer> correctCounts) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        correctCounts.forEach((rank, count) -> {
                if (rank != Rank.NONE) {
                    System.out.println(rank.getMatchCount() + "개 일치 "
                            + (rank.getPrize() == 30000000 ? ", 보너스 볼 일치" : "")
                            + "(" + numberFormat.format(rank.getPrize()) + "원) - "
                            + count + "개");
                };
        });
    }
}
