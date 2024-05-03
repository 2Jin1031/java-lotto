package lotto.IO.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {


    @Test
    @DisplayName("보너스 번호가 가능한 범위인지 확인한다.")
    void bonusRange() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int bonusNumbers[] = {0, 46};

        //then
        for (int bonusNumber : bonusNumbers) {
            assertThrows(IllegalArgumentException.class, () -> new Bonus(bonusNumber, lotto));
        }
    }

}