package racingcar.domain

class Cars(names: List<String>) {
    private val cars: List<Car> = names.map { Car(it) }

    init {
        validateDuplicate(names)
    }

    private fun validateDuplicate(names: List<String>) {
        if (names.size != names.toSet().size) {
            throw IllegalArgumentException("Duplicate car names are not allowed.")
        }
    }

    fun raceOnce() {
        cars.forEach { it.moveForward() }
    }
    fun getCarStates(): List<Pair<String, Int>> {
        return cars.map { it.name to it.position }
    }
    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: return emptyList()
        return cars.filter { it.position == maxPosition }
    }
    override fun toString(): String {
        return cars.joinToString("\n") { "${it.name} : ${"-".repeat(it.position)}" }
    }
}