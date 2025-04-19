package racingcar

class Race(
    private val cars: List<Car>,
    private val rounds: Int,
    private var result: List<Car>? = null,
){
    fun play() {
        for (i in 0..< rounds) {
            cars.forEach { car ->
                car.move()
                displayRound(car)
            }
            println()

            // save result if it is the last round
            if (i == rounds - 1) {
                result = cars
            }
        }
    }

    private fun displayRound(car: Car) {
        val dashes = "-".repeat(car.distance)
        println(car.name + " : " + dashes)
    }
}