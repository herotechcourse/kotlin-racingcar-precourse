package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
// TODO: Implement the program
    val cars = mutableListOf<String>()
    var carPositions = mutableMapOf<String, String>()

    println("Please enter the number of cars you want to let participate.")
    val participatingCars = Console.readLine().toIntOrNull() ?: 0
    println("$participatingCars")
    var i = participatingCars
    println("$i")
    println("Please enter one car name with less than 5 characters for each participant.")
    while (i > 0) {
        var car = Console.readLine()
        println("#$i $car")
        println("$i")
        if (car != null && car.length <= 5 && car.all { it.isLetter() }) cars.add(car)
        else println("invalid")
        i--
    }
    println(cars)
    println("Please input the number of rounds: ")
    val numberOfRounds = Console.readLine().toIntOrNull() ?: 0
    var b = numberOfRounds
    cars.forEach { carPositions[it] = "" }
    while (b > 0) {
        cars.forEach {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            println("number is : $randomNumber")
            if (randomNumber >= 4) carPositions[it] = carPositions[it]!! + "-"
        }
        carPositions.forEach { (car, track) -> println("$car : $track") }
        b--
    }
    val maxDistanceCovered = carPositions.values.maxOf { it.length }
    println(maxDistanceCovered)
    val winners = carPositions.filterValues { it.length == maxDistanceCovered }.keys
    println("Winner(s): ${winners.joinToString(", ")}")
}


// thats the re formated code chat gpt made out of mine >>>>
//package racingcar
//
//import camp.nextstep.edu.missionutils.Console
//import camp.nextstep.edu.missionutils.Randoms
//
//fun main() {
//    val cars = mutableListOf<String>()
//    val carPositions = mutableMapOf<String, String>()
//
//    println("Enter the names of the cars (comma-separated):")
//    val inputNames = Console.readLine()?.split(",")?.map { it.trim() }
//    if (inputNames.isNullOrEmpty() || inputNames.any { it.length > 5 || it.any { char -> !char.isLetter() } }) {
//        throw IllegalArgumentException("Invalid input: Car names must be comma-separated, max 5 characters, and contain only letters.")
//    }
//    cars.addAll(inputNames)
//
//    println("Please input the number of rounds: ")
//    val numberOfRounds = Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input: Rounds must be a positive integer.")
//
//    cars.forEach { carPositions[it] = "" }
//
//    for (round in 1..numberOfRounds) {
//        cars.forEach {
//            val randomNumber = Randoms.pickNumberInRange(0, 9)
//            println("number is: $randomNumber")
//
//            if (randomNumber >= 4) carPositions[it] = carPositions[it]!! + "-"
//        }
//
//        carPositions.forEach { (car, track) -> println("$car : $track") }
//    }
//
//    val maxDistanceCovered = carPositions.values.maxOf { it.length }
//    val winners = carPositions.filterValues { it.length == maxDistanceCovered }.keys
//    println("Winners : ${winners.joinToString(", ")}")
//}