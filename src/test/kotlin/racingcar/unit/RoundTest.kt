package racingcar.unit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Round

class RoundTest {
    @Nested
    @DisplayName("constructor")
    inner class ConstructorTest {

        @Test
        fun `should create round with valid index`() {
            val cars = Cars(listOf(Car("p1"), Car("p2")))
            val round = Round(1, cars)
            assertThat(round.index).isEqualTo(1)
            assertThat(round.cars).isEqualTo(cars)
        }

        @Test
        fun `should throw exception if index is zero or less`() {
            val cars = Cars(listOf(Car("p1")))
            val exception = assertThrows<IllegalArgumentException> {
                Round(0, cars)
            }
            assertThat(exception.message).isEqualTo("Round index must be a positive number.")
        }
    }

    @Nested
    @DisplayName("winners")
    inner class WinnersTest {

        @Test
        fun `should return car with highest position`() {
            val round = Round(
                2,
                Cars(listOf(
                    Car("p1", position = 1),
                    Car("p2", position = 3),
                    Car("p3", position = 3)
                )))

            val winners = round.winners.getCarNames()
            assertThat(winners).containsExactlyInAnyOrder("p2", "p3")
        }
    }

    @Nested
    @DisplayName("toString")
    inner class ToStringTest {

        @Test
        fun `should return race progress string`() {
            val cars = Cars(
                listOf(
                    Car("p1", position = 2),
                    Car("p2", position = 0),
                    Car("p3", position = 3)
                )
            )
            val round = Round(1, cars)
            val output = round.toString()

            assertThat(output).isEqualTo(
                """
                p1 : --
                p2 : 
                p3 : ---
                """.trimIndent() + "\n"
            )
        }
    }
}
