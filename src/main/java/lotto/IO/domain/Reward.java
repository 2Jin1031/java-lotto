package lotto.IO.domain;

import java.util.stream.IntStream;

public class Reward {

    private final int reward;

    public Reward(int[] winPrice, int[] correctCounts) {
        int sum = IntStream.range(0, winPrice.length).map(i -> winPrice[i] * correctCounts[i]).sum();
        this.reward = sum;
    }

    public int getReward() {
        return reward;
    }
}
