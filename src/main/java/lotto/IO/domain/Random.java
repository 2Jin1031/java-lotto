package lotto.IO.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Random {

    private final List<List<Integer>> numbers;

    public Random(int quantity) {
        numbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortalbeList = new ArrayList<>(uniqueNumbers);
            Collections.sort(sortalbeList);
            numbers.add(sortalbeList);
        }
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }
}
