package baseball.model.result;

import java.util.List;

import baseball.model.BaseBallNumber;

public class Strike {
	private Integer count;

	private Strike(Integer count) {
		this.count = count;
	}

	public static Strike countOf(BaseBallNumber answerNumber, BaseBallNumber playerNumber) {
		List<Integer> answerNumbers = answerNumber.toDigitList();
		List<Integer> playerNumbers = playerNumber.toDigitList();

		int count = 0;
		for (int i = 0; i < 3; i++) {
			count += addOneIfEquals(answerNumbers.get(i), playerNumbers.get(i));
		}

		return new Strike(count);
	}

	private static int addOneIfEquals(Integer first, Integer second) {
		return first.equals(second) ? 1 : 0;
	}

	public Integer getCount() {
		return count;
	}
}
