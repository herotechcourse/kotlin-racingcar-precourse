package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.numberGenerator.FixedNumberGenerator
import java.util.*

class CarTest {

    @Test
    fun `move car when the threshold is reached`() {
        // given
        val queue = LinkedList<Int>()
        queue.add(4)
        val car = createCar(queue)
        // when
        car.move()
        // then
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `stay car when the threshold is not reached`() {
        // given
        val queue = LinkedList<Int>()
        queue.add(3)
        val car = createCar(queue)
        // when
        car.move()
        // then
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `recognize as the same object if names are the same`() {
        // given
        val queue = LinkedList<Int>()
        val car1 = createCar(queue)
        val car2 = createCar(queue)
        // when & then
        assertThat(car1).isEqualTo(car2)
        assertThat(car1.hashCode()).isEqualTo(car2.hashCode())
    }

    private fun createCar(queue: LinkedList<Int>): Car {
        val name = Name("test")
        return Car(name, Position(), FixedNumberGenerator(queue))
    }
}
