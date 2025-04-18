package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String){
    init {
        require(name.isNotBlank()){"Car name cannot be Blank"}
        require(name.length<=5){"Car name cannot exceed 5 characters"}
    }


    private  var position = 0

    fun move(){
        if (Randoms.pickNumberInRange(0,9)>=4){
            position++
        }
    }

    fun getPosition():Int = position

}