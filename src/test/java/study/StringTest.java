package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void string_split_test1() {
		String str = "1,2";

		String[] result = str.split(",");

		assertThat(result).contains("1", "2");
	}

	@Test
	void string_split_test2() {
		String str = "1";

		String[] result = str.split(",");

		assertThat(result).containsExactly("1");
	}

	@Test
	void substring_test() {
		String str = "(1,2)";

		String result = str.substring(1, str.length() - 1);

		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("chatAt 함수 테스트")
	void chatAt_test1() {
		String str = "abc";

		assertAll(
			() -> assertEquals('a', str.charAt(0)),
			() -> assertEquals('b', str.charAt(1)),
			() -> assertEquals('c', str.charAt(2))
		);
	}

	@Test
	@DisplayName("chatAt 함수의 인자가 문자열 길이를 넘는 경우 IndexOutOfBound 예외 발생")
	void chatAt_IndexOutOfBound_test() {
		String str = "abc";

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> str.charAt(3));
	}
}
