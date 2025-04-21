package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RaceTest {
    private val outputStream = ByteArrayOutputStream()

    @Test
    fun `race should execute correct number of rounds`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val raceDisplay = RaceDisplay()
        val race = Race(cars, 2, raceDisplay)

        System.setOut(PrintStream(outputStream))
        assertRandomNumberInRangeTest(
            {
                race.start()
                assertThat(outputStream.toString()).contains(
                    "Round 1",
                    "pobi : -",
                    "woni : ",
                    "Round 2",
                    "Final Result"
                )
            },
            4,  // First car moves
            3   // Second car doesn't move
        )
        System.setOut(System.out)
    }

    @Test
    fun `race should announce correct winners`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val raceDisplay = RaceDisplay()
        val race = Race(cars, 1, raceDisplay)

        System.setOut(PrintStream(outputStream))
        assertRandomNumberInRangeTest(
            {
                race.start()
                assertThat(outputStream.toString()).contains("Winners : pobi")
            },
            4  // Only first car moves
        )
        System.setOut(System.out)
    }

    @Test
    fun `race should handle multiple winners`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val raceDisplay = RaceDisplay()
        val race = Race(cars, 1, raceDisplay)

        System.setOut(PrintStream(outputStream))
        assertRandomNumberInRangeTest(
            {
                race.start()
                assertThat(outputStream.toString()).contains("Winners : pobi, woni")
            },
            4,  // First car moves
            4   // Second car also moves
        )
        System.setOut(System.out)
    }
} 