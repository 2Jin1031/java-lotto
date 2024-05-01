package lotto.IO.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Reward {

    private final int reward;

    // TODO: Reward 클래스 수정 필요
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
