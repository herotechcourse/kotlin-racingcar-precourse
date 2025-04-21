package racingcar.domain.race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.domain.car.Position
import racingcar.domain.numberGenerator.FixedNumberGenerator

class RaceTest {

    @Test
    fun `should get result after play race`() {
        // given
        val round = Round(3)

        val car = createCar("a", mutableListOf(0, 1, 5))
        val winnerCar = createCar("b", mutableListOf(8, 5, 6))
        val cars = Cars(listOf(car, winnerCar))

        val race = Race(round, cars)
        // when
        val raceResult = race.play()
        // then
        val raceCompletedCars = raceResult.raceCompletedCars.cars
        assertAll(
            { assertThat(raceCompletedCars.first().getName()).isEqualTo("a") },
            { assertThat(raceCompletedCars.first().getPosition()).isEqualTo(1) },
            { assertThat(raceCompletedCars.last().getName()).isEqualTo("b") },
            { assertThat(raceCompletedCars.last().getPosition()).isEqualTo(3) },
        )
    }

    private fun createCar(name: String, numbers: MutableList<Int>): Car {
        return Car(Name(name), Position(), FixedNumberGenerator(numbers))
    }
}
