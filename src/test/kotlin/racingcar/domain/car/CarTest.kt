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
        val movedCar = car.move()
        // then
        assertThat(movedCar.getPosition()).isEqualTo(1)
    }

    @Test
    fun `stay car when the threshold is not reached`() {
        // given
        val queue = LinkedList<Int>()
        queue.add(3)
        val car = createCar(queue)
        // when
        val movedCar = car.move()
        // then
        assertThat(movedCar.getPosition()).isEqualTo(0)
    }

    private fun createCar(queue: LinkedList<Int>): Car {
        val name = Name("test")
        return Car(name, Position(), FixedNumberGenerator(queue))
    }
}
