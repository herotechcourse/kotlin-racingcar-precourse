package racingcar

package racingcar


class Car(val name: String) {
    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("Car name cannot be empty.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters.")
        }
    }
}

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine()
    val cars = createCars(carNames)
}

private fun createCars(carNames: String): List<Car> {
    val names = carNames.split(",").map { it.trim() }
    validateCarNames(names)
    return names.map { Car(it) }
}

private fun validateCarNames(names: List<String>) {
    if (names.isEmpty()) {
        throw IllegalArgumentException("Car names cannot be empty.")
    }
    if (names.any { it.isBlank() }) {
        throw IllegalArgumentException("Car name cannot be empty.")
    }
    if (names.any { it.length > 5 }) {
        throw IllegalArgumentException("Car name cannot exceed 5 characters.")
    }
    if (names.distinct().size != names.size) {
        throw IllegalArgumentException("Car names cannot be duplicated.")
    }
}

