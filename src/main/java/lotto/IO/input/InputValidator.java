package lotto.IO.input;

import lotto.IO.domain.Lotto;
import lotto.IO.domain.Bonus;
import lotto.IO.input.InputHandler;
import lotto.IO.domain.LottoTicket;
import lotto.IO.appConfig.ConsoleMessagePrinter;
import lotto.IO.appConfig.Messages;
import lotto.IO.appConfig.MessagePrinter;

public class InputValidator {

    private final static MessagePrinter printer = new ConsoleMessagePrinter();

    public static LottoTicket getValidLottoTicket() {
        printer.printMessage(Messages.INPUT_AMOUNT);
        return getInput(() -> {
            String input = InputHandler.readInput();
            return new LottoTicket(InputHandler.parseIntOrThrow(input));
        });
    }

    public static Lotto getValidLotto() {
        System.out.println();
        printer.printMessage(Messages.INPUT_LOTTO);
        return getInput(() -> {
            String input = InputHandler.readInput();
            return new Lotto(InputHandler.parseIntegerListOrThrow(input));
        });
    }

    public static Bonus getValidBonus(Lotto lotto) {
        System.out.println();
        printer.printMessage(Messages.INPUT_BONUS);
        return getInput(() -> {
            String input = InputHandler.readInput();
            return new Bonus(InputHandler.parseIntOrThrow(input), lotto);
        });
    }

    private static <T> T getInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    private interface Supplier<T> {
        T get() throws IllegalArgumentException;
    }
}
