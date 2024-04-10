package lotto.IO.output;

import java.util.List;
import java.util.stream.IntStream;

public class LottoOutput {

    private final int quantity;
    private final List<List<Integer>> numbers;

    public LottoOutput(int quantity, List<List<Integer>> numbers) {
        this.quantity = quantity;
        this.numbers = numbers;
    }

    public void printInfo() {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printLottos() {
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
}

