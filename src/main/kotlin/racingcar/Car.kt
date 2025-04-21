package racingcar

class Car(val name: String){
    //1.car start from 0
    //2.car moves when the randomly generated value >= 4,

    private var position: Int = 0

    fun moveForward(){
        position++
    }

    fun getPosition(): Int = position
}