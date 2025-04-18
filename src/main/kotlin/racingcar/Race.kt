package racingcar

class Race(
    private val cars: List<Car>,
    private val numberGenerator: NumberGenerator
) {

    fun run(rounds: Int) {
        repeat(rounds) {
            cars.forEach { car ->
                val number = numberGenerator.generate()
                car.move(number)
            }
        }
    }

    fun getWinners(): List<Car> {
        if (cars.isEmpty()) return emptyList()
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }


    fun getCars(): List<Car> = cars
}
