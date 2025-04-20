package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class RaceTest {
    @Test
    fun `getWinners should return the car with the farthest distance`() {
        val car1 = Car(name = "hero", numberGenerator = { 4 })
        val car2 = Car(name = "tech", numberGenerator = { 3 })
        val race = Race(cars = listOf(car1, car2), rounds = 3)

        race.play()

        val winners = race.getWinners()

        assertEquals(listOf("hero"), winners)
    }

    @Test
    fun `getWinners should return all cars if they tie`() {
        val car1 = Car(name = "hero", numberGenerator = { 4 })
        val car2 = Car(name = "tech", numberGenerator = { 4 })
        val race = Race(cars = listOf(car1, car2), rounds = 2)

        race.play()

        val winners = race.getWinners()

        assertEquals(listOf("hero", "tech"), winners)
    }

}