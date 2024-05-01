package lotto.IO.domain;

import lotto.IO.inputOutput.OutputService;

import java.util.*;

public class Win {

    private final LinkedHashMap<Rank, Integer> correctCounts;

    public Win(List<Integer> wins, int matchBonus, List<List<Integer>> lottos) {
        this.correctCounts = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            this.correctCounts.put(rank, 0);
        }
        countCorrects(wins, matchBonus, lottos);
    }

    public void countCorrects(List<Integer> wins, int matchBonus, List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            int matchCount = countMatches(wins, lotto);
            boolean isBonusMatched = isBonusMatched(matchBonus, lotto);
            updateCounts(matchCount, isBonusMatched);
        }
    }

    private int countMatches(List<Integer> wins, List<Integer> lotto) {
        return (int) lotto.stream()
                .filter(wins::contains)
                .count();
    }

    private boolean isBonusMatched(int bonus, List<Integer> lotto) {
        return lotto.contains(bonus);
    }

    private void updateCounts(int matchCount, boolean bonusCount) {
        Rank rank = Rank.valueof(matchCount, bonusCount);
        correctCounts.put(rank, correctCounts.get(rank) + 1);
    }
    public void print() {
        OutputService.printWinStatistics(correctCounts);
    }

    public LinkedHashMap<Rank, Integer> getCorrectCounts() {
        return correctCounts;
    }
}
