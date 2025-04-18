package racingcar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameLogicTest {

    private fun setupCars(): MutableMap<String, String> {
        return mutableMapOf("car1" to "-", "car2" to "", "car3" to "-")
    }

    @ParameterizedTest
    @ValueSource(ints = [ 4, 5, 6, 7, 8, 9])
    fun `should increment car position when number is 4 or higher`(n: Int) {
        val cars = setupCars()
        val car = cars.entries.find { it.key == "car1" }
        moveCars(cars, car!!, n)

        assertThat(car.value).isEqualTo("--")
    }

    @ParameterizedTest
    @ValueSource(ints = [ 0, 1, 2, 3])
    fun `should not increment car position when number is less than 4`(n: Int) {
        val cars = setupCars()
        val car = cars.entries.find { it.key == "car1" }
        moveCars(cars, car!!, n)

        assertThat(car.value).isEqualTo("-")
    }

    @Test
    fun `should determine winners correctly`() {
        val cars = setupCars()
        val winners = getWinners(cars)
        assertThat(winners.keys).containsExactlyInAnyOrder("car1", "car3")
    }

    @Test
    fun `should handle no car movement`() {
        val cars = mutableMapOf("car1" to "", "car2" to "", "car3" to "")
        val winners = getWinners(cars)

        assertThat(winners.keys).containsExactlyInAnyOrder("car1", "car2", "car3")
    }
}