package racingcar

class Car {
    var name: String = ""
        private set
    var position: Int = 0
        private set

    fun setCarName(name: String) {
        this.name = name
    }

    fun increasePosition() {
        this.position++
    }
}