package lotto.IO.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.IO.output.OutputService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<List<Integer>> lottoNumbers;

    public Lottos(Quantity quantity) {
        this.lottoNumbers = generateLottos(quantity);
    }

    private List<List<Integer>> generateLottos(Quantity quantity) {
        int numLottos = quantity.getNumber();
        return IntStream.range(0, numLottos)
                .mapToObj(i -> generateLottoNumber())
                .collect(Collectors.toList());
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
