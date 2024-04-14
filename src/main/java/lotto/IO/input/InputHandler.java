package lotto.IO.input;

import lotto.Console;
import lotto.IO.output.Contants;
import lotto.IO.output.Messages;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static String readInput() {
        return Console.readLine();
    }

    public static Integer parseIntOrThrow(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.NUMBER_FORMAT_ERROR);
        }
    }

    public static List<Integer> parseIntegerListOrThrow(String input) {
        List<String> splitInputs = splitInput(input, Contants.LOTTO_NUMBER_DELIMITER);

        List<Integer> numbers = new ArrayList<>();
        for (String splitInput : splitInputs) {
            try {
                numbers.add(Integer.parseInt(splitInput.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Messages.NUMBER_FORMAT_ERROR);
            }
        }
        return numbers;
    }

    private static List<String> splitInput(String input, String delimiter) {
        return List.of(input.split(delimiter));
    }
}
