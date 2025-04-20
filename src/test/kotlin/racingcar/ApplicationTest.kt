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
    fun `check total round is integer`() {
        assertSimpleTest {
            // no of is integer and not string
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "a") }
        }
    }

    @Test
    fun `check total round is within integer range`() {
        assertSimpleTest {
            // no of is integer < Int.Max_size
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "10000000000000000000") }
        }
    }



    @Test
    fun `dont allow duplicate car names`() {
        assertSimpleTest {
            // no of rounds >= 1
            assertThrows<IllegalArgumentException> { runException("pobi,Pobi") }
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
