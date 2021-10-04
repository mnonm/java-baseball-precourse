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
		baseBallGameView.printStartMessage();
		Integer playerInput = Integer.valueOf(Console.readLine());
		BaseBallNumber playerNumber = BaseBallNumber.valueOf(playerInput);
	}

}
