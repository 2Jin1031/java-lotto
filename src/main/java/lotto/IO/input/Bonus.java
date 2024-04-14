package lotto.IO.input;

import lotto.IO.domain.Lotto;
import lotto.IO.output.Messages;

import java.util.List;

public class Bonus {

    private final int bonus;

    public Bonus(int bonus, Lotto lotto) {
        validate(bonus, lotto);
        this.bonus = bonus;
    }

    private void validate(int bonus, Lotto lotto) {
        numberRangeCheck(bonus);
        duplicateByLotto(bonus, lotto);
    }

    private static void numberRangeCheck(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(Messages.BONUS_RANGE_ERROR);
        }
    }

    private static void duplicateByLotto(int bonus, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(Messages.BONUS_DUPLICATE_ERROR);
        }
    }

    public int getBonus() {
        return bonus;
    }
}
