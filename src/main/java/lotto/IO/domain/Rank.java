package lotto.IO.domain;

import java.util.Map;

public enum Rank {
    FIRST(6, 2000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(-1, -1);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueof(int matchCount, boolean matchBonus) {
        if (matchCount == SECOND.matchCount) {
            return isMatchBouns(matchBonus) ? SECOND : THIRD;
        }
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return NONE;
    }

    public static Map<Rank, Integer> of(int i) {
        return Map.of(
                FIRST, FIRST.getPrize(),
                SECOND, SECOND.getPrize(),
                THIRD, THIRD.getPrize(),
                FOURTH, FOURTH.getPrize(),
                FIFTH, FIFTH.getPrize()
        );

    }

    public static boolean isMatchBouns(boolean matchBonus) {
        return matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
