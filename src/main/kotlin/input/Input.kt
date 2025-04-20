package input

import camp.nextstep.edu.missionutils.Console
import car.Car

private const val CAR_NAME_DELIMITER = ","
private const val MIN_CAR_COUNT = 2

object Input {
    fun getCars(): Array<Car> {
        println("Enter the names of the cars (comma-separated):")

        val carNames = Console.readLine()
        val carSet = mutableSetOf<String>()

        val cars = carNames.split(CAR_NAME_DELIMITER).map { carName ->
            if (!carSet.add(carName.lowercase())) {
                throw IllegalArgumentException("Duplicate car names found")
            }
            Car(carName)
        }.toTypedArray()

        if (cars.size < MIN_CAR_COUNT) {
            throw IllegalArgumentException("Atleast 2 cars should participate in the game")
        }
        return cars
    }

    fun getTotalRounds(): Int {
        println("How many rounds will be played?")

        val totalRoundStr = Console.readLine()
        val totalRound = totalRoundStr.toIntOrNull()
            ?: throw IllegalArgumentException("Number of rounds should be a valid number and within the range 1 to ${Int.MAX_VALUE}")

        if (totalRound <= 0) {
            throw IllegalArgumentException("Number of rounds should be greater than zero")
        }
        return totalRound
    }
}