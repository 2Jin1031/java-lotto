package lotto.IO.domain;

public class Reward {

    private final int reward;

    public Reward(int[] winPrice, int[] correctCounts) {
        int sum = 0;
        for (int i = 0; i < winPrice.length; i++) {
            sum += winPrice[i] * correctCounts[i];
        }
        this.reward = sum;
    }

    public int getReward() {
        return reward;
    }
}
