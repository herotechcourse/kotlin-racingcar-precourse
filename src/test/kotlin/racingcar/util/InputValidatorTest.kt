package racingcar.util

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    // Car Name Validation

    @Test
    @DisplayName("given valid names when validateCarName then does not throw")
    fun `given valid names when validateCarName then does not throw`() {
        // given
        val names = listOf("pobi", "java", "kim")

        // when & then
        assertDoesNotThrow { InputValidator.validateCarName(names) }
    }

    @Test
    @DisplayName("given name longer than five characters when validateCarName then throws IllegalArgumentException")
    fun `given name longer than five characters when validateCarName then throws IllegalArgumentException`() {
        // given
        val names = listOf("tooLongName")

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(names) }
    }

    @Test
    @DisplayName("given blank name when validateCarName then throws IllegalArgumentException")
    fun `given blank name when validateCarName then throws IllegalArgumentException`() {
        // given
        val names = listOf("pobi", "", "jun")

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(names) }
    }

    @Test
    @DisplayName("given duplicate names when validateCarName then throws IllegalArgumentException")
    fun `given duplicate names when validateCarName then throws IllegalArgumentException`() {
        // given
        val names = listOf("pobi", "java", "pobi")

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(names) }
    }

    @Test
    @DisplayName("given name with surrounding whitespace when validateCarName then throws IllegalArgumentException")
    fun `given name with surrounding whitespace when validateCarName then throws IllegalArgumentException`() {
        // given
        val names = listOf(" pobi", "jun")

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(names) }
    }

    @Test
    @DisplayName("given empty name list when validateCarName then throws IllegalArgumentException")
    fun `given empty name list when validateCarName then throws IllegalArgumentException`() {
        // given
        val names = emptyList<String>()

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(names) }
    }


    // Rounds Validation

    @Test
    @DisplayName("given valid numeric string when validateRounds then returns parsed integer")
    fun `given valid numeric string when validateRounds then returns parsed integer`() {
        // given
        val input = "5"

        // when
        val result = InputValidator.validateRounds(input)

        // then
        assertEquals(5, result)
    }

    @Test
    @DisplayName("given non-numeric string when validateRounds then throws IllegalArgumentException")
    fun `given non-numeric string when validateRounds then throws IllegalArgumentException`() {
        // given
        val input = "three"

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateRounds(input) }
    }

    @Test
    @DisplayName("given decimal number string when validateRounds then throws IllegalArgumentException")
    fun `given decimal number string when validateRounds then throws IllegalArgumentException`() {
        // given
        val input = "3.5"

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateRounds(input) }
    }

    @Test
    @DisplayName("given zero or negative number when validateRounds then throws IllegalArgumentException")
    fun `given zero or negative number when validateRounds then throws IllegalArgumentException`() {
        // given
        val input = "-1"

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateRounds(input) }
    }

    @Test
    @DisplayName("given blank input when validateRounds then throws IllegalArgumentException")
    fun `given blank input when validateRounds then throws IllegalArgumentException`() {
        // given
        val input = "   "

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator.validateRounds(input) }
    }
}
