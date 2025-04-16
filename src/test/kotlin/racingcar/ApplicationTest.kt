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
    fun `exception test for invalid car name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `input test for valid car names`() {
        assertSimpleTest {
            run("abc,de,fgh", "5")
            assertThat(output()).contains("Car names: [abc, de, fgh]", "Race count: 5")
        }
    }

    @Test
    fun `input test for car name longer than 5 characters`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("superman", "1") }
        }
    }

    @Test
    fun `input test for empty car name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,java", "1") }
        }
    }

    @Test
    fun `input test for non-numeric race count`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "three") }
        }
    }

    @Test
    fun `input test for zero race count`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `input test for negative race count`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-5") }
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
