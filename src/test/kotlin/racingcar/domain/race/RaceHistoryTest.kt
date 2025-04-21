package racingcar.domain.race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.domain.car.Position
import racingcar.domain.numberGenerator.FixedNumberGenerator

class RaceHistoryTest {

    private lateinit var raceHistory: RaceHistory

    @BeforeEach
    fun setUp() {
        raceHistory = RaceHistory()
    }

    @Test
    fun `should record round in history`() {
        // given
        val car1 = createCar("a", mutableListOf(0))
        val car2 = createCar("b", mutableListOf(8))
        val cars = Cars(listOf(car1, car2))
        // when
        raceHistory.recordRound(cars)
        // then
        assertThat(raceHistory.getAllRound()).hasSize(1)
    }

    @Test
    fun `should get race result after race ends`() {
        // given
        val car1 = createCar("a", mutableListOf(0))
        val car2 = createCar("b", mutableListOf(8))
        val movedCars = Cars(listOf(car1, car2))
        raceHistory.recordRound(movedCars)
        // when
        val raceResult = raceHistory.getRaceResult()
        // then
        assertThat(raceResult.raceCompletedCars).isEqualTo(movedCars)
    }

    private fun createCar(name: String, numbers: MutableList<Int>): Car {
        return Car(Name(name), Position(), FixedNumberGenerator(numbers))
    }
}
