package baseball.controller;

import baseball.model.BaseBall;
import baseball.model.BaseBallNumber;
import baseball.view.BaseBallGameView;
import nextstep.utils.Console;

public class BaseBallGameController {
	private BaseBallGameView baseBallGameView;

	public BaseBallGameController(BaseBallGameView baseBallGameView) {
		this.baseBallGameView = baseBallGameView;
	}

	public void gameStarts() {
		boolean isContinue = true;
		while (isContinue) {
			gameStart();

			String input = Console.readLine();
			isContinue = input.equals("1");
		}
	}

	private void gameStart() {
		BaseBall baseBall = BaseBall.create();

		while (!baseBall.isAnswer()) {
			baseBallGameView.printStartMessage();
			Integer playerInput = Integer.valueOf(readLineUntilValidNumber(Console.readLine()));
			baseBall.play(BaseBallNumber.valueOf(playerInput));
			baseBallGameView.printResultMessage(baseBall.getResult());
		}

		baseBallGameView.printAnswerMessage();
	}

	private String readLineUntilValidNumber(String inputStr) {
		while (!BaseBallNumber.isValidValue(inputStr)) {
			baseBallGameView.printError();
			baseBallGameView.printStartMessage();

			inputStr = Console.readLine();
		}

		return inputStr;
	}
}
