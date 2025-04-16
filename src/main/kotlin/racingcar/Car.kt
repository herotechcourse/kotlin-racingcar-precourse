package racingcar

class Car {
    var name: String = ""
        private set
    var progress: Int = 0
        private set

    fun setCarName(name: String) {
        this.name = name
    }

    fun increaseProgress() {
        this.progress++
    }
}