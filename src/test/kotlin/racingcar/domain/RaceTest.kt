package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.backend.domain.Car
import racingcar.backend.domain.Race

class RaceTest {
    @Test
    fun `should move car and increase its position`() {
        val car = Car("pobi")
        val race = Race(car)

        race.movingForward()
        race.movingForward()

        assertEquals(listOf("-", "--"), race.position)
    }

    @Test
    fun `should keep same position when car stays`() {
        val car = Car("woni")
        val race = Race(car)

        race.movingForward()
        race.stop()

        assertEquals(listOf("-", "-"), race.position)
    }

    @Test
    fun `should blank position when car stays at first time`() {
        val car = Car("jun")
        val race = Race(car)

        race.stop()

        assertEquals(listOf(""), race.position)
    }
}
