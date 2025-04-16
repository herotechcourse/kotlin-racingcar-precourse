package racingcar

import camp.nextstep.edu.missionutils.Console

// add a constant for forward movement and stay still
const val FORWARD = "Forward"
const val STAY = "Stay"

// add a model for the car to store the name and position
data class Car(val name: String, var position: Int = 0)

fun main() {
    val carList = readCars()
    val numberOfRounds =  readNumberOfRounds()

    repeat(numberOfRounds) {
        moveCars(carList)
    }
}

fun moveCars(carList: List<Car>) {
    carList.forEach { car ->
        if (randomCarMovement() == FORWARD) {
            car.position++
        }
    }
}

fun randomCarMovement(): String{
    val randomNumber = (0..9).random()
    return if (randomNumber >= 4) {
        FORWARD
    } else {
        STAY
    }
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