package racingcar.model

data class Car(val name:String) {
    var position = 0

    fun moveForward() {
        position++
    }
}
