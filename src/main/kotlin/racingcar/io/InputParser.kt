package racingcar.io

import racingcar.Car

object InputParser {

    fun readCarNames(input: String): List<Car> {
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

    fun readRound(input: String): Int {
        val round = input.toIntOrNull()
        if (round == null || round <= 0) {
            throw IllegalArgumentException("Invalid number of round")
        }

        return round
    }

}