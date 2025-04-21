package racingcar

import racingcar.model.RaceInputs
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals

class RaceTest : NsTest() {
    @Test
    fun `Should create Car objects from RaceInputs`() {
        assertSimpleTest {
            val raceInputs = RaceInputs(listOf("car1", "car2", "car3"), 5)
            val race = Race(raceInputs)

            val cars = race.names.map { race.createCarObj(it) }

            assertAll(
                { assertEquals(3, cars.size) },
                { assertEquals("car1", cars[0].name) },
                { assertEquals("car2", cars[1].name) },
                { assertEquals("car3", cars[2].name) },
                { assertTrue(cars.all { it.position == 0 }) }
            )
        }
    }

/*    Correct string output based on the number of winners */
    @Test
    fun `should run race and determine winners - no winner`() {
        val raceInputs = RaceInputs(listOf(), 5)
        val race = Race(raceInputs)

        val winners = race.getWinners(race.names.map { race.createCarObj(it) })
        assertEquals("No One", winners)
    }

    @Test
    fun `should run race and determine winners - only one winner`() {
        val raceInputs = RaceInputs(listOf("car1"), 5)
        val race = Race(raceInputs)

        val cars = race.names.map { race.createCarObj(it, 5) } // Simulate the car moving forward

        val winners = race.getWinners(cars)
        assertEquals("car1", winners)
    }

    @Test
    fun `should run race and determine winners - multiple winners`() {
        val raceInputs = RaceInputs(listOf("car1", "car2"), 5)
        val race = Race(raceInputs)

        val cars = race.names.map { race.createCarObj(it, 5) } // Simulate the cars moving forward

        val winners = race.getWinners(cars)
        assertEquals("car1, car2", winners)
       
    }

    override fun runMain() {
        main()
    }
}