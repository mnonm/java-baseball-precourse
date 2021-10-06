package baseball.controller;

import baseball.model.BaseBall;
import baseball.model.BaseBallNumber;
import baseball.view.BaseBallGameView;
import nextstep.utils.Console;

public class BaseBallGameController {
	public static final String CONTINUE_GAME = "1";
	public static final String END_GAME = "2";

	private BaseBallGameView baseBallGameView;

	public BaseBallGameController(BaseBallGameView baseBallGameView) {
		this.baseBallGameView = baseBallGameView;
	}

	public void gameStarts() {
		boolean isContinue = true;
		while (isContinue) {
			gameStart();

			String isContinueStr = readLineUntilValidInputForContinue();
			isContinue = isContinueStr.equals(CONTINUE_GAME);
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
			baseBallGameView.printErrorForInputNumber();
			baseBallGameView.printStartMessage();

			inputStr = Console.readLine();
		}

		return inputStr;
	}

	private String readLineUntilValidInputForContinue() {
		String input = Console.readLine();
		while (!(input.equals(CONTINUE_GAME) || input.equals(END_GAME))) {
			baseBallGameView.printErrorForInputContinue();
			input = Console.readLine();
		}

		return input;
	}
}
