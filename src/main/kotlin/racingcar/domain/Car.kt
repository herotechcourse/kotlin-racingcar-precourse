package racingcar.domain

class Car (
    val name: String,
    var position: Int = 0
) {
    fun move(randomNum: Int) {
        if (randomNum >= 4) {
            position++
        }
    }
}