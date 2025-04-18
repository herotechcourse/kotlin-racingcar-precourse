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