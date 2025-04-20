package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `car name should not exceed 5 characters`() {
        assertThatThrownBy { Car("abcdef") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name must not be blank and must be 5 characters or fewer.")
    }

    @Test
    fun `car moves forward if random number is 4 or more`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("pobi")
                car.move()
                assertThat(car.position).isEqualTo(1)
            },
            4
        )
    }

    @Test
    fun `car does not move if random number is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("pobi")
                car.move()
                assertThat(car.position).isEqualTo(0)
            },
            3
        )
    }
}
