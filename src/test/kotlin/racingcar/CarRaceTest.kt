package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarRaceTest {

    private val carRace = CarRace()

    @Test
    fun `validateUserInputs should pass with valid inputs`() {
        assertDoesNotThrow {
            carRace.validateUserInputs(listOf("CarA", "CarB"), 3)
        }
    }

    @Test
    fun `validateUserInputs should fail when empty name is passed`() {
        val exception = assertThrows<IllegalArgumentException> {
            carRace.validateUserInputs(listOf("CarA", ""), 3)
        }
        assertEquals("Car name should not be empty", exception.message)
    }

    @Test
    fun `validateUserInputs should fail when length of car name is more than 5`() {
        val exception = assertThrows<IllegalArgumentException> {
            carRace.validateUserInputs(listOf("CarA", "CarABCDE"), 3)
        }
        assertEquals("Car name length should not be more than 5", exception.message)
    }

    @Test
    fun `validateUserInputs should throw error when car names are empty`() {
        val exception = assertThrows<IllegalArgumentException> {
            carRace.validateUserInputs(emptyList(), 2)
        }
        assertEquals("Car names cannot be empty", exception.message)
    }

    @Test
    fun `validateUserInputs should throw error when rounds are negative`() {
        val exception = assertThrows<IllegalArgumentException> {
            carRace.validateUserInputs(listOf("CarA"), -1)
        }
        assertEquals("Number of rounds must be non-negative", exception.message)
    }

    @Test
    fun `initializeRace should create map with empty strings`() {
        val carNames = listOf("CarA", "CarB")
        val result = carRace.initializeRace(carNames)
        assertEquals(2, result.size)
        assertEquals("", result["CarA"])
        assertEquals("", result["CarB"])
    }

    @Test
    fun `determineWinners should return single car with max length`() {
        val raceResult = hashMapOf(
            "CarA" to "----",
            "CarB" to "---",
            "CarC" to "-"
        )
        val winners = carRace.determineWinners(raceResult)
        assertEquals(listOf("CarA"), winners.sorted())  // sorting to make test stable
    }

    @Test
    fun `determineWinners should return all cars with max length`() {
        val raceResult = hashMapOf(
            "CarA" to "---",
            "CarB" to "---",
            "CarC" to "-"
        )
        val winners = carRace.determineWinners(raceResult)
        assertEquals(listOf("CarA", "CarB"), winners.sorted())  // sorting to make test stable
    }

    @Test
    fun `determineWinners should handle empty map`() {
        val winners = carRace.determineWinners(emptyMap())
        assertTrue(winners.isEmpty())
    }

    @Test
    fun `runSingleRound should update raceResult only when random number is above threshold`() {
        val carRace = CarRace()
        val carNames = listOf("CarA", "CarB")
        val raceResult = hashMapOf("CarA" to "", "CarB" to "")

        carRace.runSingleRound(carNames, raceResult) { 5 }

        assertEquals("-", raceResult["CarA"])
        assertEquals("-", raceResult["CarB"])
    }

    @Test
    fun `runSingleRound should not update raceResult when random number is below threshold`() {
        val carRace = CarRace()
        val carNames = listOf("CarA", "CarB")
        val raceResult = hashMapOf("CarA" to "", "CarB" to "")

        carRace.runSingleRound(carNames, raceResult) { 2 }

        assertEquals("", raceResult["CarA"])
        assertEquals("", raceResult["CarB"])
    }
}