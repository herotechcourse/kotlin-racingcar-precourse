package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test

class RunRaceTest : NsTest() {

    @Test
    fun `car progress print for each round test`() {
        val cars = listOf(Car("pobi"), Car("crong"))
        val rounds = 3

        assertSimpleTest {
            Race(cars, rounds).runRace()
            val output = output()

            check(output.contains("Race Results"))
            check(output.contains("pobi"))
            check(output.contains("crong"))

        }
    }

    override fun runMain() {
    }
}
