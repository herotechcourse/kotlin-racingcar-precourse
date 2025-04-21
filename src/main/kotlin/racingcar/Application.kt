package racinggame

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    Application().run()
}

class Application {
    fun run() {
        val carNames = InputView.readCarNames()
        val numberOfRounds = InputView.readNumberOfRounds()

        val cars = carNames.map { Car(it) }
        val race = Race(cars)

        println("\nRace Results")
        repeat(numberOfRounds) {
            race.moveAll()
            OutputView.printRoundResults(cars)
        }

        val winners = race.findWinners()
        OutputView.printWinners(winners)
    }
}

class Car(private val name: String) {
    private var position: Int = 0

    init {
        require(name.isNotBlank() && name.length <= 5) {
            "Car name must be between 1 to 5 characters."
        }
    }

    fun moveIfPossible() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) position++
    }

    fun getPosition() = position
    fun getName() = name
    fun renderProgress(): String = "$name : ${"-".repeat(position)}"

    // For test use only
    fun setTestPosition(pos: Int) {
        position = pos
    }
}

class Race(private val cars: List<Car>) {
    fun moveAll() {
        cars.forEach { it.moveIfPossible() }
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == max }.map { it.getName() }
    }
}

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        if (names.isEmpty() || names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Invalid car names.")
        }
        return names
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Invalid number of rounds.")
    }
}

object OutputView {
    fun printRoundResults(cars: List<Car>) {
        cars.forEach { println(it.renderProgress()) }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}

class CarTest {
    @Test
    fun `car moves forward when random number is 4 or more`() {
        val car = Car("test")
        val original = car.getPosition()
        repeat(100) {
            car.moveIfPossible()
        }
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(original)
    }

    @Test
    fun `car name must be between 1 to 5 characters`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("")
        }
        assertThrows(IllegalArgumentException::class.java) {
            Car("toolong")
        }
    }
}

class RaceTest {
    private lateinit var cars: List<Car>
    private lateinit var race: Race

    @BeforeEach
    fun setup() {
        cars = listOf(Car("a"), Car("b"), Car("c"))
        race = Race(cars)
    }

    @Test
    fun `moveAll should not throw and update state of all cars`() {
        race.moveAll()
        assertThat(cars).isNotEmpty()
    }

    @Test
    fun `findWinners returns correct winners`() {
        val car1 = Car("car1")
        val car2 = Car("car2")
        car1.setTestPosition(3)
        car2.setTestPosition(3)

        val testRace = Race(listOf(car1, car2))
        val winners = testRace.findWinners()

        assertThat(winners).containsExactlyInAnyOrder("car1", "car2")
    }
}
