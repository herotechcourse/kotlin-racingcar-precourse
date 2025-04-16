package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class Car(val name: String, var progress: Int = 0) {
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            progress++
        }
    }

    fun getProgress(): String {
        return "-".repeat(progress)
    }
}

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
    val carNamesList = carNames.split(",").map { it.trim() }

    // receive round count from user
    val roundCount = Console.readLine().toInt()
    println("How many rounds will be played?")
    
    // generate Cars
    val cars = carNamesList.map { Car(it) }

    // start race
    println("Race Results")
    simulateRace(cars, roundCount)

    // determine and declare winners
    println("Winner(s):")
    val winners = determineWinners(cars)
    println(winners.joinToString(", ") { it.name }) 

}
