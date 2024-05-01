package lotto.IO.domain;

import java.util.LinkedHashMap;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueof(int matchCount, boolean matchBonus) {
        if (matchCount == THIRD.matchCount) {
            return matchBonus ? SECOND : THIRD;
        }
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return NONE;
    }

    public static LinkedHashMap of() {
        LinkedHashMap map = new LinkedHashMap();
        map.put(NONE, NONE.getPrize());
        map.put(FIFTH, FIFTH.getPrize());
        map.put(FOURTH, FOURTH.getPrize());
        map.put(THIRD, THIRD.getPrize());
        map.put(SECOND, SECOND.getPrize());
        map.put(FIRST, FIRST.getPrize());
        return map;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
