package racingcar

class Car(
    val name: String,
    private val randomNumberGenerator: () -> Int = { camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) }
) {
    var movement = 0

    fun moveIfPossible() {
        if (randomNumberGenerator() >= 4) {
            movement++
        }
    }
}