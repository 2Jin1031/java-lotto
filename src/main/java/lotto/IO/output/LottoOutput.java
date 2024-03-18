package lotto.IO.output;

import java.util.ArrayList;
import java.util.List;

public class LottoOutput {

    private final int quantity;
    private final List<List<Integer>> numbers;

    public LottoOutput(int quantity, List<List<Integer>> numbers) {
        this.quantity = quantity;
        this.numbers = numbers;
    }

    public void PrintInfo() {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void PrintLottos() {
        for (List<Integer> lotto : numbers) {
            System.out.print("[");
            for (int i = 0; i < lotto.size(); i++) {
                System.out.print(lotto.get(i));
                if (i != lotto.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}

