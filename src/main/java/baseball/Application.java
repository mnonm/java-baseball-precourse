package baseball;

import baseball.controller.BaseBallGameController;
import baseball.view.BaseBallGameView;

public class Application {
	public static void main(String[] args) {
		BaseBallGameController baseBallGameController = new BaseBallGameController(new BaseBallGameView());
        baseBallGameController.gameStart();
	}
}
