package racingcar

class Car(
    val name: String,
) {
    val position = 0

    fun move() {
        position += 1
    }
}
