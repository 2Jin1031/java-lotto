package lotto.IO.input;

import lotto.IO.info.Info;

public class
LottoTicket {

    private final int lottoPrice;

    public LottoTicket(int amount) {
        validate(amount);
        this.lottoPrice = amount;
    }

    private static void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다");
        }
    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
