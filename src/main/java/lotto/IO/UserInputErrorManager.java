package lotto.IO;

import lotto.IO.domain.Lotto;
import lotto.IO.input.Bonus;
import lotto.IO.input.InputHandler;
import lotto.IO.input.LottoTicket;
import lotto.IO.output.ConsoleMessagePrinter;
import lotto.IO.output.Messages;
import lotto.IO.output.MessagePrinter;
import java.util.List;

public class UserInputErrorManager {
    private final static MessagePrinter printer = new ConsoleMessagePrinter();

    public static LottoTicket checkAmount() {
        printer.printMessage(Messages.INPUT_AMOUNT);
        return getLottoTicket();
    }

    private static LottoTicket getLottoTicket() {
        LottoTicket lottoTicket;
        int number;
        while (true) {
            try {
                number = InputHandler.getUserInputAmount();
                lottoTicket = new LottoTicket(number);
                break;
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(e.getMessage());
            }
        }
        return lottoTicket;
    }

    public static Lotto checkLotto() {
        System.out.println();
        printer.printMessage(Messages.INPUT_LOTTO);

        Lotto lotto;
        while (true) {
            try {
                List<Integer> inputList = InputHandler.getUserInputLotto();
                lotto = new Lotto(inputList);
                break;
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(e.getMessage());
            }
        }
        return lotto;
    }

    public static Bonus checkBonus(Lotto lotto) {
        System.out.println();
        printer.printMessage(Messages.INPUT_BONUS);

        int number;
        Bonus bonus;
        while (true) {
            try {
                number = InputHandler.getUserInputBonus();
                bonus = new Bonus(number, lotto);
                break;
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(e.getMessage());
            }
        }
        return bonus;
    }
}
