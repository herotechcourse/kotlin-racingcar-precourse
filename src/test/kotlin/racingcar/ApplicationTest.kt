package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            // Name validation tests
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            assertThrows<IllegalArgumentException> { runException(",woni", "1") }
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
            assertThrows<IllegalArgumentException> { runException("pobi woni", "1") }

            // Round validation tests
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }

        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
