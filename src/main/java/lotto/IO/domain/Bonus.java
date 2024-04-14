package lotto.IO.domain;

import lotto.IO.appConfig.Messages;
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

    private void numberRangeCheck(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(Messages.BONUS_RANGE_ERROR);
        }
    }

    private void duplicateByLotto(int bonus, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(Messages.BONUS_DUPLICATE_ERROR);
        }
    }

    public int getBonus() {
        return bonus;
    }
}
