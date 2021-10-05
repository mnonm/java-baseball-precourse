package baseball.controller;

import baseball.model.BaseBall;
import baseball.model.BaseBallNumber;
import baseball.model.result.BaseBallResult;
import baseball.view.BaseBallGameView;
import nextstep.utils.Console;

public class BaseBallGameController {
	private BaseBallGameView baseBallGameView;

	public BaseBallGameController(BaseBallGameView baseBallGameView) {
		this.baseBallGameView = baseBallGameView;
	}

	public void gameStart() {
		BaseBall baseBall = BaseBall.create();

		baseBallGameView.printStartMessage();
		Integer playerInput = Integer.valueOf(Console.readLine());

		BaseBallResult result = baseBall.play(BaseBallNumber.valueOf(playerInput));
		baseBallGameView.printResultMessage(result);
	}

}
