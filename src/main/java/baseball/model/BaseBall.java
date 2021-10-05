package baseball.model;

import baseball.model.result.BaseBallResult;

public class BaseBall {
	private BaseBallNumber answerNumber;

	private BaseBall(BaseBallNumber answerNumber) {
		this.answerNumber = answerNumber;
	}

	public static BaseBall create() {
		return new BaseBall(BaseBallNumber.create());
	}

	public BaseBallResult play(BaseBallNumber playerNumber) {
		return BaseBallResult.of(answerNumber, playerNumber);
	}
}
