package racingcar.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class ResultViewTest : NsTest() {
    @Test
    fun `print round result should show car positions`() {
        assertSimpleTest {
            val cars = listOf(
                Car("pobi").apply { repeat(3) { move(4) } },
                Car("woni").apply { repeat(2) { move(4) } }
            )
            ResultView.printRoundResult(cars)
            assertThat(output()).contains("pobi : ---", "woni : --")
        }
    }

    @Test
    fun `print winner should show single winner`() {
        assertSimpleTest {
            ResultView.printWinner(listOf("pobi"))
            assertThat(output()).contains("Winners : pobi")
        }
    }

    @Test
    fun `print winner should show multiple winners`() {
        assertSimpleTest {
            ResultView.printWinner(listOf("pobi", "woni"))
            assertThat(output()).contains("Winners : pobi, woni")
        }
    }

    override fun runMain() {
        // Not needed for these tests
    }
} 