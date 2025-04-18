package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RaceSimulatorTest : NsTest() {

    @Test
    @DisplayName("runRace moves cars forward correcly")
    fun shouldMoveRandomReturnsTrue() {
        assertRandomNumberInRangeTest(
            {
                val outputStream = ByteArrayOutputStream()
                System.setOut(PrintStream(outputStream))

                val cars = listOf(Car("pobi"), Car("duc"))
                RaceSimulator.runRace(cars, 1)

                assertThat(cars[0].position).isEqualTo(1)
                assertThat(cars[1].position).isEqualTo(0)

                val output = outputStream.toString()
                assertThat(output).contains(
                    "Race Results",
                    "pobi : -",
                    "duc : "
                )
            },
            MOVING_FORWARD,
            STOP
        )
    }

    @Test
    @DisplayName("runRace handles multiple rounds correctly")
    fun shouldMoveRandomMultipleRounds() {
        assertRandomNumberInRangeTest(
            {
                val outputStream = ByteArrayOutputStream()
                System.setOut(PrintStream(outputStream))

                val cars = listOf(Car("pobi"), Car("duc"))
                RaceSimulator.runRace(cars, rounds = 3)

                assertThat(cars[0].position).isEqualTo(3)
                assertThat(cars[1].position).isEqualTo(3)

                val output = outputStream.toString()
                assertThat(output).contains(
                    "Race Results",
                    // Round 1
                    "pobi : -",
                    "duc : -",
                    // Round 2
                    "pobi : --",
                    "duc : --",
                    // Round 3
                    "pobi : ---",
                    "duc : ---"
                )
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
            MOVING_FORWARD,
            MOVING_FORWARD,
            MOVING_FORWARD,
            MOVING_FORWARD,
        )
    }

    override fun runMain() {
        // not used
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
