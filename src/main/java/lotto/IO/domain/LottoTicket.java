package lotto.IO.domain;

import lotto.IO.appConfig.Messages;

public class LottoTicket {

    private final int lottoPrice;

    public LottoTicket(int amount) {
        validate(amount);
        this.lottoPrice = amount;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(Messages.AMOUNT_THOUSAND_UNIT_ERROR);
        }
    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
