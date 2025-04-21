package racingcar.input

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class RaceInputHandlerTest {

    @Test
    fun `parseCarNames splits and trims input`() {
        val raw = "  foo , bar,baz  "
        val names = RaceInputHandler.parseCarNames(raw)
        assertThat(names).containsExactly("foo", "bar", "baz")
    }

    @Test
    fun `validateCarNames rejects less than two cars`() {
        val ex = assertThrows<IllegalArgumentException> {
            RaceInputHandler.validateCarNames("solo")
        }
        assertThat(ex.message).contains("At least two cars")
    }

    @Test
    fun `validateCarNames rejects duplicate names`() {
        val ex = assertThrows<IllegalArgumentException> {
            RaceInputHandler.validateCarNames("a,b,a")
        }
        assertThat(ex.message).contains("Identity crisis")
    }

    @Test
    fun `createRace rejects non‑numeric rounds`() {
        val ex = assertThrows<IllegalArgumentException> {
            RaceInputHandler.createRace("a,b", "abc")
        }
        assertThat(ex.message).contains("positive integer")
    }

    @Test
    fun `createRace rejects zero or negative rounds`() {
        val ex = assertThrows<IllegalArgumentException> {
            RaceInputHandler.createRace("a,b", "0")
        }
        assertThat(ex.message).contains("positive integer")
    }
}