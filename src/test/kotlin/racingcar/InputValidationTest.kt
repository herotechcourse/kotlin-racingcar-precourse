package racingcar
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["     ", "", " ", "\t", "\n", "         ", ""])
    fun `shout throw IllegalArgumentException if input is blank`(input: String) {
        assertThrows<IllegalArgumentException> { checkBlank(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["boni,lucia,paul#", "mario paulo jose", "pedro.eva", "ana!,mari"])
    fun `shout throw IllegalArgumentException if input contains invalid characters`(input: String) {
        assertThrows<IllegalArgumentException> { checkInvalidChars(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["bmwaudivw", "bmw,audi,,vw", "bmw,audi,vw,"])
    fun `shout throw IllegalArgumentException if input is not correctly separated by commas`(input: String) {
        assertThrows<IllegalArgumentException> { checkCommas(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["hotwheels", "mercedes", "ferrari", "fusquinha"])
    fun `shout throw IllegalArgumentException if input is longer than 5 characters`(input: String) {
        assertThrows<IllegalArgumentException> { checkLength(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["ana,mari,pedro,mari", "bmw,audi,audi"])
    fun `shout throw IllegalArgumentException if input contains duplicates`(input: String) {
        assertThrows<IllegalArgumentException> { checkDuplicates(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["banana", "10$", "1million", "three", "#25"])
    fun `should throw IllegalArgumentException if input does not contain only digits`(input: String) {
        assertThrows<IllegalArgumentException> { checkDigits(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["${Int.MAX_VALUE}", "-1", "0", "1000000", "10001"])
    fun `should throw IllegalArgumentException if input is 0, negative or higher than 10000`(input: String) {
        assertThrows<IllegalArgumentException> { checkLimits(input) }
    }
}