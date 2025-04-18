package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Engine
import racingcar.domain.RaceGame

class RaceGameTest {

    @Test
    @DisplayName("All Cars move by the fixed engine for given round")
    fun raceAllRound() {
        // given
        val engine = FixedEngine(1)
        val dummyPrinter = DummyPrinter()

        val cars = listOf(
            Car("pobi", 0, engine),
            Car("woni", 0, engine)
        )
        val roundNumber = 3
        val raceGame = RaceGame(cars, roundNumber, dummyPrinter)

        // when
        val movedCars = raceGame.raceAllRound()

        // then
        for (car in movedCars) {
            assertEquals(3, car.getPosition(), "${car.getName()} should have moved 3 positions")
        }
    }

    @Test
    @DisplayName("Cars do not move if round number is 0")
    fun noMovementWhenRoundZero() {
        // given
        val engine = FixedEngine(1)
        val dummyPrinter = DummyPrinter()

        val cars = listOf(
            Car("pobi", 0, engine),
            Car("woni", 0, engine)
        )
        val roundNumber = 0
        val raceGame = RaceGame(cars, roundNumber, dummyPrinter)

        // when
        val movedCars = raceGame.raceAllRound()

        // then
        for (car in movedCars) {
            assertEquals(0, car.getPosition(), "${car.getName()} should not have moved")
        }
    }
}


class FixedEngine(private val fixedValue: Int) : Engine {
    override fun move(): Int = fixedValue
}

class DummyPrinter : Printer {
    override fun printCurrentCarPosition(car: List<Car>) {
        // It is dummy printer, so it will not print the car status
    }
}