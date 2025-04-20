package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String){
    var position = 0

    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }

    fun moveIfLucky() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) position++
    }
}