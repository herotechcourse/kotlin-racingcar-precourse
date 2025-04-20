package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarIntegrationTest : NsTest() {
    @Test
    fun `multiple cars should move based on random values`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : --",
                    "jun : -",
                    "Winners : woni"
                )
            },
            // Round 1:
            4, 4, 4,
            // Round 2:
            3, 4, 3
        )
    }

    @Test
    fun `all cars tied should show multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains("Winners : pobi, woni, jun")
            },
            4, 4, 4
        )
    }

    override fun runMain() {
        main()
    }
}