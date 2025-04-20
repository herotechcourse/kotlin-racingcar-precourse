package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `feature test one winner`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni :", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `feature test multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "Winners : pobi, woni")
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
        )
    }

    // Copy of test

    @Test
    fun `feature test empty name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,", "3") }
        }
    }

    @Test
    fun `feature test same name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,wani,pobi", "3") }
        }
    }

    @Test
    fun `feature test captical letter name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,wani,Pobi", "3") }
        }
    }

    @Test
    fun `feature test non positive round number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,wani", "0") }
        }
    }

    @Test
    fun `feature test wrong round format`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,wani", "three") }
        }
    }

    @Test
    fun `feature test lenght of car name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
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
