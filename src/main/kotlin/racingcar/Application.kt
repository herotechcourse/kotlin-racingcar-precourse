package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    val cars = getCarNames()
    val rounds = getRounds()

    repeat(rounds) {
        moveCar(cars)
    }

    getWinner(cars)
}


fun getCarNames(): MutableMap<String, String> {
    val cars = mutableMapOf<String, String>()
    println("Enter the names of the cars (comma-separated):")
    Console.readLine().split(',').map{ it.trim()
     }.map{
        cars[it] = ""
    }
    if (cars.any { it.key.isBlank() || it.key.length > 5 }) {
        throw IllegalArgumentException("Car names should be 1–5 characters.")
    }
    return cars
}

fun getRounds(): Int {
    println("How many rounds will be played?")
    val rounds =  Console.readLine().toInt()
    if (rounds <= 0) throw IllegalArgumentException("Rounds should be at least 1 or more.")
    return rounds
}

fun moveCar(cars: MutableMap<String, String>) {
    for(car in cars) {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            cars[car.key] += "-"
        }
        println("${car.key} : ${car.value}")
    }
}

fun getWinner(cars: MutableMap<String, String>) {
    val winner = mutableListOf<String>()
    val winnerScore: Int = cars.maxOf { it.value.length }
    for(car in cars) {
        if(car.value.length == winnerScore) {
            winner.add(car.key)

        }
    }
    println("Winners : ${winner.joinToString { it }}")
}