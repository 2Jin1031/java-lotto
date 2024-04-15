package lotto;

import lotto.IO.input.InputValidator;
import lotto.IO.domain.*;
import lotto.IO.domain.Win;

public class LottoGame {

    public void process() {
        LottoTicket lottoTicket = InputValidator.getValidLottoTicket();
        Quantity quantity = new Quantity(lottoTicket.getLottoPrice());
        LottosGenerator lottosGenerator = new LottosGenerator(quantity);
        printLottoInformation(quantity, lottosGenerator);

        Lotto lotto = InputValidator.getValidLotto();
        Bonus bonus = InputValidator.getValidBonus(lotto);

        processWinning(lottoTicket, quantity, lotto, bonus, lottosGenerator);
    }

    private void printLottoInformation(Quantity quantity, LottosGenerator lottosGenerator) {
        quantity.printInfo();
        lottosGenerator.print();
    }

    private void processWinning(LottoTicket lottoTicket, Quantity quantity, Lotto lotto, Bonus bonus, LottosGenerator lottosGenerator) {
        Win win = new Win(quantity.getQuantity());
        win.countCorrects(lotto.getNumbers(), bonus.getBonus(), lottosGenerator.getLottoNumbers());
        win.print();
        calculateRewards(lottoTicket, win);
    }

    private void calculateRewards(LottoTicket lottoTicket, Win win) {
        Reward reward = new Reward(win.getWinPrices(), win.getCorrectCounts());
        printRateOfReturn(lottoTicket, reward);
    }

    private void printRateOfReturn(LottoTicket lottoTicket, Reward reward) {
        RateOfReturn rateOfReturn = new RateOfReturn(lottoTicket.getLottoPrice(), reward.getReward());
        rateOfReturn.print();
    }
}
