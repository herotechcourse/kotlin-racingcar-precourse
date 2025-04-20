package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTestSimple {
    @Test
    fun `car creation throws IllegalArgumentException for names exceeding 5 characters`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("TooLongName")
        }
    }

    @Test
    fun `car creation allows names with 5 characters or less`() {
        // This test primarily checks that no exception is thrown for valid names.
        // We don't need to assert much else about the created Car object here,
        // as the focus is on the name validation during creation.
        val car1 = Car("Valid")
        assert(car1.name == "Valid")

        val car2 = Car("Short")
        assert(car2.name == "Short")

        val car3 = Car("One")
        assert(car3.name == "One")

        val car4 = Car("") // Empty name is also allowed based on the require condition
        assert(car4.name == "")
    }

    @Test
    fun `car moves forward if increment is 4 or more`() {
        val car = Car("TestC")
        car.move(4)
        assertEquals(1, car.position)
        car.move(9)
        assertEquals(2, car.position)
    }

    @Test
    fun `car stays in place if increment is less than 4`() {
        val car = Car("TestC")
        car.move(3)
        assertEquals(0, car.position)
        car.move(0)
        assertEquals(0, car.position)
    }

    @Test
    fun `car display shows name and position correctly`() {
        val car = Car("Racer")
        car.move(5)
        car.move(5)
        assertEquals("Racer : --", car.display())
    }
}

class CarRaceTestSimple {

    @Test
    fun `getWinners returns single winner correctly`() {
        val car1 = Car("Fast1")
        val car2 = Car("Slow1")
        car1.move(5) // Move car1 to position 1 (or more)
        val cars = listOf(car1, car2)
        val race = CarRace(cars, 1)

        // To determine the winner, the race needs to have progressed enough
        // for car1 to have a higher position. Since 'play' uses random numbers,
        // we'll directly set up a scenario where car1 has moved more.
        val carMovesField = CarRace::class.java.getDeclaredField("carMoves")
        carMovesField.isAccessible = true
        carMovesField.set(race, mapOf(car1 to 1, car2 to 0)) // Simulate car1 having moved

        assertEquals("Fast1", race.getWinners())
    }

    @Test
    fun `getWinners returns multiple winners correctly`() {
        val car1 = Car("Fast1")
        val car2 = Car("Fast2")
        val car3 = Car("Slow1")
        car1.move(6) // Move car1
        car2.move(6) // Move car2 to the same position
        val cars = listOf(car1, car2, car3)
        val race = CarRace(cars, 1)

        val carMovesField = CarRace::class.java.getDeclaredField("carMoves")
        carMovesField.isAccessible = true
        carMovesField.set(race, mapOf(car1 to 1, car2 to 1, car3 to 0)) // Simulate both having moved

        assertEquals("Fast1, Fast2", race.getWinners())
    }

    @Test
    fun `getWinners returns a single winner even with more rounds simulated`() {
        val car1 = Car("Fast1")
        val car2 = Car("Slow1")
        car1.move(7)
        val cars = listOf(car1, car2)
        val race = CarRace(cars, 3)

        val carMovesField = CarRace::class.java.getDeclaredField("carMoves")
        carMovesField.isAccessible = true
        carMovesField.set(race, mapOf(car1 to 1, car2 to 0))

        assertEquals("Fast1", race.getWinners())
    }

    @Test
    fun `initial carMoves map is correctly initialized`() {
        val car1 = Car("Fast1")
        val car2 = Car("Slow1")
        val cars = listOf(car1, car2)
        val race = CarRace(cars, 2)

        val carMovesField = CarRace::class.java.getDeclaredField("carMoves")
        carMovesField.isAccessible = true
        val initialCarMoves = carMovesField.get(race) as Map<*, *>

        assertEquals(2, initialCarMoves.size)
        assertTrue(initialCarMoves.containsKey(car1))
        assertTrue(initialCarMoves.containsKey(car2))
        assertEquals(0, initialCarMoves[car1])
        assertEquals(0, initialCarMoves[car2])
    }
}