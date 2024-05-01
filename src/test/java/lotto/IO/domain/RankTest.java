package lotto.IO.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    public void testRankMap() {
        LinkedHashMap<Rank, Integer> rankMap = Rank.of();
        System.out.println(rankMap);
        for (Rank rank : Rank.values()) {
            System.out.println(rankMap.get(rank));
        }
//        assertNotNull(rankPrizes, "The map should not be null");
//        assertEquals(5, rankPrizes.size(), "There should be 5 entries in the map");
//
//        // Ensure each rank is correctly mapped to its prize
//        for (Rank rank : Rank.values()) {
//            if (rank != Rank.NONE) { // NONE rank has no prize
//                assertTrue(rankPrizes.containsKey(rank), "Map should contain key for " + rank);
//                assertEquals(rank.getPrize(), (int) rankPrizes.get(rank), "Prize mismatch for " + rank);
//                System.out.println("Verified " + rank + " with prize " + rank.getPrize());
//            }
//        }
    }

}