package racingcar.io

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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

}