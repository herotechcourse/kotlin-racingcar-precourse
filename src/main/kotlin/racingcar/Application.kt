package racingcar

val maxRounds: Int = Int.MAX_VALUE

fun main() {
    val names: List<String> = getInputNames()
    val cars: List<Car> = initializeCars(names)
    val game = Game(cars)
    val numRounds: Int = getInputRounds()
    game.play(numRounds)
}

fun initializeCars(names: List<String>): List<Car> {
    return names.map { name -> Car(name) }
}
