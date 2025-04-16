package racingcar

object CarFactoring {

    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }
}