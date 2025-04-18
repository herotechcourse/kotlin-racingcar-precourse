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