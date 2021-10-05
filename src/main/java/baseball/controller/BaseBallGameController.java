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

	public void gameStart() {
		BaseBall baseBall = BaseBall.create();

		while (!baseBall.isAnswer()) {
			baseBallGameView.printStartMessage();
			Integer playerInput = Integer.valueOf(Console.readLine());
			baseBall.play(BaseBallNumber.valueOf(playerInput));
			baseBallGameView.printResultMessage(baseBall.getResult());
		}
	}

}
