package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.domain.car.Position
import racingcar.domain.numberGenerator.FixedNumberGenerator
import racingcar.domain.race.Cars
import racingcar.domain.race.RaceResult

class RefereeTest {

    @Test
    fun `determine the winner when there is only one winner`() {
        // given
        val car1 = createCar("a", mutableListOf(1))
        val car2 = createCar("b", mutableListOf(8))

        val referee = createRefereeWithCars(car1, car2)
        // when
        val winner = referee.determineWinner()
        // then
        assertThat(winner.first()).isEqualTo("b")
    }

    @Test
    fun `determine the winners when there are multiple winners`() {
        // given
        val car1 = createCar("a", mutableListOf(5))
        val car2 = createCar("b", mutableListOf(8))

        val referee = createRefereeWithCars(car1, car2)
        // when
        val winner = referee.determineWinner()
        // then
        assertAll(
            { assertThat(winner).hasSize(2) },
            { assertThat(winner.containsAll(listOf("a", "b"))) }
        )
    }

    private fun createCar(name: String, numbers: MutableList<Int>): Car {
        return Car(Name(name), Position(), FixedNumberGenerator(numbers))
    }

    private fun createRefereeWithCars(car1: Car, car2: Car): Referee {
        val cars = Cars(listOf(car1, car2))
        val raceCompletedCars = cars.moveAll()
        val raceResult = RaceResult(raceCompletedCars)

        val referee = Referee(raceResult)
        return referee
    }
}
