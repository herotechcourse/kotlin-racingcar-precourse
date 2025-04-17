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
    fun `car names must be unique`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
            assertThat(exception.message).contains("Car names must be unique")
        }
    }

    @Test
    fun `multiple duplicate car names are detected`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("a,b,a,c,b", "1") }
            assertThat(exception.message).contains("Car names must be unique")
        }
    }

    @Test
    fun `similar car names are treated as different`() {
        assertSimpleTest {
            run("Pobi,pobi", "1")
            assertThat(output()).contains("Pobi :", "pobi :")
        }
    }

    @Test
    fun `rounds must be a valid number`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "abc") }
            assertThat(exception.message).contains("Input must be a valid number")
        }
    }

    @Test
    fun `rounds must be positive`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
            assertThat(exception.message).contains("Rounds must be a positive number")
        }
    }

    @Test
    fun `tie results in multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("Winners :")
            },
            MOVING_FORWARD, // Both cars move forward
            MOVING_FORWARD
        )
    }

    @Test
    fun `car name too long test`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,toolong", "1") }
            assertThat(exception.message).contains("must be between 1 and 5 chars")
        }
    }

    @Test
    fun `empty input test`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("", "1") }
            assertThat(exception.message).contains("Input is empty")
        }
    }

    @Test
    fun `whitespace only car name test`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi, ", "1") }
            assertThat(exception.message).contains("must be between 1 and 5 chars")
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
