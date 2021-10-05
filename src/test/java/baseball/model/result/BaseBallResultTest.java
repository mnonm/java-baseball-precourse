package baseball.model.result;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.model.BaseBallNumber;

class BaseBallResultTest {

	@Test
	void 모든_숫자가_위치까지_동일한_경우() {
		BaseBallNumber answerNumber = BaseBallNumber.valueOf(579);
		BaseBallNumber playerNumber = BaseBallNumber.valueOf(579);

		BaseBallResult result = BaseBallResult.of(answerNumber, playerNumber);

		assertAll(
			() -> assertThat(result.getStrikeCount()).isEqualTo(3),
			() -> assertThat(result.getBallCount()).isEqualTo(0),
			() -> assertThat(result.isNothing()).isFalse()
		);
	}

	@Test
	void 모든_숫자가_포함됐지만_위치가_다른_경우() {
		BaseBallNumber answerNumber = BaseBallNumber.valueOf(123);
		BaseBallNumber playerNumber = BaseBallNumber.valueOf(312);

		BaseBallResult result = BaseBallResult.of(answerNumber, playerNumber);

		assertAll(
			() -> assertThat(result.getStrikeCount()).isEqualTo(0),
			() -> assertThat(result.getBallCount()).isEqualTo(3),
			() -> assertThat(result.isNothing()).isFalse()
		);
	}

	@Test
	void 숫자_1개_위치_같고_2개_포함된_경우() {
		BaseBallNumber answerNumber = BaseBallNumber.valueOf(123);
		BaseBallNumber playerNumber = BaseBallNumber.valueOf(132);

		BaseBallResult result = BaseBallResult.of(answerNumber, playerNumber);

		assertAll(
			() -> assertThat(result.getStrikeCount()).isEqualTo(1),
			() -> assertThat(result.getBallCount()).isEqualTo(2),
			() -> assertThat(result.isNothing()).isFalse()
		);
	}

	@Test
	void 일치하거나_포함하는_숫자가_하나도_없는_경우_낫싱() {
		BaseBallNumber answerNumber = BaseBallNumber.valueOf(123);
		BaseBallNumber playerNumber = BaseBallNumber.valueOf(789);

		BaseBallResult result = BaseBallResult.of(answerNumber, playerNumber);

		assertAll(
			() -> assertThat(result.getStrikeCount()).isEqualTo(0),
			() -> assertThat(result.getBallCount()).isEqualTo(0),
			() -> assertThat(result.isNothing()).isTrue()
		);
	}

	@Test
	void 숫자_1개_위치_같은_경우() {
		BaseBallNumber answerNumber = BaseBallNumber.valueOf(123);
		BaseBallNumber playerNumber = BaseBallNumber.valueOf(526);

		BaseBallResult result = BaseBallResult.of(answerNumber, playerNumber);

		assertAll(
			() -> assertThat(result.getStrikeCount()).isEqualTo(1),
			() -> assertThat(result.getBallCount()).isEqualTo(0),
			() -> assertThat(result.isNothing()).isFalse()
		);
	}

	@Test
	void 숫자_2개_포함하는_경우() {
		BaseBallNumber answerNumber = BaseBallNumber.valueOf(123);
		BaseBallNumber playerNumber = BaseBallNumber.valueOf(316);

		BaseBallResult result = BaseBallResult.of(answerNumber, playerNumber);

		assertAll(
			() -> assertThat(result.getStrikeCount()).isEqualTo(0),
			() -> assertThat(result.getBallCount()).isEqualTo(2),
			() -> assertThat(result.isNothing()).isFalse()
		);
	}
}