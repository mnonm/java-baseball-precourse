package baseball.model.result;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.model.BaseBallNumber;

class NothingTest {
	@Test
	void 같은_숫자가_하나도_없는_경우() {
		Nothing result = Nothing.of(BaseBallNumber.valueOf(123), BaseBallNumber.valueOf(456));

		assertThat(result.getValue()).isTrue();
	}

	@Test
	void 같은_숫자가_포함된_경우1() {
		Nothing result = Nothing.of(BaseBallNumber.valueOf(124), BaseBallNumber.valueOf(456));

		assertThat(result.getValue()).isFalse();
	}

	@Test
	void 같은_숫자가_포함된_경우2() {
		Nothing result = Nothing.of(BaseBallNumber.valueOf(124), BaseBallNumber.valueOf(456));

		assertThat(result.getValue()).isFalse();
	}

	@Test
	void 숫자가_전부_일치하는_경우() {
		Nothing result = Nothing.of(BaseBallNumber.valueOf(456), BaseBallNumber.valueOf(456));

		assertThat(result.getValue()).isFalse();
	}
}