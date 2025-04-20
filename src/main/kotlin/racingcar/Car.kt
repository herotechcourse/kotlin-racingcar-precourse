package racingcar

data class Car(val name: String) {

}

fun convertToCars(carNames: List<String>): List<Car> {
    return carNames.map { Car(it) }
}