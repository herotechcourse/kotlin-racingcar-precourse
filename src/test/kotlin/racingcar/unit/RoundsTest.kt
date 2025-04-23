package racingcar.unit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Round
import racingcar.domain.Rounds

class RoundsTest {

    @Nested
    @DisplayName("getWinners()")
    inner class GetWinnersTest {

        @Test
        fun `should return winners from the last round`() {
            val round1 = Round(1, Cars(listOf(Car("a", 1), Car("b", 2))))
            val round2 = Round(2, Cars(listOf(Car("a", 3), Car("b", 3), Car("c", 2))))

            val rounds = Rounds(mutableListOf(round1, round2))
            val winners = rounds.getWinners().getCarNames()

            assertThat(winners).containsExactlyInAnyOrder("a", "b")
        }
    }

    @Nested
    @DisplayName("toString()")
    inner class ToStringTest {

        @Test
        fun `should return combined string of all rounds`() {
            val round1 = Round(1, Cars(mutableListOf(Car("a", 1), Car("b", 2))))
            val round2 = Round(2, Cars(mutableListOf(Car("a", 3), Car("b", 3))))

            val rounds = Rounds(mutableListOf(round1, round2))
            val output = rounds.toString()

            assertThat(output).isEqualTo(
                """
                a : -
                b : --
                
                a : ---
                b : ---
                
                
                """.trimIndent()
            )
        }
    }

    @Nested
    @DisplayName("add()")
    inner class AddTest {

        @Test
        fun `should add a round to the rounds list`() {
            val rounds = Rounds()
            val round = Round(1, Cars(mutableListOf(Car("a", 1), Car("b", 2))))

            rounds.add(round)

            assertThat(rounds.toList()).containsExactly(round)
        }

        @Test
        fun `should add multiple rounds to the rounds list`() {
            val rounds = Rounds()
            val round1 = Round(1, Cars(mutableListOf(Car("a", 1), Car("b", 2))))
            val round2 = Round(2, Cars(mutableListOf(Car("c", 3), Car("d", 4))))

            rounds.add(round1)
            rounds.add(round2)

            assertThat(rounds.toList()).containsExactly(round1, round2)
        }
    }
}
