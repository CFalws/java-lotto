package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> regularNumbers;
    private final int bonusNumber;
    public WinningNumbers(List<Integer> regularNumbers, int bonusNumber) {
        this.regularNumbers = regularNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumber(int number) {
        return regularNumbers.contains(number);
    }
}
