package baseball.model.result;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.model.BaseBallNumber;

class StrikeTest {
	@Test
	void 각_자리수의_숫자가_모두_같은_경우() {
		Strike strike = Strike.countOf(BaseBallNumber.valueOf(456), BaseBallNumber.valueOf(456));

		assertThat(strike.getCount()).isEqualTo(3);
	}

	@Test
	void 각_자리수의_숫자가_두개만_같은_경우() {
		Strike strike = Strike.countOf(BaseBallNumber.valueOf(542), BaseBallNumber.valueOf(562));

		assertThat(strike.getCount()).isEqualTo(2);
	}

	@Test
	void 각_자리수의_숫자가_하나만_같은_경우() {
		Strike strike = Strike.countOf(BaseBallNumber.valueOf(542), BaseBallNumber.valueOf(762));

		assertThat(strike.getCount()).isEqualTo(1);
	}

	@Test
	void 각_자리수가_모두_다른_경우() {
		Strike strike = Strike.countOf(BaseBallNumber.valueOf(542), BaseBallNumber.valueOf(254));

		assertThat(strike.getCount()).isEqualTo(0);
	}
}