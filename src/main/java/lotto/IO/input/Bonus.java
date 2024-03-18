package lotto.IO.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.IO.domain.Lotto;
import lotto.IO.info.Info;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Bonus {

    private final Info info;
    private final int bonus;
//    private final InputConfig inputConfig;

    public Bonus(int bonus, Lotto lotto /*Info info*//*, InputConfig inputConfig*/) {
        this.info = new Info();
        this.bonus = bonus;
        Info();
        //this.inputConfig = inputConfig;
//        bonus = InputHandler.getUserInputBonus();
    }

    private int getInput() {
        final int bonus;
        Info();
        String input = null;
        try {
            input = InputConfig.Input();
        } catch (Exception e) {
            new IllegalArgumentException();
        }
        bonus = Integer.parseInt(input);
        return bonus;
    }

    public void Info() {
        info.BonusInput();
    }

    public int getBonus() {
        return bonus;
    }
}
