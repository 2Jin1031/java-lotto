package lotto.IO.input;

import lotto.Console;
import lotto.IO.output.Contants;
import lotto.IO.output.Messages;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static Integer getUserInputAmount() {
        return validateParseInt(readInput());
    }

    public static List<Integer> getUserInputLotto() {
        List<String> inputs = splitInput(readInput(), Contants.LOTTO_NUMBER_DELIMITER);
        return validateParseIntegerLists(inputs);
    }

    public static Integer getUserInputBonus() {
        String input = readInput();
        return validateParseInt(input);
    }

    private static String readInput() {
        return Console.readLine();
    }

    private static List<String> splitInput(String input, String delimiter) {
        return List.of(input.split(delimiter));
    }

    private static List<Integer> validateParseIntegerLists(List<String> inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            try {
                numbers.add(Integer.parseInt(input.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Messages.NUMBER_FORMAT_ERROR);
            }
        }
        return numbers;
    }

    private static Integer validateParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.NUMBER_FORMAT_ERROR);
        }
    }
}
