package racingcar

class Car(
    val name: String,
) {
    var position = 0

    fun move() {
        position += 1
    }
}
