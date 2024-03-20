package lotto.IO.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numbersSizeCheck(numbers);
        numbersRangeCheck(numbers);
        numbersDuplicate(numbers);

    }

    private static void numbersRangeCheck(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void numbersSizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void numbersDuplicate(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        for (int i = 0; i < sortNumbers.size() - 1; i++) {
            if (sortNumbers.get(i).equals(sortNumbers.get(i + 1))) {
                throw new IllegalArgumentException("로또 번호는 모두 다른 숫자여야 합니다");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
