package racingcar.model

// Responsible for moving all cars together
class Cars(private val cars: List<Car>) {

    // moveCars gets a list of random numbers
    // if a number is 4 or higher, the car at that index moves forward
    fun moveCars(numbers: List<Int>) {
        for (i in cars.indices) {  // loop through all car indexes
            val number = numbers[i]
            if (number >= 4) {
                cars[i].move()
            }
        }
    }

    // returns a copy of the car list so the outside can't change the original
    fun getCars(): List<Car> {
        return cars.toList()
    }
}
