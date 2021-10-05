package baseball.view;

public enum BaseBallGameMessage {
	START("숫자를 입력해주세요 : "),
	STRIKE("%d스트라이크 "),
	BALL("%d볼"),
	NOTHING("낫싱"),
	ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
	CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	private final String text;

	BaseBallGameMessage(String msg) {
		this.text = msg;
	}

	public String getText() {
		return text;
	}
}
