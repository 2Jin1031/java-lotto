package lotto;

import lotto.IO.UserInputErrorManager;
import lotto.IO.domain.*;
import lotto.IO.info.Info;
import lotto.IO.input.Bonus;
import lotto.IO.input.LottoTicket;
import lotto.IO.output.LottoOutput;
import lotto.IO.output.RateOfReturnOutput;
import lotto.IO.output.WinOutput;
import lotto.service.Win;

public class LottoGame {

    public void process() {
        LottoTicket lottoTicket = UserInputErrorManager.checkAmount();

        Quantity quantity = new Quantity(lottoTicket.getLottoPrice());
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(quantity.getQuantity());
        LottoOutput lottoOutput = new LottoOutput(quantity.getQuantity(), lottoNumberGenerator.getLottoNumbers());
        lottoOutput.PrintInfo();
        lottoOutput.PrintLottos();

        Lotto lotto = UserInputErrorManager.checkLotto();

        Bonus bonus = UserInputErrorManager.checkBonus(lotto);


        Info.Statistics();

        Win win = new Win(quantity.getQuantity());
        win.Count(lotto.getNumbers(), bonus.getBonus(), lottoNumberGenerator.getLottoNumbers());
        WinOutput winOutput = new WinOutput(win.getCorrectCounts());
        winOutput.Print();

        Reward reward = new Reward(winOutput.getWinPrice(), win.getCorrectCounts());

        // test print
//        System.out.println("reward.getReward() = " + reward.getReward());

        Rate rate = new Rate(lottoTicket.getLottoPrice(), reward.getReward());

        RateOfReturnOutput rateOfReturnOutput = new RateOfReturnOutput(rate.getRate());
        rateOfReturnOutput.Print();

    }
}
