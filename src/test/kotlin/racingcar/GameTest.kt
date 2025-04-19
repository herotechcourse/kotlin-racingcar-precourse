package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `play returns correct winners with mock generator`() {
        val names = listOf("pobi", "jun")
        val rounds = 3
        val generator = NumberGenerator { 6 } // force always move

        val winners = Game.play(names, rounds, generator)

        assertThat(winners).containsExactly("pobi", "jun")
    }
    @Test
    fun `car wins by only moving when number is greater than or equal to 4`() {
        val names = listOf("pobi")
        val generator = NumberGenerator { 4 } // minimum threshold to move
        val winners = Game.play(names, 2, generator)

        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `car does not move when number is always less than 4`() {
        val names = listOf("jun")
        val generator = NumberGenerator { 3 } // always below threshold
        val winners = Game.play(names, 3, generator)

        assertThat(winners).containsExactly("jun")

    }
    @Test
    fun `race with empty car list throws exception`() {
        val generator = NumberGenerator { 5 }

        assertThatThrownBy {
            Game.play(emptyList(), 3, generator)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

}
