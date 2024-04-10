package lotto.IO.input;

import lotto.IO.output.Messages;

public class LottoTicket {

    private final int lottoPrice;

    public LottoTicket(int amount) {
        validate(amount);
        this.lottoPrice = amount;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX + Messages.AMOUNT_THOUSAND_UNIT_ERROR);
        }
    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
