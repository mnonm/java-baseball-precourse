package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class BaseBallNumber {
	private Integer value;

	public static BaseBallNumber create() {
		int firstDigit = Randoms.pickNumberInRange(1, 9);
		int secondDigit = createNumberExcept(new HashSet<>(Arrays.asList(firstDigit)));
		int thirdDigit = createNumberExcept(new HashSet<>(Arrays.asList(firstDigit, secondDigit)));

		int value = firstDigit * 100 + secondDigit * 10 + thirdDigit;

		return new BaseBallNumber(value);

	}

	private BaseBallNumber(Integer value) {
		this.value = value;
	}

	private static int createNumberExcept(Set<Integer> exceptNumbers) {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		while (exceptNumbers.contains(randomNumber)) {
			randomNumber = Randoms.pickNumberInRange(1, 9);
		}
		return randomNumber;
	}

	public Integer getValue() {
		return value;
	}
}
