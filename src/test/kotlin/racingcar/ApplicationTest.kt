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
    fun `does not move if random number is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : ", "woni : " )
            },
            STOP,
            STOP
        )
    }

    @Test
    fun `moves if random number is greater than 4`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -" )
            },
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `prints all winners when there are multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,noni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "noni : -", "Winners : pobi, woni, noni")
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `adds numbering to duplicated names`() {
        val input = listOf("aaa", "bbb", "aaa", "bbb", "ccc", "aaa")
        val expected = listOf("aaa", "bbb", "aaa(2)", "bbb(2)", "ccc", "aaa(3)")
        val result = input.withUniqueNames()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `throws exception when car name exceeds 5 characters`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `throws exception when car name is blank`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, , java", "1") }
        }
    }

    @Test
    fun `throws exception when round number is 0`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, , java", "0") }
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
