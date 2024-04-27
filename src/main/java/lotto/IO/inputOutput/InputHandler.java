package lotto.IO.inputOutput;

import lotto.IO.appConfig.Console;
import lotto.IO.appConfig.ConfigConstants;
import lotto.IO.appConfig.PromptConstants;
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
            throw new IllegalArgumentException(PromptConstants.NUMBER_FORMAT_ERROR);
        }
    }

    public static List<Integer> parseIntegerListOrThrow(String input) {
        List<String> splitInputs = splitInput(input);

        List<Integer> numbers = new ArrayList<>();
        for (String splitInput : splitInputs) {
            try {
                numbers.add(Integer.parseInt(splitInput.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(PromptConstants.NUMBER_FORMAT_ERROR);
            }
        }
        return numbers;
    }

    private static List<String> splitInput(String input) {
        return List.of(input.split(ConfigConstants.LOTTO_NUMBER_DELIMITER));
    }
}
