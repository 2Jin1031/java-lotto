package lotto.IO.domain;

public class Quantity {

    private final int quantity;

    public Quantity(int number) {
        validate(number);
        this.quantity = (number) / 1000;
    }

    public int getQuantity() {
        return quantity;
    }

    private static void validate(int number) {
        validateAmountInThousandUnites(number);
        validateLottoAmountNonNegative(number);
    }

    private static void validateLottoAmountNonNegative(int number) {
        if ((number < 0)) {
            throw new IllegalStateException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
    }

    private static void validateAmountInThousandUnites(int number) {
        if ((number % 1000) != 0) {
            throw new IllegalStateException("[ERROR] 로또 구입 금액은 1000원 단위로만 가능합니다.");
        }
    }
}

/*
로또 금액 에러 종류
1. 1000원으로 나누어 떨어지지 않는 경우
2. 음수가 입력된 경우
 */