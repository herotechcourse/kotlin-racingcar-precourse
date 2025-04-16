package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String,
) {
    var position = 0

    fun move() {
        position += 1
    }

    companion object {
        fun isValidName(name: String): Boolean = name.length <= 5
    }

    override fun toString(): String = "Car(name='$name', position=$position)"

    fun luckyMove() {
        val randomNumber = Randoms.pickNumberInRange()
        val threashold = 4
        if (randomNumber > threashold) {
            move()
        }
    }
}
