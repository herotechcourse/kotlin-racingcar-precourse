package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FindWinnerTest : NsTest() {

    @Test
    fun `print winners test`() {
        val cars = listOf(
            Car("pobi"),
            Car("crong"),
            Car("roro"),
            Car("po")
        )
        val rounds = 3

        val race = Race(cars, rounds)

        assertSimpleTest {
            race.runRace()
            race.printWinners()
            val output = output()
            assertThat(output).contains("Winners :")
        }
    }

    override fun runMain() {
    }
}
