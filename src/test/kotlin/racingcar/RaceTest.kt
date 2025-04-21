package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.observer.IRaceObserver
import racingcar.strategy.MovementStrategy

class RaceTest {

    class AlwaysMove : MovementStrategy {
        override fun shouldMove(): Boolean = true
    }

    class MockObserver : IRaceObserver {
        val roundsLog = mutableListOf<List<Pair<String, Int>>>()
        var winners: List<String> = listOf()

        override fun notifyRound(round: Int, cars: List<Car>) {
            roundsLog.add(cars.map { it.name to it.position })
        }

        override fun notifyFinish(cars: List<Car>, winners: List<String>) {
            this.winners = winners
        }
    }

    @Test
    fun `race runs for correct rounds and declares winner`() {
        val cars = listOf(Car("A"), Car("B"))
        val observer = MockObserver()
        val race = Race(cars, rounds = 3, strategy = AlwaysMove(), observer)

        race.start()

        // Each car should have moved 3 times
        assertEquals(3, cars[0].position)
        assertEquals(3, cars[1].position)

        // Observer should have 3 logs
        assertEquals(3, observer.roundsLog.size)

        // Both should be winners (tie)
        assertEquals(listOf("A", "B"), observer.winners)
    }
}
