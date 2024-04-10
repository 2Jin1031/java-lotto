package lotto.IO.domain;

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
            throw new IllegalStateException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
    }

    private static void validateAmountInThousandUnites(int number) {
        if ((number % 1000) != 0) {
            throw new IllegalStateException("[ERROR] 로또 구입 금액은 1000원 단위로만 가능합니다.");
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
