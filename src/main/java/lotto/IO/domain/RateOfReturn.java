package lotto.IO.domain;

import lotto.IO.output.OutputService;

public class RateOfReturn {

    private final double rateOfReturn;

    public RateOfReturn(double price, double benefit) {
        this.rateOfReturn = (benefit / price) * 100;
    }
    
    public void print() {
        OutputService.printRateOfReturn(rateOfReturn);
    }
}
