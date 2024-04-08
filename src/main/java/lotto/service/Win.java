package lotto.service;

import java.util.List;

public class Win {

    private final int[] correctCounts;
    private final int lottoSize;

    public Win(int lottoSize) {
        this.lottoSize = lottoSize;
        this.correctCounts = new int[8];
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
                correctCounts[7]++;
                continue;
            }
            int result = count + bonusCount;
            correctCounts[result]++;
        }
    }

    public int[] getCorrectCounts() {
        return correctCounts;
    }
}
