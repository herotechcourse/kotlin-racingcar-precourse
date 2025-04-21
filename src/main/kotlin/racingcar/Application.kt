package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class CarName(val name: String) {
    var CarMove = ""
}

fun main() {
    println("Please write the car name. Separated by commas. 5letter or less")
    val carName = Console.readLine() // 변경: Console 사용
    val list = carName.split(",")

    for (i in 0..list.size-1) {
        if (list[i].length > 5) {
            throw IllegalArgumentException()
        }
    }

    val round = Console.readLine()?.toInt() ?: 0 
    val carList = mutableListOf<CarName>()

    for (i in 0..list.size-1) {
        carList.add(CarName(list[i]))
    }

    var z = 0
    while (z in 0..round-1) {
        for (j in 0..carList.size - 1) {
            val num = Randoms.pickNumberInRange(0, 9)
            if (num >= 4) {
                carList[j].CarMove += "-"
            }
        }
        for (car in carList) {
            println("${car.name} : ${car.CarMove}")
        }
        z++
    }

    val maxMove = carList.maxOf { it.CarMove.length }
    val winners = carList.filter { it.CarMove.length == maxMove }
    println("Winners : " + winners.joinToString(", ") { it.name })
}
