package lotto;

import lotto.IO.UserInputErrorManager;
import lotto.IO.domain.Lotto;
import lotto.IO.domain.Quantity;
import lotto.IO.domain.Random;
import lotto.IO.input.LottoTicket;
import lotto.IO.output.LottoOutput;

public class LottoGame {

    public void process() {
        LottoTicket lottoTicket = UserInputErrorManager.checkAmount();

        Quantity quantity = new Quantity(lottoTicket.getLottoPrice());
        Random random = new Random(quantity.getQuantity());
        LottoOutput lottoOutput = new LottoOutput(quantity.getQuantity(), random.getNumbers());
        lottoOutput.PrintInfo();
        lottoOutput.PrintLottos();

        Lotto lotto = UserInputErrorManager.checkLotto();
//
//        BonusInput bonusInput = UserInputErrorManager.checkBonus(lotto);
//
//
//        //info.Statistics();
//
//        Win win = new Win(quantity.getQuantity());
////        win.Count(LottoTicket.getLottes(), bonusInput.getBonus(), random.getNumbers());
//        WinOutput winOutput = new WinOutput(win.getCorrectCounts());
//        winOutput.Print();
//
//        Reward reward = new Reward(winOutput.getWinPrice(), win.getCorrectCounts());
//
//        Rate rate = new Rate(lottoTicket.getLottoPrice(), reward.getReward());
//
//        RateOfReturnOutput rateOfReturnOutput = new RateOfReturnOutput(rate.getRate());
//        rateOfReturnOutput.Print();

    }
}
