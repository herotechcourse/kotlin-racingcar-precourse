package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class CarRace(private val cars: List<Car>, private val rounds: Int) {
    fun startRace() {
        println("Race Results")
        for (i in rounds downTo 0) {
            moveOrStand()
            displayState()
            println()
        }
    }

    fun selectWinners(): List<String> {
        val winners: MutableList<String> = mutableListOf()
        var maxPosition = 0

        for (car in cars) {
            if (car.position > maxPosition)
                maxPosition = car.position
        }

        for (car in cars) {
            if (car.position == maxPosition)
                winners.add(car.name)
        }

        return winners
    }

    private fun moveOrStand() {
        for (car in cars) {
            val move = Randoms.pickNumberInRange(0,9)
            if (move >= 4)
                car.position++
        }
    }

    private fun displayState() {
        for (car in cars) {
            val visualProgress = '-'.toString().repeat(car.position)
            println("${car.name} :  $visualProgress")
        }
    }

    companion object {
        fun initializeRace(): CarRace {
            val cars = getCars()
            val rounds = getRounds()

            return CarRace(cars, rounds)
        }
    }
}

private fun getCars(): List<Car> {
    var input: String

    while (true) {
        println("Enter the names of the cars (comma-separated):")
        input = Console.readLine() ?: continue
        if (input != "") break
    }

    val names = splitCarNames(input)
    validateNamesSize(names)
    val cars = names.map { Car(it) }

    return cars
}

private fun splitCarNames(userInput: String): List<String> {
    val names: List<String>

    if (userInput.contains(',')) {
        names = userInput.split(',').map { it.trim() }
    } else {
        names = userInput.trim().split(' ')
        if (names.size > 1) throw IllegalArgumentException("Names must be separated by commas!")
    }
    return names
}

private fun validateNamesSize(names: List<String>) {
    for (name in names) {
        if (name.length > 5) throw IllegalArgumentException("Names must not be longer than 5 characters!")
    }
}

private fun getRounds(): Int {
    var input: String

    while (true) {
        println("How many rounds will be played?")
        input = Console.readLine() ?: continue
        if (input != "") break
    }

    val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a natural number!")
    if (rounds <= 0) throw IllegalArgumentException("Rounds must be a number bigger than zero!")

    return rounds
}