package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow

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
    fun `input with duplicate car names throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }

    @Test
    fun `input with less than two car names throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi", "1") }
        }
    }

    @Test
    fun `rounds input with non-numeric characters throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "five") }
        }
    }

    @Test
    fun `rounds input with zero throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `rounds input with negative number throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-3") }
        }
    }

    @Test
    fun `valid car names and valid rounds run successfully`() {
        assertSimpleTest {
            assertDoesNotThrow { run("pobi,woni", "5") }
        }
    }

    @Test
    fun `valid multiple car names and rounds run successfully`() {
        assertSimpleTest {
            assertDoesNotThrow { run("pobi,woni,jun,alex", "3") }
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
