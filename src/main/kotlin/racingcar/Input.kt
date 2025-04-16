package racingcar

import camp.nextstep.edu.missionutils.Console

object Input {

    fun readCarNames(): List<Car> {
        print("Enter the names of the cars (comma-separated): ")
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

}