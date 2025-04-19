package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `proceed for a given number of rounds`() {
        val winner = Car(CarName("pobi"), FixedPowerGenerator(4))
        val loser = Car(CarName("tebah"), FixedPowerGenerator(3))
        val cars = Cars(listOf(winner, loser))
        val race = Race(cars, 5)

        val result = race.start()

        assertEquals(5, result.roundResults.size)
    }

    @Test
    fun `When the game ends, a winner is determined`() {
        val winner = Car(CarName("pobi"), FixedPowerGenerator(4))
        val loser = Car(CarName("tebah"), FixedPowerGenerator(3))
        val cars = Cars(listOf(winner, loser))
        val race = Race(cars, 5)

        val result = race.start()

        assertTrue(winner in result.winners)
        assertFalse(loser in result.winners)
    }
}
