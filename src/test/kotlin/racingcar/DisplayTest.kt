package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DisplayTest : NsTest() {

    @Test
    fun `displayProgress and displayWinners test`() {
        assertSimpleTest {
            val gameTable = hashMapOf("pobi" to 1, "woni" to 0)
            displayProgress(gameTable)
            val winners = determineWinners(gameTable)
            displayWinners(winners)
            assertThat(output()).contains(
                "pobi : -",
                "woni : ",
                "Winners : pobi"
            )
        }
    }

    @Test
    fun `determineWinners with tied scores`() {
        val gameTable = hashMapOf("pobi" to 2, "woni" to 2, "jun" to 1)
        val winners = determineWinners(gameTable)

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni")
    }

    @Test
    fun `feature test - racing with random numbers`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "Winners : pobi"
                )
            },
            4,
            3,
        )
    }

    override fun runMain() {
        main()
    }
}