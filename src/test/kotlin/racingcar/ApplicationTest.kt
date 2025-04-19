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
    fun `spaces test`() {
        assertRandomNumberInRangeTest(
            {
                run("dina   ,pobi    ,woni", "3")
                assertThat( output()).contains("dina : ", "pobi : ", "woni : ")
            },STOP,STOP
        )
    }

    @Test
    fun `Tie case`() {
        assertRandomNumberInRangeTest(
            {
                run("dina, pobi", "1")
                assertThat(output()).contains("dina : -", "pobi : -", "Winners : pobi, dina")

            },
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `non valid number`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("dina, pobi", "x") }
        }
    }

    @Test
    fun `empty car name`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("  ,   ", "3") }
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
