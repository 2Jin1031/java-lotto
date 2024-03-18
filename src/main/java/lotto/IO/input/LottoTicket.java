package lotto.IO.input;

import lotto.IO.info.Info;

public class LottoTicket {

//    private final Info info;
    private final int lottoPrice;
    //private final InputConfig inputConfig;


//    public LottoTicket(Info info, InputConfig inputConfig) {
//        this.info = info;
//        this.inputConfig = inputConfig;
//        this.lottoPrice = InputHandler.getUserInputAmount();
//    }

    public LottoTicket(int amount) {
//        this.info = new Info();
//        Info();
        //this.inputConfig = inputConfig;
//        this.lottoPrice = InputHandler.getUserInputAmount();
        this.lottoPrice = amount;
    }

    private int getPrice() {
        //Info();
        String input = InputConfig.Input();
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (Exception e) {
            new IllegalArgumentException("[ERROR] 로또 금액은 숫자여야 합니다.");
        }
        return num;

    }
//
//    public void Info() {
//        info.PriceInput();
//    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
