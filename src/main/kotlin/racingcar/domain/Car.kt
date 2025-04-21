package racingcar.domain
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, private var position: Int = 0) {
    init {
        require(name.isNotEmpty() && name.length <= 5) { "Car name must be between 1 and 5 characters" }
    }

    private fun moveForward() = position++

    private fun getRandNumber():Int= Randoms.pickNumberInRange(0,9)

}