package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.domain.numberGenerator.FixedNumberGenerator
import java.util.*

class CarsTest {

    @Test
    fun `throw exception when the total number of cars is less than range`() {
        // given
        val cars = listOf(Car(Name("test")))
        // when & then
        assertThatThrownBy { Cars(cars) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Total number of cars range must be between ${MIN_SIZE} and ${MAX_SIZE}.")
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
            .hasMessage("[ERROR] Total number of cars range must be between ${MIN_SIZE} and ${MAX_SIZE}.")
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
        val queueForCarA = LinkedList<Int>()
        queueForCarA.add(3)

        val queueForCarB = LinkedList<Int>()
        queueForCarB.add(4)

        val car1 = createCar("a", queueForCarA)
        val car2 = createCar("b", queueForCarB)

        val cars = Cars(listOf(car1, car2))
        // when
        cars.moveCar()
        // then
        assertAll(
            { assertThat(cars.cars.first().getPosition()).isEqualTo(0) },
            { assertThat(cars.cars.last().getPosition()).isEqualTo(1) }
        )
    }

    @Test
    fun `determine winner when winner is only one`() {
        // given
        val queueForCarA = LinkedList<Int>()
        queueForCarA.add(1)

        val queueForCarB = LinkedList<Int>()
        queueForCarB.add(8)

        val car1 = createCar("a", queueForCarA)
        val car2 = createCar("b", queueForCarB)

        val cars = Cars(listOf(car1, car2))
        cars.moveCar()
        // when
        val winner = cars.drawWinner()
        // then
        assertThat(winner.first()).isEqualTo("b")
    }

    @Test
    fun `determine winner when winner is multiple`() {
        // given
        val queueForCarA = LinkedList<Int>()
        queueForCarA.add(5)

        val queueForCarB = LinkedList<Int>()
        queueForCarB.add(8)

        val car1 = createCar("a", queueForCarA)
        val car2 = createCar("b", queueForCarB)

        val cars = Cars(listOf(car1, car2))
        cars.moveCar()
        // when
        val winner = cars.drawWinner()
        // then
        assertAll(
            { assertThat(winner).hasSize(2) },
            { assertThat(winner.containsAll(listOf("a", "b"))) }
        )
    }

    private fun createCar(name: String, queue: LinkedList<Int>): Car {
        return Car(Name(name), 0, FixedNumberGenerator(queue))
    }

    companion object {
        private const val MIN_SIZE: Int = 2
        private const val MAX_SIZE: Int = 20
    }
}
