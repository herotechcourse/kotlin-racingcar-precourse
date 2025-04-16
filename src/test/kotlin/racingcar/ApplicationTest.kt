package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    // Disabling test for now
    
    // @Test
    // fun `feature test`() {
    //     assertRandomNumberInRangeTest(
    //         {
    //             run("pobi,woni", "1")
    //             assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
    //         },
    //         MOVING_FORWARD,
    //         STOP,
    //     )
    // }

    // @Test
    // fun `exception test`() {
    //     assertSimpleTest {
    //         assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
    //     }
    // }

    // Car names test
    @Test
    fun `car name input test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,won", "1")
                assertThat(output()).contains("pobi : -", "won : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP
        )
    }

    @Test
    fun `car name length test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `car name empty test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,", "1") }
        }
    }

    // Rounds input test
    @Test
    fun `round number input test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,won", "0") }
        }
    }

    @Test
    fun `round number negative test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,won", "-1") }
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
