package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.DisplayName
import camp.nextstep.edu.missionutils.Console

class ApplicationTest : NsTest() {

    @Test
    @DisplayName("Should complete full game successfully")
    fun shouldCompleteFullGame() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "3")
                assertThat(output())
                    .contains("pobi : -")
                    .contains("woni : ")
                    .contains("Winners :")
            },
            4, 3, 4, 3, 4, 3  // Predetermined random numbers
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
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
