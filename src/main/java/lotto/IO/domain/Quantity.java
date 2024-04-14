package lotto.IO.domain;

import lotto.IO.appConfig.Messages;
import lotto.IO.output.OutputService;

public class Quantity {

    private final int quantity;

    public Quantity(int number) {
        validate(number);
        this.quantity = (number) / 1000;
    }

    private void validate(int number) {
        validateLottoAmountNonNegative(number);
        validateAmountInThousandUnites(number);
    }

    private void validateLottoAmountNonNegative(int number) {
        if (number < 0) {
            throw new IllegalStateException(Messages.AMOUNT_NEGATIVE_ERROR);
        }
    }

    private void validateAmountInThousandUnites(int number) {
        if (number % 1000 != 0) {
            throw new IllegalStateException(Messages.AMOUNT_THOUSAND_UNIT_ERROR);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void printInfo() {
        OutputService.printPurchaseInfo(quantity);
    }
}
