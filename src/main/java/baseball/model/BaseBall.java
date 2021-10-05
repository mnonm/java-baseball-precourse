package baseball.model;

import baseball.model.result.BaseBallResult;

public class BaseBall {
	private BaseBallNumber answerNumber;
	private BaseBallResult result;

	private BaseBall(BaseBallNumber answerNumber) {
		this.answerNumber = answerNumber;
	}

	public static BaseBall create() {
		return new BaseBall(BaseBallNumber.create());
	}

	public void play(BaseBallNumber playerNumber) {
		this.result = BaseBallResult.of(answerNumber, playerNumber);
	}

	public boolean isAnswer() {
		return this.result != null && this.result.isThreeStrike();
	}

	public BaseBallResult getResult() {
		return this.result;
	}
}
