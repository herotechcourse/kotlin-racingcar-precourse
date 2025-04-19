package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position:Int = 0

    fun move(){
        position++
    }
    fun printPosition(){
        println("$name: ${"-".repeat(position)}")
    }
}