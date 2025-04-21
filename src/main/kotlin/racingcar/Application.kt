package racingcar

val maxRounds: Int = Int.MAX_VALUE

fun main() {
    try {
        val names: List<String> = getInputNames()
        val cars: List<Car> = initializeCars(names)
        val game = Game(cars)
        val numRounds: Int = getInputRounds()
        game.play(numRounds)
    } catch (error: IllegalArgumentException) {
        println("Error: ${error.message}")
        throw error
    }
}

fun initializeCars(names: List<String>): List<Car> {
    return names.map { name -> Car(name) }
}
