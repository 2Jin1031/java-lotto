package lotto.IO.input;

import lotto.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static Integer getUserInputAmount() {
        String input = Console.readLine();
        return checkNumberFormat(input);
    }

    public static List<Integer> getUserInputLotto() {
        String input = Console.readLine();

        List<String> inputs = List.of(input.split(","));
        List<Integer> lottoNums = new ArrayList<>();

        inputs.forEach(element -> {
            checkNumbersFormat(element, lottoNums);
        });
        return lottoNums;
    }

    public static Integer getUserInputBonus() {
        String input = Console.readLine();
        return checkNumberFormat(input);
    }

    private static void checkNumbersFormat(String element, List<Integer> lottoNums) {
        try {
            int lotto = Integer.parseInt(element.trim());
            lottoNums.add(lotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }

    private static int checkNumberFormat(String input) {
        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        return amount;
    }
}
