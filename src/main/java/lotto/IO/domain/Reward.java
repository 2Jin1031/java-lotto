package lotto.IO.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Reward {

    private final int reward;

    public Reward(List<Integer> winPrice, List<Integer> correctCounts) {
        this.reward = IntStream.range(0, winPrice.toArray().length)
                .map(i -> winPrice.get(i) * correctCounts.get(i))
                .sum();
    }

    public int getReward() {
        return reward;
    }
}
