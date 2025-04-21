package racingcar.input

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorRoundTest {

	@Test
	fun `should accept valid round number`() {
		assertThat(InputValidator.validateRound(5)).isEqualTo(5)
	}

	@Test
	fun `should fail when round is zero`() {
		val exception = assertThrows<IllegalArgumentException> {
			InputValidator.validateRound(0)
		}
		assertThat(exception.message).contains("at least")
	}
}