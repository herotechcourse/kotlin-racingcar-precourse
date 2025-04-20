package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val MOVE_THRESHOLD = 4

class Car(name: String) {
    private val _name: String = name
    val name: String
        get() = _name

    private var _movedRounds: Int = 0
    val movedRounds: Int
        get() = _movedRounds

    fun runRound() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            _movedRounds++
        }
    }

    fun printStatus() {
        println("$name: ${"-".repeat(_movedRounds)}")
    }
}

fun main() {
    // TODO: Implement the program

    val testCars = mutableListOf<Car>().apply {
        add(Car("test"))
        add(Car("test2"))
        // 필요하다면 더 추가…
    }

    for (i in 1..10) {
        for (car in testCars) {
            car.runRound()
            car.printStatus()
        }
    }
}
