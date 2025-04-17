package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest : NsTest() {
    @Test
    fun `initializeGame returns map with zero positions`() {
        val carNames = listOf("pobi", "woni")
        val result = initializeGame(carNames)

        assertThat(result).hasSize(2)
        assertThat(result["pobi"]).isEqualTo(0)
        assertThat(result["woni"]).isEqualTo(0)
    }

    @Test
    fun `processGame moves cars with random number above 4`() {
        val gameState = HashMap<String, Int>().apply {
            put("pobi", 0)
            put("woni", 1)
        }

        assertRandomNumberInRangeTest(
            {
                processGame(gameState)
                assertThat(gameState["pobi"]).isEqualTo(1)
                assertThat(gameState["woni"]).isEqualTo(1)
            },
            4,
            3
        )
    }

    override fun runMain() {
    }
}