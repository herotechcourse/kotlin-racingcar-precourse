package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {

    private lateinit var cars: Cars

    @BeforeEach
    fun setUp() {
        val car1 = Car("car1", 3)
        val car2 = Car("car2", 5)
        val car3 = Car("car3", 5)
        cars = Cars(listOf(car1, car2, car3))
    }

    @Test
    @DisplayName("Test creating Cars object from car name list")
    fun ofTest() {
        val carNames = listOf("carA", "carB", "carC")

        val cars = Cars.of(carNames)

        assertThat(cars.getCars().size).isEqualTo(3)
        assertThat(cars.getCars()[0].getName()).isEqualTo("carA")
        assertThat(cars.getCars()[1].getName()).isEqualTo("carB")
        assertThat(cars.getCars()[2].getName()).isEqualTo("carC")
    }

    @Test
    @DisplayName("Test finding cars by specific move count")
    fun findCarsByMoveCountTest() {
        val result = cars.findCarsByMoveCount(5)

        assertThat(result.getCars().size).isEqualTo(2)
        assertThat(result.getCars().map { it.getName()}).containsExactly("car2", "car3")
    }

    @Test
    @DisplayName("Test getting car list from Cars object")
    fun getCarsTest() {
        val carList = cars.getCars()

        assertThat(carList.size).isEqualTo(3)
        assertThat(carList.map { it.getName()}).containsExactly("car1", "car2", "car3")
    }
}
