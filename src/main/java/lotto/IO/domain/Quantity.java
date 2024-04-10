package lotto.IO.domain;

import lotto.IO.output.Messages;

public class Quantity {

    private final int quantity;

    public Quantity(int number) {
        validate(number);
        this.quantity = (number) / 1000;
    }

    private static void validate(int number) {
        validateAmountInThousandUnites(number);
        validateLottoAmountNonNegative(number);
    }

    private static void validateLottoAmountNonNegative(int number) {
        if ((number < 0)) {
            throw new IllegalStateException(Messages.AMOUNT_NEGATIVE_ERROR);
        }
    }

    private static void validateAmountInThousandUnites(int number) {
        if ((number % 1000) != 0) {
            throw new IllegalStateException(Messages.AMOUNT_THOUSAND_UNIT_ERROR);
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
