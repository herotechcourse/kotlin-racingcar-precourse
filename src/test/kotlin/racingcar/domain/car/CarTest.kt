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
        queue.offer(4)
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
        queue.offer(3)
        val car = createCar(queue)
        // when
        car.move()
        // then
        assertThat(car.getPosition()).isEqualTo(0)
    }

    private fun createCar(queue: LinkedList<Int>): Car {
        val name = Name("test")
        val position = 0

        return Car(name, position, FixedNumberGenerator(queue))
    }
}
