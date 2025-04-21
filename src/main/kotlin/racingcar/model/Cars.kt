package racingcar.model

class Cars(
    carNames: List<String>,
    intGeneratorStrategy: IntGeneratorStrategy
) {
    private val cars: List<Car> = carNames.map { Car(it, intGeneratorStrategy) }

    fun requestCarMove() {
        cars.forEach { it.tryMove() }
    }

    fun getCars(): List<Car> = cars

    val longestPosition: Int
        get() = cars.maxOfOrNull { it.position } ?: 0
}
