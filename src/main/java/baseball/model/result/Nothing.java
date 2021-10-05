package baseball.model.result;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.model.BaseBallNumber;

public class Nothing {
	private boolean value;

	public static Nothing of(BaseBallNumber answerNumber, BaseBallNumber playerNumber) {
		Set<Integer> answerNumberSet = new HashSet<>(answerNumber.toDigitList());
		List<Integer> playerNumbers = playerNumber.toDigitList();

		boolean isNotContainAnyNumber = true;
		for (Integer number : playerNumbers) {
			isNotContainAnyNumber = isNotContainAnyNumber && !answerNumberSet.contains(number);
		}

		return new Nothing(isNotContainAnyNumber);
	}

	private Nothing(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}
}
