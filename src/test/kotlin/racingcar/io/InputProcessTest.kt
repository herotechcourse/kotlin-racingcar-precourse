package racingcar.io


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream
import java.io.InputStream
import camp.nextstep.edu.missionutils.Console

class InputProcessTest {

    private lateinit var inputProcess: InputProcess
    private val originalIn = System.`in`

    @BeforeEach
    fun setUp() {
        inputProcess = InputProcess()
        Console.close()
    }

    private fun setInput(input: String) {
        val inputStream: InputStream = ByteArrayInputStream((input + "\n").toByteArray())
        System.setIn(inputStream)
    }

    @Test
    fun `processCarName should split comma-separated names`() {

        val input = "chang,deok,seo"
        setInput(input)

        val names = inputProcess.processCarName()

        assertThat(names).containsExactly("chang", "deok", "seo")
    }

    @Test
    fun `processCarName should trim whitespace from names`() {

        val input = "chang , deok , seo"
        setInput(input)

        val names = inputProcess.processCarName()

        assertThat(names).containsExactly("chang", "deok", "seo")
    }

    @Test
    fun `processCarName should throw exception for empty name`() {

        val input = "chang,,,seo"
        setInput(input)

        assertThrows<IllegalArgumentException> { inputProcess.processCarName() }
    }

    @Test
    fun `processCarName should throw exception for name longer than 5 characters`() {

        val input = "chang,gunhawk,seo"
        setInput(input)

        assertThrows<IllegalArgumentException> { inputProcess.processCarName() }
    }

    @Test
    fun `processRoundNumber should return valid integer`() {

        val input = "20"
        setInput(input)

        val rounds = inputProcess.processRoundNumber()

        assertThat(rounds).isEqualTo(20)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-123","-5231","123.421", "abc","500000000000", ""])
    fun `processRoundNumber should throw exception for invalid input`(invalidInput: String) {

        setInput(invalidInput)

        assertThrows<IllegalArgumentException> { inputProcess.processRoundNumber() }
    }

    @Test
    fun `validateEmptyString should throw exception for empty string`() {

        assertThrows<IllegalArgumentException> { inputProcess.validateEmptyString("", "Test") }
    }

    @Test
    fun `validateEmptyString should not throw exception for non-empty string`() {

        inputProcess.validateEmptyString("test", "Test")
    }

    @Test
    fun `validateCarNameLength should throw exception for name longer than 5 characters`() {

        assertThrows<IllegalArgumentException> { inputProcess.validateCarNameLength("toolong") }
    }

    @Test
    fun `validateCarNameLength should not throw exception for name with 5 or fewer characters`() {

        inputProcess.validateCarNameLength("Seo")
        inputProcess.validateCarNameLength("12345")
    }
}