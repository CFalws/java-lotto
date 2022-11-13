package lotto.model;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_LOWER_BOUNDS = 1;
    public static final int NUMBER_UPPER_BOUNDS = 45;
    public static final int NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public CompareResult compareWith(WinningNumbers winningNumbers) {
        CompareResult result = new CompareResult(0, false);

        for (Integer number : numbers) {
            result = winningNumbers.judgeMatchOrBonus(number, result);
        }

        return result;
    }

    public int getWinningAmount(WinningNumbers winningNumbers) {
        CompareResult compareResult = compareWith(winningNumbers);

        return Prize.toPrize(compareResult).getMoney();
    }
}
