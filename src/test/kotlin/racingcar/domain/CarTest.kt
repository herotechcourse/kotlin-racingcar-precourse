package racingcar.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `The car move forward when number is greater than or equal to 4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("ksy")
                car.move()
                assertThat(car.position).isEqualTo(1)
            },
            4
        )
    }

    @Test
    fun `the car stop when number is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("ksy")
                car.move()
                assertThat(car.position).isEqualTo(0)
            },
            3
        )
    }
}
