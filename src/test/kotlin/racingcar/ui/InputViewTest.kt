package racingcar.ui

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.lang.IllegalArgumentException

class InputViewTest {
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
}