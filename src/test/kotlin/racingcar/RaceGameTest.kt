package racingcar
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Engine
import racingcar.domain.RaceGame
import racingcar.io.Printer

class RaceGameTest {

    @Test
    @DisplayName("All cars move forward by engine output * round number")
    fun raceAllRoundMovesAllCarsCorrectly() {
        // given
        val engine = FixedEngine(1)
        val printer = DummyPrinter()
        val cars = listOf(
            Car("pobi", 0, engine),
            Car("woni", 0, engine)
        )
        val raceGame = RaceGame(cars, roundNumber = 3, resultPrinter = printer)

        // when
        val result = raceGame.raceAllRound()

        // then
        for (car in result) {
            assertEquals(3, car.getPosition(), "${car.getName()} should have moved 3 steps")
        }
    }

    @Test
    @DisplayName("Should throw an exception when round number is zero")
    fun shouldThrowWhenRoundNumberIsZero() {
        val engine = FixedEngine(1)
        val printer = DummyPrinter()
        val cars = listOf(
            Car("pobi", 0, engine),
            Car("woni", 0, engine)
        )

        assertThrows<IllegalArgumentException> {
            RaceGame(cars, roundNumber = 0, resultPrinter = printer)
        }
    }

    @Test
    @DisplayName("Should throw an exception when round number is negative")
    fun shouldThrowWhenRoundNumberIsNegative() {
        val engine = FixedEngine(1)
        val printer = DummyPrinter()
        val cars = listOf(
            Car("pobi", 0, engine),
            Car("woni", 0, engine)
        )

        assertThrows<IllegalArgumentException> {
            RaceGame(cars, roundNumber = -1, resultPrinter = printer)
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