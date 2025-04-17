package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `TEST1 feature test`() {
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
    fun `TEST2 multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,lori", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "Winners : pobi, woni")
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
        )
    }

    @Test
    fun `TEST3 no winner`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : ", "woni : ", "Winners : none")
            },
            STOP,
            STOP,
        )
    }

    @Test
    fun `TEST4 one player`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "1")
                assertThat(output()).contains("pobi : ", "Winners : pobi")
            },
            MOVING_FORWARD,
        )
    }


    @Test
    fun `TEST5 too long name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `TEST6 white space`() {
        assertSimpleTest {
            run("pobi , woni", "1")
            assertThat(output()).contains("pobi : ", "woni : ")   
        }
    }


    @Test
    fun `TEST7 empty input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\n") }
        }
    }

    @Test
    fun `TEST8 duplicate names`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi ,woni,pobi", "1") }
        }
    }

    @Test
    fun `TEST9 invalid round number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi , woni", "0") }
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
