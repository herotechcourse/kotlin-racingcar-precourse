package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position:Int = 0

    fun getPositionInSting():String{
        return "$name: ${"-".repeat(position)}"
    }

    fun printPosition(){
        println(getPositionInSting())
    }
}