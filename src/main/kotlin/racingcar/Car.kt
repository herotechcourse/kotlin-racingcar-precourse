package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val carName:String) {
    private var speed :Int = 0
    private val movement = mutableListOf<Char>()
    var displacement = 0

    private fun getSpeed() {
        speed = Randoms.pickNumberInRange(0, 9)
    }

    fun moveCar() {
        getSpeed()
        if (speed >= 4) {
            movement.add('-')
            displacement++
        }
        println("$carName : ${movement.joinToString("")}")
    }

    //for testing the moveCar()
    fun forceMove(carSpeed: Int) {
        if (carSpeed >= 4) {
            movement.add('-')
            displacement++
        }
    }
}