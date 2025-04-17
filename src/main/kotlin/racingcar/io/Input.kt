package racingcar.io

import camp.nextstep.edu.missionutils.Console
import racingcar.Car

object Input {

    fun readCarNames(): List<Car> {
        println("Enter the names of the cars (comma-separated): ")
        val input = Console.readLine()

        if (input.isBlank()) {
           throw IllegalArgumentException("Empty car names")
        }

        val carNames = input.split(",")
            .map { carName -> Car(carName.trim()) }

        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException("Duplicate car names are not allowed")
        }

        return carNames
    }

    fun readNumberOfRound(): Int {
        println("How many rounds will be played? ")
        val input = Console.readLine()
        println()

        val round= input.toIntOrNull()
        if(round == null || round <= 0) {
            throw IllegalArgumentException("Invalid number of round")
        }

        return round
    }

}