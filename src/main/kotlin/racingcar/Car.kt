package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name:String){
    var position = 0

    fun move(){
        val randomNumber = Randoms.pickNumberInRange(0,9)
        if (randomNumber >= 4){
            position++
        }
    }
    fun printPosition(){
        println("$name : ${"-".repeat(position)}")
    }
}