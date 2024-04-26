package lotto.IO.domain;

import lotto.IO.appConfig.PromptConstants;
import lotto.IO.output.OutputService;

public class Quantity {

    private final int number;

    public Quantity(int number) {
        validate(number);
        this.number = (number) / 1000;
    }

    private void validate(int number) {
        validateLottoAmountNonNegative(number);
        validateAmountInThousandUnites(number);
    }

    private void validateLottoAmountNonNegative(int number) {
        if (number < 0) {
            throw new IllegalStateException(PromptConstants.AMOUNT_NEGATIVE_ERROR);
        }
    }

    private void validateAmountInThousandUnites(int number) {
        if (number % 1000 != 0) {
            throw new IllegalStateException(PromptConstants.AMOUNT_THOUSAND_UNIT_ERROR);
        }
    }

    public int getNumber() {
        return number;
    }

    public void printInfo() {
        OutputService.printPurchaseInfo(number);
    }
}
