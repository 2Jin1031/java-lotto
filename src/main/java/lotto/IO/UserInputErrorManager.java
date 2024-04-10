package lotto.IO;

import lotto.IO.domain.Lotto;
import lotto.IO.input.Bonus;
import lotto.IO.input.InputHandler;
import lotto.IO.input.LottoTicket;
import lotto.IO.output.ConsoleMessagePrinter;
import lotto.IO.output.Messages;
import lotto.IO.output.MessagePrinter;

public class UserInputErrorManager {
    private final static MessagePrinter printer = new ConsoleMessagePrinter();

    public static LottoTicket checkAmount() {
        printer.printMessage(Messages.INPUT_AMOUNT);
        return getInput(() -> new LottoTicket(InputHandler.getUserInputAmount()));
    }

    public static Lotto checkLotto() {
        printer.printMessage(Messages.INPUT_LOTTO);
        return getInput(() -> new Lotto(InputHandler.getUserInputLotto()));
    }

    public static Bonus checkBonus(Lotto lotto) {
        printer.printErrorMessage(Messages.INPUT_BONUS);
        return getInput(() -> new Bonus(InputHandler.getUserInputBonus(), lotto));
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
