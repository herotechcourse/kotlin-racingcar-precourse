package racingcar.unit

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Cars

class CarsTest {
    @Nested
    @DisplayName("constructor")
    inner class ConstructorTest {

        @Test
        fun `should create Cars with unique car names`() {
            val cars = Cars(listOf(Car("p1"), Car("p2"), Car("p3")))
            assertThat(cars.getCarNames()).containsExactly("p1", "p2", "p3")
        }

        @Test
        fun `should throw exception if car names are duplicated`() {
            val exception = assertThrows<IllegalArgumentException> {
                Cars(listOf(Car("p1"), Car("p1")))
            }
            assertThat(exception.message).isEqualTo("Car names must be unique.")
        }
    }

    @Nested
    @DisplayName("moveRandomly()")
    inner class MoveRandomlyTest {

        @Test
        fun `should move each car if random number is greater than or equal 4`() {
            val cars = Cars(listOf(Car("p1"), Car("p2")))

            assertRandomNumberInRangeTest({
                val moved = cars.moveRandomly()
                assertThat(moved).allMatch { it.position == 1 }
            }, 4, 5)
        }

        @Test
        fun `should not move cars if random number is less than 4`() {
            val cars = Cars(listOf(Car("p1"), Car("p2")))

            assertRandomNumberInRangeTest({
                val moved = cars.moveRandomly()
                assertThat(moved).allMatch { it.position == 0 }
            }, 1, 2)
        }
    }

    @Nested
    @DisplayName("getMostMovedCar()")
    inner class GetMostMovedCarTest {

        @Test
        fun `should return cars with the highest position`() {
            val cars = Cars(listOf(
                Car("p1", position = 1),
                Car("p2", position = 3),
                Car("p3", position = 3)
            ))
            val winners = cars.getMostMovedCar()

            assertThat(winners.getCarNames()).containsExactlyInAnyOrder("p2", "p3")
        }
    }

    @Nested
    @DisplayName("createRound()")
    inner class CreateRoundTest {
        @Test
        fun `should create a round with deep copied cars`() {
            // given
            val rawCars = listOf(Car("p1"), Car("p2"))
            val cars = Cars(rawCars)

            // when
            val round = cars.createRound(1)

            // then
            assertThat(round.cars).isNotSameAs(cars)
        }
    }
}
