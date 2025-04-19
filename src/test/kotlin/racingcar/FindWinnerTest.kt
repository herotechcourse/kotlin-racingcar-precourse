package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FindWinnerTest : NsTest() {

    @Test
    fun `find winners test`() {
        val cars = listOf(
            Car("pobi", 3),
            Car("crong", 5),
            Car("roro", 5),
            Car("po", 2)
        )

        val winners = findWinners(cars)
        val winnerNames = winners.map { it.name }

        assertThat(winnerNames).containsExactly("crong", "roro")
    }

    @Test
    fun `print winners test`() {
        val cars = listOf(
            Car("pobi", 1),
            Car("crong", 4),
            Car("roro", 4)
        )

        assertSimpleTest {
            printWinners(cars)
            val output = output()
            assertThat(output).contains("Winners : crong, roro")
        }
    }

    override fun runMain() {
    }
}
