package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `feature RandomNumberTest`() {
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
    fun `exception CarNameLengthTest`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `exception RoundsIntTest`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "a") }
        }
    }

    @Test
    fun `exception CarNameNullTest`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(null, "a") }
        }
    }

    @Test
    fun `exception CarNameDuplicateTest`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javi,woni,pobi", "1") }
        }
    }

    @Test
    fun `feature Should parse valid comma-separated names correctly`() {
        val input = "pobi,woni"
        val result = SeparateCarNames(input)

        assertThat(result)
            .hasSize(2)
            .containsExactly("pobi", "woni")
    }

    @Test
    fun `feature Check display winner implementation feature`() {
        val carPos = mutableMapOf<String, String>()
        carPos["pobi"] = "1"
        carPos["jun"] = "3"

        val result = GetRaceWinners(carPos)
        println("$result")
        assertThat(result).isEqualTo("jun")
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
