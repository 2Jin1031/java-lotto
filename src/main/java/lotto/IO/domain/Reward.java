package lotto.IO.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Reward {

    private final int reward;

    public Reward(LinkedHashMap<Rank, Integer> correctCounts) {
        LinkedHashMap<Rank, Integer> rankMap = Rank.of();
        int result = 0;
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                result += rankMap.get(rank) * correctCounts.get(rank);
            }
        }
        reward = result;
    }

    public int getReward() {
        return reward;
    }
}
