package racingcar.input

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorNameTest {

	@Test
	fun `should fail when name is blank`() {
		val exception = assertThrows<IllegalArgumentException> {
			InputValidator.validateNames(listOf("   "))
		}
		assertThat(exception.message).contains("cannot be blank")
	}

	@Test
	fun `should fail when name is empty string`() {
		val exception = assertThrows<IllegalArgumentException> {
			InputValidator.validateNames(listOf(""))
		}
		assertThat(exception.message).contains("cannot be empty")
	}

	@Test
	fun `should fail when name exceeds max length`() {
		val exception = assertThrows<IllegalArgumentException> {
			InputValidator.validateNames(listOf("superlongname"))
		}
		assertThat(exception.message).contains("5 characters or fewer")
	}

	@Test
	fun `should fail when name has non-alphanumeric characters`() {
		val exception = assertThrows<IllegalArgumentException> {
			InputValidator.validateNames(listOf("!!"))
		}
		assertThat(exception.message).contains("only contain letters and numbers")
	}

	@Test
	fun `should fail when names are duplicated ignoring case`() {
		val exception = assertThrows<IllegalArgumentException> {
			InputValidator.validateNames(listOf("guri", "GURI"))
		}
		assertThat(exception.message).contains("Duplicate car names")
	}

	@Test
	fun `should pass with valid names`() {
		val names = listOf("Hi", "cu1e", "guri")
		val result = InputValidator.validateNames(names)
		assertThat(result).containsExactlyElementsOf(names)
	}
}