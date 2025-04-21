package racingcar.domain
import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String,
    private var position: Int = 0,
    private val randomGenerator: () -> Int = { Randoms.pickNumberInRange(0, 9) }) {
    init {
        require(name.isNotEmpty() && name.length <= 5) { "Car name must be between 1 and 5 characters" }
    }

    fun moveIfRandomNumberIsOverFour(){
        if(randomGenerator() >= 4){
            moveForward()
        }
    }

    private fun moveForward() = position++

    fun getPosition(): Int = position
}
