package lotto.IO.domain;

import lotto.IO.appConfig.ConfigConstants;
import lotto.IO.appConfig.PromptConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        for (Integer number : numbers) {
            if (number < ConfigConstants.LOTTO_MIN_NUMBER || number > ConfigConstants.LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(PromptConstants.LOTTO_RANGE_ERROR);
            }
        }
    }

    private void numbersSizeCheck(List<Integer> numbers) {
        if (numbers.size() != ConfigConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(PromptConstants.LOTTO_SIZE_ERROR);
        }
    }

    private void numbersDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != ConfigConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(PromptConstants.LOTTO_DUPLICATE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
