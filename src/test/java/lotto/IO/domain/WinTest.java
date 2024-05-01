package lotto.IO.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WinTest {

    @Test
    public void testCorrectCountsUpdate() {
        // 당첨 번호 설정
        List<Integer> wins = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 보너스 번호 설정
        int matchBonus = 45;

        // 여러 로또 입력
        List<List<Integer>> lottos = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6), // 6개 모두 일치, 보너스 없음
                Arrays.asList(1, 2, 3, 4, 5, 45), // 5개 일치, 보너스 일치
                Arrays.asList(1, 2, 3, 7, 8, 9),  // 3개 일치, 보너스 없음
                Arrays.asList(1, 2, 10, 11, 12, 13) // 2개 일치, 보너스 없음
        );

        Win win = new Win(wins, matchBonus, lottos);

        // 예상 결과 생성
        LinkedHashMap<Rank, Integer> correctCounts = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            correctCounts.put(rank, 0);
        }
        correctCounts.put(Rank.FIRST, 1);
        correctCounts.put(Rank.SECOND, 1);
        correctCounts.put(Rank.FIFTH, 1);
        correctCounts.put(Rank.NONE, 1);

        // 실제 결과 검증
        LinkedHashMap<Rank, Integer> actual = win.getCorrectCounts();
        assertEquals(correctCounts, actual);
        System.out.println(correctCounts);
        System.out.println("==================================");
        for (Rank rank : Rank.values()) {
            System.out.println(correctCounts.get(rank));
        }
    }
}