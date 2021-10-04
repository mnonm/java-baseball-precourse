package baseball.model.result;

import java.util.List;

import baseball.model.BaseBallNumber;

public class Ball {
	private Integer count;

	private Ball(Integer count) {
		this.count = count;
	}

	public static Ball countOf(BaseBallNumber answerNumber, BaseBallNumber playerNumber) {
		List<Integer> answerNumbers = answerNumber.toDigitList();
		List<Integer> playerNumbers = playerNumber.toDigitList();

		int count = 0;
		for (int i = 0; i < 3; i++) {
			count += addOneIfContainExceptEqualsIndex(answerNumbers, playerNumbers.get(i), i);
		}

		return new Ball(count);
	}

	private static int addOneIfContainExceptEqualsIndex(List<Integer> answerNumbers, Integer number, int exceptIdx) {
		if (!answerNumbers.contains(number)) {
			return 0;
		}

		return addOneIfNotEquals(answerNumbers.get(exceptIdx), number);
	}

	private static int addOneIfNotEquals(Integer first, Integer second) {
		return !first.equals(second) ? 1 : 0;
	}

	public Integer getCount() {
		return count;
	}
}
