package nextstep.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomsTest {

	@Test
	void 시작_끝_같은_경우() {
		int result = Randoms.pickNumberInRange(1, 1);

		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("1에서 9사이의 숫자를 생성")
	void 시작_끝_사이의_값_생성() {
		int result = Randoms.pickNumberInRange(1, 9);

		assertThat(result)
			.isGreaterThanOrEqualTo(1)
			.isLessThanOrEqualTo(9);
	}

	@Test
	@DisplayName("시작값이 끝 보다 큰 경우 IllegalArgumentException 발생")
	void 시작이_끝_보다_큰_경우() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(5, 1))
			.withMessage("startInclusive가 endInclusive보다 클 수 없습니다.");
	}

	@Test
	@DisplayName("끝 값이 Integer.MAX_VALUE 인 경우 IllegalArgumentException 발생")
	void 끝_값이_INTEGER_MAX_경우() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(0, Integer.MAX_VALUE))
			.withMessage("끝값이 너무 큽니다. (스택 오버플로우 발생이 가능합니다)");
	}

	@Test
	@DisplayName("시작과 끝 값의 차이가 Integer.MAX_VALUE 이상인 경우")
	void 시작_끝_차이가_INTEGER_MAX_이상인_경우() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(-1, Integer.MAX_VALUE - 1))
			.withMessage("입력값이 너무 큽니다.");
	}
}