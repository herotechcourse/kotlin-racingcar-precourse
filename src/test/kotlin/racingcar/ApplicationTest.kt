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
    fun `exception test - name too long`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    // ✅ NEW TEST CASES

    @Test
    fun `all cars move in one round - multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                run("car1,car2", "1")
                assertThat(output()).contains("car1 : -", "car2 : -", "Winners : car1, car2")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `car moves multiple rounds - longer output`() {
        assertRandomNumberInRangeTest(
            {
                run("zoom", "3")
                assertThat(output()).contains("zoom : -", "zoom : --", "zoom : ---", "Winners : zoom")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `round input is not a number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "abc") }
        }
    }

    @Test
    fun `round input is zero`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `car name is blank`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, ,jun", "3") }
        }
    }

    @Test
    fun `empty input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "3") }
        }
    }

    @Test
    fun `names with whitespace but valid`() {
        assertRandomNumberInRangeTest(
            {
                run("   a, b ", "1")
                assertThat(output()).contains("a : ", "b : ", "Winners : a, b")
            },
            STOP, STOP
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
