package lotto.IO.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.IO.domain.Lotto;
import lotto.IO.info.Info;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Bonus {

    private final int bonus;

    public Bonus(int bonus, Lotto lotto) {
        validate(bonus, lotto);
        this.bonus = bonus;
    }

    private void validate(int bonus, Lotto lotto) {
        duplicatedwithLotto(bonus, lotto);
        numberRangeCheck(bonus);

    }

    private static void numberRangeCheck(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void duplicatedwithLotto(int bonus, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 다른 숫자여야 합니다.");
        }
    }


    public int getBonus() {
        return bonus;
    }
}
