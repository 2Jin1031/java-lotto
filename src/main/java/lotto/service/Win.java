package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Win {

    private final List<Integer> correctCounts;
    private final int lottoSize;

    public Win(int lottoSize) {
        this.lottoSize = lottoSize;
        this.correctCounts = new ArrayList<>(8);
        IntStream.range(0, 8).mapToObj(i -> 0).forEach(this.correctCounts::add);
    }

    public void count(List<Integer> wins, int bonus, List<List<Integer>> lottos) {
        for (int i = 0; i < lottoSize; i++) {
            int count = 0, bonusCount = 0;
            for (int j = 0; j < 6; j++) {
                if (wins.contains(lottos.get(i).get(j))) {
                    count++;
                }
                if (bonus == lottos.get(i).get(j)) {
                    bonusCount++;
                }
            }
            if (bonusCount == 1 && count == 5) {
                correctCounts.set(7, correctCounts.get(7) + 1);
                continue;
            }
            int result = count + bonusCount;
            correctCounts.set(result, correctCounts.get(result) + 1);
        }
    }

    public List<Integer> getCorrectCounts() {
        return correctCounts;
    }
}
