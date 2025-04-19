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
    fun `should throw exception if car list is not comma-separated`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobijavaji", "1") }
            assertThat(exception.message).isEqualTo("Car names should be comma-separated.")
        }
    }

    @Test
    fun `should throw exception when number of rounds is zero`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
            assertThat(exception.message).isEqualTo("Number of rounds must be greater than 0.")
        }
    }

    @Test
    fun `should throw exception when number of rounds is negative`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
            assertThat(exception.message).isEqualTo("Number of rounds must be greater than 0.")
        }
    }

    @Test
    fun `should throw exception when number of rounds is not a valid integer`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "abc") }
            assertThat(exception.message).isEqualTo("Invalid input. Please enter a valid integer for the number of rounds.")
        }
    }

    @Test
    fun `should return valid number of rounds when input is a positive integer`() {
        assertSimpleTest {
            run("pobi,woni", "5")
            assertThat(output()).contains("pobi : ", "woni : ")
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
