package racingcar
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {

    private fun iterateInputs(inputs: List<String>, function: (String) -> Unit) {
        for (input in inputs) {
            assertThrows<IllegalArgumentException> { function(input) }
        }
    }

    @Test
    fun `shout throw IllegalArgumentException if input is blank`() {
        val inputs = listOf("     ", "", " ", "\t", "\n", "         ")
        iterateInputs(inputs, ::checkBlank)
    }

    @Test
    fun `shout throw IllegalArgumentException if input contains invalid characters`() {
        val inputs = listOf("boni,lucia,paul#", "mario paulo jose", "pedro.eva", "ana!,mari")
        iterateInputs(inputs, ::checkInvalidChars)
    }

    @Test
    fun `shout throw IllegalArgumentException if input is not correctly separated by commas`() {
        val inputs = listOf("bmwaudivw", "bmw,audi,,vw", "bmw,audi,vw,")
        iterateInputs(inputs, ::checkCommas)
    }

    @Test
    fun `shout throw IllegalArgumentException if input is longer than 5 characters`() {
        val input = "hotwheels"
        assertThrows<IllegalArgumentException> { checkLength(input) }
    }

    @Test
    fun `shout throw IllegalArgumentException if input contains duplicates`() {
        val inputs = listOf("ana,mari,pedro,mari", "bmw,audi,audi")
        iterateInputs(inputs, ::checkDuplicates)
    }

    @Test
    fun `should throw IllegalArgumentException if input does not contain only digits`() {
        val inputs = listOf("banana", "10$", "1million", "three", "#25")
        iterateInputs(inputs, ::checkDigits)
    }

    @Test
    fun `should throw IllegalArgumentException if input is 0, negative or higher than 10000`() {
        val inputs = listOf("${Int.MAX_VALUE}", "-1", "0", "1000000", "10001")
        iterateInputs(inputs, ::checkLimits)
    }
}