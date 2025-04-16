package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val application = Application()
    application.run()
}

class Application {
    fun run() {
        val carNames = inputCarNames()
        val rounds = inputRounds()

        val cars = createCars(carNames)
        val race = Race(cars, rounds)

        race.start()
    }

    private fun inputCarNames(): List<String> {
        println("Enter the name of the cars (coma-separated):")
        val input = Console.readLine()
        return input.split(",").map { it.trim() }
    }

    private fun inputRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return InputValidator.validateRounds(input)
    }

    private fun createCars(carNames: List<String>): List<Car> {
        InputValidator.validateCarNames(carNames)
        return carNames.map { Car(it) }
    }
}
