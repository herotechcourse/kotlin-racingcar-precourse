package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun prompt(message: String): String {
    print(message)
    val input = Console.readLine()
    require(!input.isNullOrBlank()) { "Input is empty." }
    return input
}

fun validateCarNames(input: String): List<String> {
    val names = input.split(",").map { it.trim() }
    names.forEach { name ->
        require(name.length in 1..5) { "Each name must be 1 to 5 characters." }
    }
    return names
}

fun validateRounds(input: String): Int {
    val rounds = input.toIntOrNull()
    require(rounds != null) { "Input must be a valid number." }
    require(rounds > 0) { "Rounds must be a positive number." }
    return rounds
}

fun printDashes(number: Int): String {
    return "-".repeat(number)
}

fun race(cars:List<String>, carProgress:MutableMap<String, Int>){
    cars.forEach { car ->
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber in 4..9){
            carProgress[car] = (carProgress[car] ?: 0) + 1
        }
        println("$car : ${printDashes(carProgress[car]?:0)}")
    }
    println()
}

fun filterWinners(carProgress: MutableMap<String, Int>): List<String>{
    val maxProgress = carProgress.values.maxByOrNull { it:Int -> it ?:0 }
    return carProgress.filter { it.value == maxProgress }.map {it.key}
}

fun startRace(cars:List<String>, rounds: Int){
    val carProgress = mutableMapOf<String, Int>()
    println("Race Results")
    cars.forEach { car -> carProgress[car] = 0 }
    for (i in 1..rounds) {
        race(cars, carProgress)
    }
    val winners = filterWinners(carProgress)
    if (winners.size == 1) {
        println("Winner: ${winners.first()}")
    } else {
        println("Winners: ${winners.joinToString(", ")}")
    }
}

fun main() {
    val namesInput = prompt("Enter names of cars (max 5 chars): e.g. mike,mary,mo: ")
    val cars = validateCarNames(namesInput)

    val roundsInput = prompt("Enter number of rounds to race: ")
    val rounds = validateRounds(roundsInput)
    startRace(cars, rounds)
}
