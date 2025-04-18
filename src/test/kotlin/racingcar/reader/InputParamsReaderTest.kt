package racingcar.reader

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class InputParamsReaderTest {
    private lateinit var reader: InputParamsReader

    @BeforeEach
    fun cleanReader() {
        Console.close()
        reader = InputParamsReader()
    }

    @Test
    fun `should return trimmed and validated cars`() {
        val input = "car1, car54,     Jane\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val result = reader.retrieveCarNames()

        assertThat(result).isEqualTo(listOf("car1", "car54", "Jane"))
    }

    @Test
    fun `should throw an exception on invalid car names`() {
        val input = "car1, car54412412124,     Jane\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val exception = assertThrows<IllegalArgumentException> { reader.retrieveCarNames() }

        assertThat(exception.message).isEqualTo("Car name should not exceed 5 characters")
    }

    @Test
    fun `should throw an exception on no car names`() {
        val input = " \n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val exception = assertThrows<IllegalArgumentException> { reader.retrieveCarNames() }

        assertThat(exception.message).isEqualTo("No cars were added")
    }

    @Test
    fun `should return parser rounds number`() {
        val input = "5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val result = reader.retrieveRoundsAmount()

        assertEquals(5, result)
    }

    @Test
    fun `should throw an exception on invalid rounds number`() {
        val input = "test\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val exception = assertThrows<IllegalArgumentException> { reader.retrieveRoundsAmount() }

        assertThat(exception.message).isEqualTo("Invalid input round number")
    }

    @Test
    fun `should throw an exception on negative rounds number`() {
        val input = "-1\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val exception = assertThrows<IllegalArgumentException> { reader.retrieveRoundsAmount() }

        assertThat(exception.message).isEqualTo("Number of rounds can't be less than 1")
    }

    @Test
    fun `should throw an exception on zero rounds number`() {
        val input = "0\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val exception = assertThrows<IllegalArgumentException> { reader.retrieveRoundsAmount() }

        assertThat(exception.message).isEqualTo("Number of rounds can't be less than 1")
    }
}