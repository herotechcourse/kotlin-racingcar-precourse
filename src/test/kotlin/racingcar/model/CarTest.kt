package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("testCar")
    }

    @Test
    @DisplayName("Test creating a car with a name")
    fun createCarWithNameTest() {
        assertThat(car.getName()).isEqualTo("testCar")
        assertThat(car.getMoveCount()).isEqualTo(0)
    }

    @Test
    @DisplayName("Test increasing the number of car moves")
    fun raiseMoveCountTest() {
        car.raiseMoveCount()
        car.raiseMoveCount()

        assertThat(car.getMoveCount()).isEqualTo(2)
    }

    @Test
    @DisplayName("Test that the car moves if random number allows")
    fun moveIfPossibleTest() {
        assertRandomNumberInRangeTest(
            {
                car.moveIfPossible()
                assertThat(car.getMoveCount()).isEqualTo(1)
            }, 4
        )
    }
}
