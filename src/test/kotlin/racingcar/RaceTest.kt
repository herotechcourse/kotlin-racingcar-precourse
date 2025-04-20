package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.NsTest

class RaceTest : NsTest() {
    @Test
    fun `should start race and display positions`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                val race = Race(listOf(car), 1)
                race.start()
                assertThat(output()).contains("test : ----")
            }, 4
        )
    }

    @Test
    fun `should display winners`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                val race = Race(listOf(car), 1)
                race.start()
                race.displayWinners()
                assertThat(output()).contains("test : ----", "Winners : test")
            }, 4
        )
    }

    override fun runMain() {
    }
}