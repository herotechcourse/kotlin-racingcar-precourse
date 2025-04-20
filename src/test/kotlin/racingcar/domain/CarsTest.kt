package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.domain.car.Position
import racingcar.domain.numberGenerator.FixedNumberGenerator

class CarsTest {

    @Test
    fun `throw exception when the total number of cars is less than range`() {
        // given
        val cars = listOf(Car(Name("test")))
        // when & then
        assertThatThrownBy { Cars(cars) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Total number of cars range must be between $MIN_SIZE and $MAX_SIZE.")
    }

    @Test
    fun `throw exception when the total number of cars exceeds range`() {
        // given
        val names = listOf(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"
        )
        val cars = names.map { Car(Name(it)) }
            .toList()
        // when & then
        assertThatThrownBy { Cars(cars) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Total number of cars range must be between $MIN_SIZE and $MAX_SIZE.")
    }

    @Test
    fun `throw exception if any name is duplicated`() {
        // given
        val name = Name("test")
        val cars = listOf(Car(name), Car(name))
        // when & then
        assertThatThrownBy { Cars(cars) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Car names are duplicated.")
    }

    @Test
    fun `move cars based on threshold`() {
        // given
        val car1 = createCar("a", mutableListOf(3))
        val car2 = createCar("b", mutableListOf(4))

        val cars = Cars(listOf(car1, car2))
        // when
        cars.moveAll()
        // then
        assertAll(
            { assertThat(cars.cars.first().getPosition()).isEqualTo(0) },
            { assertThat(cars.cars.last().getPosition()).isEqualTo(1) }
        )
    }

    @Test
    fun `should return max position after cars move`() {
        // given
        val car1 = createCar("a", mutableListOf(1))
        val car2 = createCar("b", mutableListOf(8))

        val cars = Cars(listOf(car1, car2))
        cars.moveAll()
        // when
        val maxPosition = cars.getMaxPosition()
        // then
        assertThat(maxPosition).isEqualTo(1)
    }

    @Test
    fun `should find the cars at the specified position`() {
        // given
        val car1 = createCar("a", mutableListOf(5))
        val car2 = createCar("b", mutableListOf(8))

        val cars = Cars(listOf(car1, car2))
        cars.moveAll()
        // when
        val maxPosition = 1
        val carsAtMaxPosition = cars.findAllAtPosition(maxPosition)
        // then
        val carNames = carsAtMaxPosition.map { it.getName() }
        assertAll(
            { assertThat(carsAtMaxPosition).hasSize(2) },
            { assertThat(carNames.containsAll(listOf("a", "b"))) }
        )
    }

    private fun createCar(name: String, numbers: MutableList<Int>): Car {
        return Car(Name(name), Position(), FixedNumberGenerator(numbers))
    }

    companion object {
        private const val MIN_SIZE: Int = 2
        private const val MAX_SIZE: Int = 20
    }
}
