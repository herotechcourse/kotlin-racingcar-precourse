package racingcar.storage

class Car(val name: String) {
    var distance: Int = 0
        private set

    fun move() {
        distance++;
    }
}