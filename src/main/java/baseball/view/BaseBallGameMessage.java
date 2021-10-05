package baseball.view;

public enum BaseBallGameMessage {
	START("숫자를 입력해주세요 : "),
	STRIKE("%d 스트라이크 "),
	BALL("%d 볼"),
	NOTHING("낫싱");

	private final String text;

	BaseBallGameMessage(String msg) {
		this.text = msg;
	}

	public String getText() {
		return text;
	}
}
