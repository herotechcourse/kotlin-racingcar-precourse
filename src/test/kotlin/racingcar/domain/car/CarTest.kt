package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.numberGenerator.FixedNumberGenerator

class CarTest {

    @Test
    fun `move car when the threshold is reached`() {
        // given
        val car = createCar(mutableListOf(4))
        // when
        val movedCar = car.move()
        // then
        assertThat(movedCar.getPosition()).isEqualTo(1)
    }

    @Test
    fun `stay car when the threshold is not reached`() {
        // given
        val car = createCar(mutableListOf(3))
        // when
        val movedCar = car.move()
        // then
        assertThat(movedCar.getPosition()).isEqualTo(0)
    }

    @Test
    fun `recognize as the same car if names are the same`() {
        // given
        val car1 = createCar(mutableListOf(3))
        val car2 = createCar(mutableListOf(5))
        // when & then
        assertAll(
            { assertThat(car1).isEqualTo(car2) },
            { assertThat(car1.hashCode()).isEqualTo(car2.hashCode()) }
        )
    }

    private fun createCar(numbers: MutableList<Int>): Car {
        val name = Name("test")
        return Car(name, Position(), FixedNumberGenerator(numbers))
    }
}
