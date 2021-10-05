package baseball.view;

import static baseball.view.BaseBallGameMessage.*;

import baseball.model.result.BaseBallResult;

public class BaseBallGameView {

	public void printStartMessage() {
		System.out.print(START.getText());
	}

	public void printResultMessage(BaseBallResult result) {
		printStrikeMessageIfHasStrike(result);
		printBallMessageIfHasBall(result);
		printNothingIfNothing(result);
		System.out.println();
	}

	private void printStrikeMessageIfHasStrike(BaseBallResult result) {
		if (result.hasStrike()) {
			System.out.printf(STRIKE.getText(), result.getStrikeCount());
		}
	}

	private void printBallMessageIfHasBall(BaseBallResult result) {
		if (result.hasBall()) {
			System.out.printf(BALL.getText(), result.getBallCount());
		}
	}

	private void printNothingIfNothing(BaseBallResult result) {
		if (result.isNothing()) {
			System.out.println(NOTHING.getText());
		}
	}

	public void printAnswerMessage() {
		System.out.println(ANSWER.getText());
		System.out.println(CONTINUE.getText());
	}
}
