package lotto.IO.domain;

public class Reward {

    private final int reward;

    public Reward(int[] WinPrice, int[] correctCounts) {
        int sum = 0;
        for (int i = 0; i < WinPrice.length; i++) {
            sum += WinPrice[i] * correctCounts[i];
        }
        this.reward = sum;
    }

    public int getReward() {
        return reward;
    }
}
