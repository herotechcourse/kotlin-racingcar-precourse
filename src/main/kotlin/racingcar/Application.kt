package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carNames= askCarNames()
    val numOfRounds= askNumRounds()
    val finalPos= runCarRace(carNames, numOfRounds)
    displayWinners(finalPos)
}

fun askCarNames():List<String> {
    println("Enter car names (comma separated):")
    val input= Console.readLine()
    val names= input.split(",").map { it.trim() }
    validateCarNames(names)
    return names
}

fun validateCarNames(names:List<String>) {
    for (name in names) {
        if (name.isEmpty() || name.length > 5) {
             throw IllegalArgumentException("Each car name must be between 1 and 5 characters.")
        }
    }
    val givenNames= mutableListOf<String>()
    for (name in names) {
        if (givenNames.contains(name)) {
            throw IllegalArgumentException("Car names must be unique. '$name' is repeated.")
        }
        givenNames.add(name)
    }
}

fun askNumRounds():Int {
    println("Enter number of rounds:")
    val input= Console.readLine()
    val num= input.toIntOrNull()
    if (num== null || num <= 0) {
        throw IllegalArgumentException("Rounds must be a positive number.")
    }
    return num
}

fun runCarRace(cars:List<String>, rounds:Int): Map<String, Int> {
    val positions= mutableMapOf<String, Int>()
    for (car in cars) {
        positions[car] = 0
    }
     repeat(rounds) {
        println("\nRound ${it + 1}")
        runOneRound(cars, positions)
    }
    return positions
}

fun runOneRound(cars:List<String>, positions:MutableMap<String, Int>) {
    for (car in cars) {
        val shouldMove= shouldMove()
        if (shouldMove) {
            val currPosition= positions[car]?: 0
            positions[car]= currPosition + 1
        }
        val endPosition= positions[car]?: 0
        displayCarStatus(car, endPosition)
    }
}

fun shouldMove(): Boolean {
    val randomNum= Randoms.pickNumberInRange(0, 9)
    return randomNum>= 4
}

fun displayCarStatus(name:String, position:Int) {
    val progress= "-".repeat(position)
    println("$name : $progress")
}

fun displayWinners(positions: Map<String, Int>) {
    val max= positions.values.maxOrNull() ?:return
    val winner= positions.filter { it.value== max }.keys
    println("Winners : ${winner.joinToString(", ")}")
}

