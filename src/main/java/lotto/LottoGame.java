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
        printLottoInformation(quantity, lottosGenerator);

        Lotto lotto = UserInputErrorManager.checkLotto();
        Bonus bonus = UserInputErrorManager.checkBonus(lotto);

        displayStatistics();
        processWinning(lottoTicket, quantity, lotto, bonus, lottosGenerator);
    }

    private void printLottoInformation(Quantity quantity, LottosGenerator lottosGenerator) {
        LottoOutput lottoOutput = new LottoOutput(quantity.getQuantity(), lottosGenerator.getLottoNumbers());
        lottoOutput.printInfo();
        lottoOutput.printLottos();
    }

    private void displayStatistics() {
        Info.Statistics();
    }

    private void processWinning(LottoTicket lottoTicket, Quantity quantity, Lotto lotto, Bonus bonus, LottosGenerator lottosGenerator) {
        Win win = new Win(quantity.getQuantity());
        win.count(lotto.getNumbers(), bonus.getBonus(), lottosGenerator.getLottoNumbers());
        WinOutput winOutput = printWinningInfo(win);
        calculateRewards(lottoTicket, winOutput, win);
    }

    private WinOutput printWinningInfo(Win win) {
        WinOutput winOutput = new WinOutput(win.getCorrectCounts());
        winOutput.print();

        return winOutput;
    }

    private void calculateRewards(LottoTicket lottoTicket, WinOutput winOutput, Win win) {
        Reward reward = new Reward(winOutput.getWinPrice(), win.getCorrectCounts());
        printRateOfReturn(lottoTicket, reward);
    }

    private void printRateOfReturn(LottoTicket lottoTicket, Reward reward) {
        LottoRate lottoRate = new LottoRate(lottoTicket.getLottoPrice(), reward.getReward());
        RateOfReturnOutput rateOfReturnOutput = new RateOfReturnOutput(lottoRate.getRate());
        rateOfReturnOutput.print();
    }
}
