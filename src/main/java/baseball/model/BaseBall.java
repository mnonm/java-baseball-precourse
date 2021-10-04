package baseball.model;

public class BaseBall {
	private BaseBallNumber answerNumber;

	private BaseBall(BaseBallNumber answerNumber) {
		this.answerNumber = answerNumber;
	}

	public static BaseBall create() {
		return new BaseBall(BaseBallNumber.create());
	}
}
