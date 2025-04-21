package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position = 0

    init {
        require(name.isNotEmpty() && name.length <= 5) {
            "Car name must be between 1 to 5 characters."
        }
    }

    fun move() {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) position++
    }

    fun getProgress(): String {
        return "$name : ${"-".repeat(position)}"
    }
}

class CarRacingGame {
    private lateinit var cars: List<Car>
    private var rounds: Int = 0

    fun start() {
        
                println("Race started!")

        cars = getCarsFromInput()
        rounds = getRoundsFromInput()

        println("\nRace Results")
        repeat(rounds) {
            //playOneRound()
            //printProgress()
            //println()
            playRoundAndShowProgress()
        }

        printWinners()
    }

    private fun playRoundAndShowProgress() {
        playOneRound()
        printProgress()
        println()
    }

    private fun getCarsFromInput(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        //val input = "arju,nicky,akki"  // Sample input pushed here

        val names = input.split(",").map { it.trim() }


        return names.map { Car(it) }
    }

    private fun getRoundsFromInput(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        //val input = "5"  // hardcode value to be pushed

        return input.toIntOrNull() ?: throw IllegalArgumentException("Invalid number of rounds.")
    }

    private fun playOneRound() {
        cars.forEach { it.move() }
    }

    private fun printProgress() {
        cars.forEach { println(it.getProgress()) }
    }

    private fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}
