package lotto.IO.domain;

import lotto.IO.output.OutputService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Win {

    private final List<Integer> correctCounts;
    private final List<Integer> winPrices;
    private final int lottoSize;

    public Win(int lottoSize) {
        this.lottoSize = lottoSize;
        this.correctCounts = new ArrayList<>(8);
        this.winPrices = List.of(0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000);
        IntStream.range(0, 8).forEach(i -> correctCounts.add(0));
    }

    public void countCorrects(List<Integer> wins, int bonus, List<List<Integer>> lottos) {
        for (int i = 0; i < lottoSize; i++) {
            int matchCount = countMatches(wins, lottos.get(i));
            int bonusCount = countBonus(bonus, lottos.get(i));
            updateCounts(matchCount, bonusCount);
        }
    }

    private int countMatches(List<Integer> wins, List<Integer> lotto) {
        return (int) lotto.stream().filter(wins::contains).count();
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
    public void print() {
        OutputService.printWinStatistics(correctCounts, winPrices);
    }

    public List<Integer> getCorrectCounts() {
        return correctCounts;
    }

    public List<Integer> getWinPrices() {
        return winPrices;
    }
}
