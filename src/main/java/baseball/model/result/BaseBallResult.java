package baseball.model.result;

import baseball.model.BaseBallNumber;

public class BaseBallResult {
	private Strike strike;
	private Ball ball;
	private Nothing nothing;

	private BaseBallResult(Strike strike, Ball ball, Nothing nothing) {
		this.strike = strike;
		this.ball = ball;
		this.nothing = nothing;
	}

	public static BaseBallResult of(BaseBallNumber answerNumber, BaseBallNumber playerNumber) {
		Strike strike = Strike.countOf(answerNumber, playerNumber);
		Ball ball = Ball.countOf(answerNumber, playerNumber);
		Nothing nothing = Nothing.of(answerNumber, playerNumber);

		return new BaseBallResult(strike, ball, nothing);
	}

	public Integer getStrikeCount() {
		return this.strike.getCount();
	}

	public Integer getBallCount() {
		return this.ball.getCount();
	}

	public boolean isNothing() {
		return this.nothing.getValue();
	}
}
