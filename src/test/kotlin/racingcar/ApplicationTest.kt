package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun featureTest() {
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
    fun exceptionTest() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,javaji", "1")
            }
        }
    }

    override fun runMain() {
        Application.runGame()  // ← main() 말고 runGame()을 직접 호출!
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
