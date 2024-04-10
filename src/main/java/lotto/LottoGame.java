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
        LottosGenerator lottosGenerator = new LottosGenerator(quantity.getQuantity());
        LottoOutput lottoOutput = new LottoOutput(quantity.getQuantity(), lottosGenerator.getLottoNumbers());
        lottoOutput.printInfo();
        lottoOutput.printLottos();

        Lotto lotto = UserInputErrorManager.checkLotto();

        Bonus bonus = UserInputErrorManager.checkBonus(lotto);

        Info.Statistics();

        Win win = new Win(quantity.getQuantity());
        win.count(lotto.getNumbers(), bonus.getBonus(), lottosGenerator.getLottoNumbers());
        WinOutput winOutput = new WinOutput(win.getCorrectCounts());
        winOutput.print();

        Reward reward = new Reward(winOutput.getWinPrice(), win.getCorrectCounts());

        LottoRate lottoRate = new LottoRate(lottoTicket.getLottoPrice(), reward.getReward());

        RateOfReturnOutput rateOfReturnOutput = new RateOfReturnOutput(lottoRate.getRate());
        rateOfReturnOutput.print();
    }
}
