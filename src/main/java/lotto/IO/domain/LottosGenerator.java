package lotto.IO.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.IO.output.OutputService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottosGenerator {

    private final List<List<Integer>> lottoNumbers;

    public LottosGenerator(Quantity quantity) {
        this.lottoNumbers = generateLottos(quantity);
    }

    private List<List<Integer>> generateLottos(Quantity quantity) {
        List<List<Integer>> lottos = new ArrayList<>();
        int numLottos = quantity.getNumber();
        for (int i = 0; i < numLottos; i++) {
            lottos.add(generateLottoNumber());
        }
        return lottos;
    }
    public List<Integer> generateLottoNumber() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public void print() {
        OutputService.printLottos(lottoNumbers);
    }
}
