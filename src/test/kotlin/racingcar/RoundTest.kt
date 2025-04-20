package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoundTest {

    @Test
    fun `winners are the cars with the most movement count`() {
        val round = Round()
        val cars = getCars()
        val expectedWinners = listOf(cars.toList()[2], cars.toList()[3])

        val winners = round.getWinners(cars)

        assertEquals(2, winners.count())
        assertEquals(expectedWinners, winners)
    }

    private fun getCar(name: String, movements: List<Pair<Int, Int>>): Car {
        val car = Car(name)
        movements.forEach { (start, end) ->
            car.moveForward(start, end)
        }
        return car
    }

    private fun getCars(): Set<Car> {
        return setOf(
            getCar("pobi", listOf(4 to 9, 4 to 9, 0 to 3, 4 to 9)),
            getCar("woni", listOf(4 to 9, 0 to 3, 0 to 3, 0 to 3)),
            getCar("jun", listOf(4 to 9, 4 to 9, 4 to 9, 4 to 9)),
            getCar("yu", listOf(4 to 9, 4 to 9, 4 to 9, 4 to 9)),
        )
    }
}
