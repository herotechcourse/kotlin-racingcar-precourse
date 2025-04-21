package racingcar.domain.race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.domain.car.Position
import racingcar.domain.numberGenerator.FixedNumberGenerator

class RaceResultTest {

    @Test
    fun `should find cars at max position`() {
        // given
        val car = createCar("a", mutableListOf(0))
        val maxPositionCar = createCar("b", mutableListOf(8))
        val cars = Cars(listOf(car, maxPositionCar))

        val raceCompletedCars = cars.moveAll()
        val raceResult = RaceResult(raceCompletedCars)
        // when
        val carsAtMaxPosition = raceResult.findCarsAtMaxPosition()
        // then
        assertAll(
            { assertThat(carsAtMaxPosition.size).isEqualTo(1) },
            { assertThat(carsAtMaxPosition.containsAll(listOf(maxPositionCar))) }
        )
    }

    private fun createCar(name: String, numbers: MutableList<Int>): Car {
        return Car(Name(name), Position(), FixedNumberGenerator(numbers))
    }
}
