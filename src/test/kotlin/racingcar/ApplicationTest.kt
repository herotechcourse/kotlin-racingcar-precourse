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
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `car name should not be empty`() {
        assertThrows<IllegalArgumentException> { runException(",jason", "1") }
    }

    @Test
    fun `number of cars should be more than 1`() {
        assertThrows<IllegalArgumentException> { runException("jason", "1") }
    }

    @Test
    fun `round should be an integer`() {
        assertThrows<IllegalArgumentException> { runException("ariel,jason", "not integer") }
    }

    @Test
    fun `round should be an positive integer`() {
        assertThrows<IllegalArgumentException> { runException("ariel,jason", "0") }
        assertThrows<IllegalArgumentException> { runException("ariel,jason", "-1") }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
