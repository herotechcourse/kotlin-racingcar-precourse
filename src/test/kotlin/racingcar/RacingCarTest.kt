package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.RacingCar

class RacingCarTest {
    private lateinit var car: RacingCar

    @BeforeEach
    fun setUp() {
        car = RacingCar("winie")
    }

    @ParameterizedTest(name = "Car should NOT move when number is {0}")
    @ValueSource(ints = [0, 1, 2, 3])
    fun `car does not move when random number is less than 4`(number : Int) {
        car.moveForward(number)
        assertThat(car.pos).isEqualTo(0)
    }

    @ParameterizedTest(name = "Car Should move when number is greater than {4}")
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `car does move when random number is 4 or greater`(number : Int) {
        car.moveForward(number)
        assertThat(car.pos).isEqualTo(1)
    }
}
