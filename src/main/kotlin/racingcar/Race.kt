package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun printRound(carData: Map<String, Int>) {
    carData.forEach {
        val moves = if (it.value > 0) "-".repeat(it.value) else ""
        println("${it.key} : $moves")
    }
    println(" ")
}

fun getCarMove(rand: Int): Int {
    println(rand)
    return if (rand < 4) 0 else 1
}

fun startRound(carsData: Map<String, Int>): Map<String, Int> {
    val round = carsData.mapValues {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        it.value + getCarMove(randomNumber)
    }
    printRound(round)
    return round
}

fun getWinners(cars: Map<String, Int>) {
    val maxMoves = cars.maxOfWith(compareBy { it }) { it.value }
    val winners = cars.filter { it.value >= maxMoves }.keys
    println("Winners : ${winners.joinToString(separator = ", ") { item -> item }}")
}

fun race(cars: Map<String, Int>, rounds: Int) {
    println("Race Results")
    var raceState = cars
    for (i in 1 .. rounds) {
        raceState = startRound(raceState)
    }
    getWinners(raceState)
}