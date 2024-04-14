package lotto.IO.domain;

import lotto.IO.output.Messages;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numbersRangeCheck(numbers);
        numbersSizeCheck(numbers);
        numbersDuplicate(numbers);
    }

    private void numbersRangeCheck(List<Integer> numbers) {
        numbers.stream().mapToInt(number -> number).filter(number -> number < 1 || number > 45).forEach(number -> {
            throw new IllegalArgumentException(Messages.LOTTO_RANGE_ERROR);
        });
    }

    private void numbersSizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void numbersDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(Messages.LOTTO_DUPLICATE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
