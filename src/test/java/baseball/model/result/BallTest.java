package baseball.model.result;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.model.BaseBallNumber;

class BallTest {
	@Test
	void 숫자가_모두_포함된_경우() {
		Ball ball = Ball.countOf(BaseBallNumber.valueOf(523), BaseBallNumber.valueOf(352));

		assertThat(ball.getCount()).isEqualTo(3);
	}

	@Test
	void 숫자가_두개만_포함된_경우() {
		Ball ball = Ball.countOf(BaseBallNumber.valueOf(487), BaseBallNumber.valueOf(758));

		assertThat(ball.getCount()).isEqualTo(2);
	}

	@Test
	void 숫자가_한개만_포함된_경우() {
		Ball ball = Ball.countOf(BaseBallNumber.valueOf(459), BaseBallNumber.valueOf(235));

		assertThat(ball.getCount()).isEqualTo(1);
	}

	@Test
	void 숫자가_같은_자리에_포함된_경우1() {
		Ball ball = Ball.countOf(BaseBallNumber.valueOf(459), BaseBallNumber.valueOf(459));

		assertThat(ball.getCount()).isEqualTo(0);
	}

	@Test
	void 숫자가_같은_자리에_포함된_경우2() {
		Ball ball = Ball.countOf(BaseBallNumber.valueOf(459), BaseBallNumber.valueOf(549));

		assertThat(ball.getCount()).isEqualTo(2);
	}
}