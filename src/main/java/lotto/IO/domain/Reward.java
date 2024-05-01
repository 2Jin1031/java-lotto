package lotto.IO.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Reward {

    private final int reward;

    public Reward(Map<Rank, Integer> correctCounts) {
        Map<Rank, Integer> rankReward = new EnumMap<>(Rank.class);
        this.reward = IntStream.range(0, correctCounts.size())
                .mapToObj(i -> rankReward.get(i) * correctCounts.get(i))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getReward() {
        return reward;
    }
}
