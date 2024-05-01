package lotto.IO.domain;

import lotto.IO.appConfig.PromptConstants;

public class LottoTicket {

    private final int lottoPrice;

    public LottoTicket(int amount) {
        validate(amount);
        this.lottoPrice = amount;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PromptConstants.AMOUNT_THOUSAND_UNIT_ERROR);
        }
    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
