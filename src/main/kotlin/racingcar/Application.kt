package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carList = readCars()
    val numberOfRounds =  readNumberOfRounds()
    RaceExecutor.execute(carList, numberOfRounds)
}



fun readCars(): List<Car>{
    print("Enter the names of the cars (comma-separated): ")
    val input = Console.readLine();
    val carNames = input.split(",")
    val invalidNames = carNames.filter { name -> name.length > 5 }
            if (invalidNames.isNotEmpty()) {
            throw IllegalArgumentException("Car name(s) '${invalidNames.joinToString(", ")}' exceed 5 character limit.")
        }

    val carList =  carNames.map { name ->
        if (name.isBlank()) {
            throw IllegalArgumentException("Car name cannot be empty.")
        }

        Car(name.trim())
    }

    return carList
}

fun readNumberOfRounds(): Int{
    print("How many rounds will be played?")
    val input = Console.readLine();

    try {
        val round = input.toInt()
        if (round <= 0) {
            throw IllegalArgumentException("Number of rounds must be a positive integer.")
        }
        return round
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Invalid input. Please enter a valid integer.")
    }
}