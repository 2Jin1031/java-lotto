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
            this.lottoNumbers.add(generateSortedLottoNumbers());
        }
    }

    private List<Integer> generateSortedLottoNumbers() {
        List<Integer> uniqueNumbers = generateUniqueLottoNumbers();
        return sortNumbers(uniqueNumbers);
    }

    private static List<Integer> generateUniqueLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
