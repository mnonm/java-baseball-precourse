package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class BaseBallNumber {
	public static final String THREE_DIGIT_NUMBERS_PATTERN = "^[1-9]{3}$";

	private Integer value;

	public static BaseBallNumber create() {
		int firstDigit = Randoms.pickNumberInRange(1, 9);
		int secondDigit = createNumberExcept(new HashSet<>(Arrays.asList(firstDigit)));
		int thirdDigit = createNumberExcept(new HashSet<>(Arrays.asList(firstDigit, secondDigit)));

		int value = firstDigit * 100 + secondDigit * 10 + thirdDigit;

		return new BaseBallNumber(value);

	}

	public static BaseBallNumber valueOf(Integer value) {
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

	/**
	 * idx 0 : 100의 자리수
	 * idx 1 : 10의 자리수
	 * idx 2 : 1의 자리수
	 */
	public List<Integer> toDigitList() {
		char[] chars = this.value.toString().toCharArray();

		List<Integer> numbers = new ArrayList<>();
		for (char integerChar : chars) {
			numbers.add(Character.getNumericValue(integerChar));
		}

		return numbers;
	}

	public static boolean isValidValue(String inputStr) {
		return isThreeDigitNumbers(inputStr) && isUniqueEachNumber(inputStr);
	}

	private static boolean isThreeDigitNumbers(String inputStr) {
		return inputStr.matches(THREE_DIGIT_NUMBERS_PATTERN);
	}

	private static boolean isUniqueEachNumber(String inputStr) {
		String[] numberArray = inputStr.split("");
		Set<String> numberSets = new HashSet<>(Arrays.asList(numberArray));

		return numberSets.size() == 3;
	}
}
