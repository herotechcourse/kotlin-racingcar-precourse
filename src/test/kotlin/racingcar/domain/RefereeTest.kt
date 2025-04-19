package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.domain.car.Position
import racingcar.domain.numberGenerator.FixedNumberGenerator
import java.util.*

class RefereeTest {

    @Test
    fun `determine the winner when there is only one winner`() {
        // given
        val queueForCarA = LinkedList<Int>()
        queueForCarA.add(1)

        val queueForCarB = LinkedList<Int>()
        queueForCarB.add(8)

        val car1 = createCar("a", queueForCarA)
        val car2 = createCar("b", queueForCarB)

        val cars = Cars(listOf(car1, car2))
        val movedCars = cars.moveAll()

        val referee = Referee(movedCars)
        // when
        val winner = referee.determineWinner()
        // then
        assertThat(winner.first()).isEqualTo("b")
    }

    @Test
    fun `determine the winners when there are multiple winners`() {
        // given
        val queueForCarA = LinkedList<Int>()
        queueForCarA.add(5)

        val queueForCarB = LinkedList<Int>()
        queueForCarB.add(8)

        val car1 = createCar("a", queueForCarA)
        val car2 = createCar("b", queueForCarB)

        val cars = Cars(listOf(car1, car2))
        val movedCars = cars.moveAll()

        val referee = Referee(movedCars)
        // when
        val winner = referee.determineWinner()
        // then
        assertAll(
            { assertThat(winner).hasSize(2) },
            { assertThat(winner.containsAll(listOf("a", "b"))) }
        )
    }

    private fun createCar(name: String, queue: LinkedList<Int>): Car {
        return Car(Name(name), Position(), FixedNumberGenerator(queue))
    }
}
