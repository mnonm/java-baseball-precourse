package baseball.view;

import baseball.model.result.BaseBallResult;

public class BaseBallGameView {

	public void printStartMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void printResultMessage(BaseBallResult result) {
		printStrikeMessageIfHasStrike(result);
		printBallMessageIfHasBall(result);
		printNothingIfNothing(result);
		System.out.println();
	}

	private void printStrikeMessageIfHasStrike(BaseBallResult result) {
		if (result.hasStrike()) {
			System.out.printf("%d 스트라이크 ", result.getStrikeCount());
		}
	}

	private void printBallMessageIfHasBall(BaseBallResult result) {
		if (result.hasBall()) {
			System.out.printf("%d 볼", result.getBallCount());
		}
	}

	private void printNothingIfNothing(BaseBallResult result) {
		if (result.isNothing()) {
			System.out.println("낫싱");
		}
	}
}
