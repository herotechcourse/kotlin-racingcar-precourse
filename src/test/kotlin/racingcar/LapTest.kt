package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.NsTest

class LapTest : NsTest() {
    @Test
    fun `should run laps`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                val lap = Lap(listOf(car))
                lap.runLap()
                assertThat(car.position).isEqualTo(4)
            }, 4
        )
    }

    @Test
    fun `should display positions`() {
        assertRandomNumberInRangeTest(
            {
                val car1 = Car("test1")
                val car2 = Car("test2")
                val lap = Lap(listOf(car1, car2))
                lap.runLap()
                lap.displayPositions()
                assertThat(output()).contains("test1 : ------", "test2 : ------")
            }, 6
        )
    }

    override fun runMain() {
    }
}