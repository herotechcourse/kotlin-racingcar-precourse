package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    // username
    println("Enter the names of the cars (comma-separated): ")
    val input = Console.readLine().split(",")
    val carNames = input.map{ it.trim() }

    if (carNames.any { carName -> carName.isEmpty() || carName.length > 5 }){
        throw IllegalArgumentException("Each car must have a name, and names cannot exceed 5 characters.")
    }

    // rounds
    println("How many rounds will be played?")
    val rounds = Console.readLine().toIntOrNull()
    if (rounds == null || rounds <= 0){
        throw IllegalArgumentException("Please enter a valid number for play rounds.")
    }

    // final result
    println("Race Results")
    val cars = carNames.map{ carName -> Race(carName) }
    repeat(rounds){
        cars.forEach{car -> car.eachRaceMove()}
        cars.forEach{car -> println("${car.name} : ${"-".repeat(car.result)}") }
        println("")
    }

    val mostLine = cars.maxOf { car -> car.result }
    val winners = cars.filter{ car -> car.result == mostLine }.joinToString(", "){it.name}

    println("Winners : $winners")
}

// one round of racing per car
class Race(val name: String, var result: Int = 0){
    fun eachRaceMove(){
        var number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) result ++
    }
}
