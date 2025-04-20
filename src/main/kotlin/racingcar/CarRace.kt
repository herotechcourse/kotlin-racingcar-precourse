package racingcar

import camp.nextstep.edu.missionutils.Randoms


class Car(name: String) {
    val name: String

    init {
        require(name.trim().length <= 5) { "Car name '$name' cannot exceed 5 characters." }
        this.name = name.trim()
    }

    var position: Int = 0
        private set

    fun move(increment: Int) {
        if (increment >= 4) {
            position++
        }
    }

    fun display(): String {
        return "$name : ${"-".repeat(position)}"
    }
}

class CarRace(carNames: List<Car>, private val nOfRounds: Int) {

    private var carMoves = hashMapOf<Car, Int>()

    init {
        for (c: Car in carNames) {
            carMoves[c] = 0
        }
    }

    private fun moveCar() {
        for (k in carMoves.keys) {
            val increment = Randoms.pickNumberInRange(0, 9)
            k.move(increment)
            carMoves[k] = k.position
        }

        for (k in carMoves.keys) {
            println(k.display())
        }
    }


    fun play() {
        println("Race Results")
        for (i: Int in 1..nOfRounds) {
            this.moveCar()
            println()
        }
    }

    fun getWinners(): String {
        val winningMap = carMoves.toList().sortedByDescending { (_, value) -> value }.toMap()
        var winners = winningMap.keys.first().name
        val refVal = winningMap.values.first()

        for ((k, v) in winningMap) {
            if (k == winningMap.keys.first() && v == winningMap.values.first()) {
                continue
            }

            if (v == refVal) {
                winners = "$winners, ${k.name}"
            } else {
                break
            }

        }
        return winners
    }

}