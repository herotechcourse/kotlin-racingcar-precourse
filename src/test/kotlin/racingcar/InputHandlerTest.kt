package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class InputHandlerTest {

    @Test
    fun `valid car names are parsed correctly`() {
        val result = InputHandler.parseCarNames("pobi,woni,jun")
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `invalid car names throw exception`() {
        assertThatThrownBy { InputHandler.parseCarNames("pobi,wonilong,jun") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `valid round count is parsed correctly`() {
        val result = InputHandler.parseRoundCount("5")
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `invalid round count throws exception`() {
        assertThatThrownBy { InputHandler.parseRoundCount("zero") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
