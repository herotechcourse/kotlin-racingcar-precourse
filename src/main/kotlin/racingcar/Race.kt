package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun printRound(carData: Map<String, Int>) {
    carData.forEach {
        val moves = if (it.value > 0) "-".repeat(it.value) else ""
        println("${it.key} : $moves")
    }
    println(" ")
}
