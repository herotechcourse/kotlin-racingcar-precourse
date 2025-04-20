package racingcar

class Board {
    var cars: List<Car> = listOf()

    // Set cars
    fun setCars(newCars: List<Car>) {
        cars = newCars
    }
}