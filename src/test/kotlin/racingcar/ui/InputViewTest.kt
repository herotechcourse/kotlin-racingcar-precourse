package racingcar.ui

import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.lang.IllegalArgumentException

class InputViewTest {
    private lateinit var originalIn: InputStream
    @BeforeEach
    fun beforeEach() {
        originalIn = System.`in`
    }
    @AfterEach
    fun afterEach() {
        System.setIn(originalIn)
        Console.close()
    }
    private fun setInput(input:String){
        System.setIn(ByteArrayInputStream(input.toByteArray()))
    }
    @Test
    fun `car name input is valid`() {
        // given
        val input = "pobi,woni,jun,hello\n"
        setInput(input)
        val inputView = InputView()
        val cars = inputView.getCars()

        // when & then
        assertEquals(4, cars.size)
        assertEquals("hello",cars[3].carName)
    }
    @Test
    fun `car name input is only whitespace`() {
        // given
        val input = "  \n"
        setInput(input)
        val inputView = InputView()

        // when & then
        assertThrows(IllegalArgumentException::class.java){
            inputView.getCars()
        }
    }
    @Test
    fun `car name input contains only whitespace between valid names`() {
        // given
        val input = "pobi,  ,woni\n"
        setInput(input)
        val inputView = InputView()

        // when & then
        assertThrows(IllegalArgumentException::class.java){
            inputView.getCars()
        }
    }
    @Test
    fun `car name input is multiple whitespace`() {
        // given
        val input = " ,   , \n"
        setInput(input)
        val inputView = InputView()

        // when & then
        assertThrows(IllegalArgumentException::class.java){
            inputView.getCars()
        }
    }

    @Test
    fun `car name input is null`() {
        // given
        val input = "\n"
        setInput(input)
        val inputView = InputView()

        // when & then
        assertThrows(IllegalArgumentException::class.java){
            inputView.getCars()
        }
    }

    @Test
    fun `car name input exceeds limits`() {
        // given
        val input = "hello,hello2\n"
        setInput(input)
        val inputView = InputView()

        // when & then
        assertThrows(IllegalArgumentException::class.java){
            inputView.getCars()
        }
    }
    @Test
    fun `attempt input is valid number`() {
        // given
        val input = "5\n"
        setInput(input)
        val inputView = InputView()

        // when
        val attempts = inputView.getAttempts()

        // then
        assertEquals(5, attempts)
    }

    @Test
    fun `attempt input is not a number`() {
        // given
        val input = "five\n"
        setInput(input)
        val inputView = InputView()

        // when & then
        assertThrows(IllegalArgumentException::class.java){
            inputView.getAttempts()
        }
    }

    @Test
    fun `attempt input is blank`() {
        // given
        val input = "\n"
        setInput(input)
        val inputView = InputView()

        // when & then
        assertThrows(IllegalArgumentException::class.java){
            inputView.getAttempts()
        }
    }

    @Test
    fun `attempt input is negative number`() {
        // given
        val input = "-3\n"
        setInput(input)
        val inputView = InputView()

        // when & then
        assertThrows(IllegalArgumentException::class.java){
            inputView.getAttempts()
        }
    }
}