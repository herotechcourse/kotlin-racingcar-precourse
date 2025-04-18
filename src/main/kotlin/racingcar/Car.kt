package racingcar

data class Car(val name: String, var distance: Int = 0) {

    fun moveIfPossible(num: Int) {
        if (num >= 4) {
            distance += 1
        }
    }

    fun render(): String {
        return "$name : ${"-".repeat(distance)}"
    }

}

fun makeCarList(carNames: List<String>): List<Car> {
    return carNames.map { Car(it) }
}