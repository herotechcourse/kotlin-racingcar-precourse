package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

import racingcar.model.Car

fun simulateRace(Cars: List<Car>, rounds: Int) {
    for (i in 0 until rounds) {
        Cars.forEach { it.move() }
        Cars.forEach { println("${it.name} : ${it.getProgress()}") }
        println()
    }
}

fun determineWinners(cars: List<Car>): List<Car> {
    val maxProgress = cars.maxOf { it.progress }
    return cars.filter { it.progress == maxProgress }
}

fun main() {
    // receive car names from user
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine();
    if (carNames.isBlank()) {
        throw IllegalArgumentException()
    }
    
    val carNamesList = carNames.split(",").map { it.trim() }
    if (carNamesList.any { it.length < 1 || it.length > 5 }) {
        throw IllegalArgumentException()
    }

    // receive round count from user
    val roundCount = Console.readLine().toInt()
    println("How many rounds will be played?")
    
    if (roundCount <= 0) {
        throw IllegalArgumentException()
    }
    
    // generate Cars
    val cars = carNamesList.map { Car(it) }

    // start race
    println("Race Results")
    simulateRace(cars, roundCount)

    // determine and declare winners
    val winners = determineWinners(cars)
    println("Winners : " + winners.joinToString(", ") { it.name }) 

}
