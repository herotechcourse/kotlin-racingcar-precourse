package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private const val MAX_NAME_LENGTH = 5
private const val MOVE_THRESHOLD = 4

fun main() {
    val names = promptNames()
    val rounds = promptRounds()
    val race = Race(names.map { Car(it) }, rounds)

    println()
    println("Race Results")
    race.start()
    println()
    println("Winners : ${race.winners().joinToString(", ")}")
}

private fun promptNames(): List<String> {
    print("Enter the names of the cars (comma-separated): ")
    val input = Console.readLine()
    require(input.isNotBlank()) {
        "Car names cannot be blank."
    }

    return input.split(',')
        .map { it.trim() }
        .also { list ->
            require(list.isNotEmpty()) {
                "At least one car name is required."
            }
            list.forEach { name ->
                require(name.isNotBlank() && name.length <= MAX_NAME_LENGTH) {
                    "Invalid car name: $name"
                }
            }
        }
}

private fun promptRounds(): Int {
    print("How many rounds will be played? ")
    val input = Console.readLine()
    val value = input.toIntOrNull()
    require(value != null && value > 0) {
        "Rounds must be a positive integer."
    }
    return value
}

data class Car(
    val name: String,
    private var position: Int = 0
) {
    init {
        require(name.isNotBlank() && name.length <= MAX_NAME_LENGTH) {
            "Invalid car name: $name"
        }
    }

    fun attemptMove() {
        moveIfNecessary(Randoms.pickNumberInRange(0, 9))
    }

    internal fun moveIfNecessary(random: Int) {
        if (random >= MOVE_THRESHOLD){
            position++
        }
    }

    fun distance(): Int = position
}

class Race(
    private val cars: List<Car>,
    private val rounds: Int
) {
    fun start() {
        repeat(rounds) {
            cars.forEach {
                it.attemptMove()
            }
            printRound()
        }
    }

    fun winners(): List<String> {
        val best = cars.maxOf {
            it.distance()
        }
        return cars.filter { it.distance() == best }.map { it.name }
    }

    private fun printRound() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.distance())}")
        }
        println()
    }
}
