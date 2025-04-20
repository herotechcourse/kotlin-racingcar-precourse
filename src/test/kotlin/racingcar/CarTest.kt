package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.NsTest

class CarTest : NsTest() {
    @Test
    fun `should move car forward if random position is 4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                car.moveForward()
                assertThat(car.position).isEqualTo(4)
            }, 4
        )
    }

    @Test
    fun `should move car forward if random position is greater than 4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                car.moveForward()
                assertThat(car.position).isEqualTo(5)
            }, 5
        )
    }

    @Test
    fun `should not move car forward if random position is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                car.moveForward()
                assertThat(car.position).isEqualTo(0)
            }, 3
        )
    }

    @Test
    fun `should display position`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                car.moveForward()
                car.displayPosition()
                assertThat(output()).contains("test : ------")
            }, 6
        )
    }

    override fun runMain() {
    }
}