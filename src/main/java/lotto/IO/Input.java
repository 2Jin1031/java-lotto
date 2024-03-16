package lotto.IO;

public class Input {

    private final int price;

    public Input(int price) {
        validate(price);
        this.price = price;
    }

    private static void validate(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalStateException("[ERROR] 로또 구입 금액은 1000원 단위로만 가능합니다.");
        }
        if ((price < 0)) {
            throw new IllegalStateException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
    }
}

/*
로또 금액 에러 종류
1. 1000원으로 나누어 떨어지지 않는 경우
2. 음수가 입력된 경우
 */