package racingcar.domain

data class Round(val index: Int, val cars: Cars) {

    init {
        require(index > 0) { "Round index must be a positive number." }
    }

    val winners: Cars
        get() = cars.getMostMovedCar()

    override fun toString(): String {
        return StringBuilder().apply {
            cars.toList().forEach { car ->
                append("${car.name} : ${"-".repeat(car.position)}\n")
            }
        }.toString()
    }
}
