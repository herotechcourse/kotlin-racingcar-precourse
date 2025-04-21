package racingcar.presentation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarNameParserTest {

    @Test
    fun `parseCarNames should split and trim whitespace`() {
        // given
        val rawInput = " pobi , woni,jun"

        // when
        val names = CarNameParser.parse(rawInput)

        // then
        assertThat(names).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `parseCarNames on empty string returns empty name`() {
        // given
        val rawInput = ""

        // when
        val names = CarNameParser.parse(rawInput)

        // then
        assertThat(names).containsExactly("")
    }
}
