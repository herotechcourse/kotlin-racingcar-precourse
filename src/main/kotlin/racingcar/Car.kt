package racingcar

class Car(
    val name: String
) {
    var position: Int = 0
        private set

    fun moveForward(){
        this.position++
    }
}