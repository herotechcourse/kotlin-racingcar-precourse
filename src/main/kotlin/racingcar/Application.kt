package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val FORWARD = "Forward"
const val STAY = "Stay"

fun main() {
    val carList = readCars()
    val numberOfRounds =  readNumberOfRounds()

    startRace(carList, numberOfRounds)
    displayWinners(carList)
}

fun startRace(carList: List<Car>, numberOfRounds: Int) {
    print("Race Results")

    repeat(numberOfRounds) {
        carList.forEach { car ->
            moveCar(car)
            dispalyStats(car)
        }
    }
}

fun moveCar(car: Car) {
    if (randomCarMovement() == FORWARD) {
        car.moveForward()
    }
}

fun dispalyStats(car: Car) {
    print("${car.name} : ${car.getPositionBar()}")
}

fun displayWinners(carList: List<Car>) {
    val maxPosition = carList.maxOf { it.position }
    val winners = carList.filter { it.position == maxPosition }
    val winnersName = winners.joinToString(", ") { it.name }
    
    print("Winners : $winnersName")
}

fun randomCarMovement(): String{
    val randomNumber = Randoms.pickNumberInRange(0, 9)
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