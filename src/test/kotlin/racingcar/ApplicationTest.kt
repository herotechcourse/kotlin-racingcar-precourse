package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n", "\t", "pobi, ", ",", " ,pobi"])
    fun `should throw exception when car name is blank`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(input, "1") }
        }
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abcdef,pobi", "1") }
        }
    }

    @Test
    fun `should throw exception when car names contain duplicates`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,pobi", "1") }
        }
    }

    @Test
    fun `should throw exception when number of cars is less than 2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi", "1") }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [""," ", "\n", "\t", "a", "%", "3 "])
    fun `should throw exception when round input is not a valid number`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,jun", input,"") }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0"])
    fun `should throw exception when round is not positive`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,jun", input) }
        }
    }
}
