package racingcar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameLogicTest {

    private fun setupCars(): MutableMap<String, String> {
        return mutableMapOf("car1" to "-", "car2" to "", "car3" to "-")
    }

    @Test
    fun `should increment car position when number is 4`() {
        val cars = setupCars()
        val car = cars.entries.find { it.key == "car1" }
        moveCars(cars, car!!, 4)

        assertThat(car.value).isEqualTo("--")
    }

    @Test
    fun `should increment car position when number is higher than 4`() {
        val cars = setupCars()
        val car = cars.entries.find { it.key == "car1" }
        moveCars(cars, car!!, 5)

        assertThat(car.value).isEqualTo("--")
    }

    @Test
    fun `should not increment car position when number is less than 4`() {
        val cars = setupCars()
        val car = cars.entries.find { it.key == "car1" }
        moveCars(cars, car!!, 3)

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