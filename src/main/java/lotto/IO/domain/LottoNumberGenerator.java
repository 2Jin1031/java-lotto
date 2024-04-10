package lotto.IO.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private final List<List<Integer>> lottoNumbers;

    public LottoNumberGenerator(int quantity) {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> uniqueNumbers = generateLottoNumber();
            this.lottoNumbers.add(uniqueNumbers);
        }
    }

    private static List<Integer> generateLottoNumber() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
