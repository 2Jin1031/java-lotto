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
            int matchCount = countMatches(wins, lottos.get(i));
            int bonusCount = countBonus(bonus, lottos.get(i));
            updateCounts(matchCount, bonusCount);
        }
    }

    private int countMatches(List<Integer> wins, List<Integer> lotto) {
        return (int) lotto.stream().mapToInt(num -> num).filter(wins::contains).count();
    }

    private int countBonus(int bonus, List<Integer> lotto) {
        return lotto.contains(bonus) ? 1 : 0;
    }

    private void updateCounts(int matchCount, int bonusCount) {
        if (bonusCount == 1 && matchCount == 5) {
            correctCounts.set(7, correctCounts.get(7) + 1);
            return ;
        }
        int result = matchCount + bonusCount;
        correctCounts.set(result, correctCounts.get(result) + 1);
    }

    public List<Integer> getCorrectCounts() {
        return correctCounts;
    }
}
