package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BaseBallNumberTest {
	private final static int REPEAT_TEST_COUNT = 1000;

	@Order(10)
	@Test
	void 생성() {
		BaseBallNumber result = BaseBallNumber.create();

		assertAll(
			() -> assertThat(result).isNotNull(),
			() -> assertThat(result.getValue()).isNotNull()
		);
	}

	@Order(20)
	@Test
	void 생성된_수는_세_자리수() {
		BaseBallNumber result = BaseBallNumber.create();

		assertThat(result.getValue().toString().length()).isEqualTo(3);
	}

	@Order(100)
	@RepeatedTest(REPEAT_TEST_COUNT)
	@DisplayName("생성된 수의 각 자리수는 ")
	void 생성된_수는_서로_다른_세_자리수() {
		BaseBallNumber result = BaseBallNumber.create();

		String numberToStr = result.getValue().toString();
		Set<Integer> numbers = new HashSet<>();

		numbers.add((int)numberToStr.charAt(0));
		numbers.add((int)numberToStr.charAt(1));
		numbers.add((int)numberToStr.charAt(2));

		assertThat(numbers.size()).isEqualTo(3);
	}

}