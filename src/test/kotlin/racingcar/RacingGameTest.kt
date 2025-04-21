package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingTest : NsTest() {

    @Test
    fun `should print race result and winners correctly for a normal case`() {
        assertRandomNumberInRangeTest(
            {
                CarRacing.race(listOf(Car("pobi"), Car("woni"), Car("jun")), 1)
                val result = output()

                assertThat(result).contains("Race Results")
                assertThat(result).contains("pobi : -")
                assertThat(result).contains("woni :")
                assertThat(result).contains("jun : -")
                assertThat(result).contains("Winners : pobi, jun")
            },
            4, 3, 5
        )
    }


    @Test
    fun `should run race and determine a single winner`() {
        assertRandomNumberInRangeTest(
            {
                CarRacing.race(listOf(Car("pobi"), Car("woni")), 1)
                val result = output()

                assertThat(result).contains("pobi : -")
                assertThat(result).contains("woni :")
                assertThat(result).contains("Winners : pobi")
            },
            4, 2
        )
    }

    @Test
    fun `should run race and determine multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                CarRacing.race(listOf(Car("pobi"), Car("woni"), Car("jun")), 1)
                val result = output()

                assertThat(result).contains("pobi : -")
                assertThat(result).contains("woni : -")
                assertThat(result).contains("jun :")
                assertThat(result).contains("Winners : pobi, woni")
            },
            5, 4, 2
        )
    }

    override fun runMain() {
    }
}
