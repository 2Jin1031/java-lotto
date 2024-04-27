package lotto;

import lotto.IO.inputOutput.InputView;
import lotto.IO.domain.*;
import lotto.IO.domain.Win;

public class LottoGame {

    public void process() {
        LottoTicket lottoTicket = InputView.getValidLottoTicket();
        Quantity quantity = new Quantity(lottoTicket.getLottoPrice());
        Lottos lottos = new Lottos(quantity);
        printLottoInformation(quantity, lottos);

        Lotto lotto = InputView.getValidLotto();
        Bonus bonus = InputView.getValidBonus(lotto);

        processWinning(lottoTicket, quantity, lotto, bonus, lottos);
    }

    private void printLottoInformation(Quantity quantity, Lottos lottos) {
        quantity.printInfo();
        lottos.print();
    }

    private void processWinning(LottoTicket lottoTicket, Quantity quantity, Lotto lotto, Bonus bonus, Lottos lottos) {
        Win win = new Win(quantity.getNumber());
        win.countCorrects(lotto.getNumbers(), bonus.getBonus(), lottos.getLottoNumbers());
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
