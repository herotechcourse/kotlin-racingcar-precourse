package racingcar

import camp.nextstep.edu.missionutils.Randoms

val maxRounds: Int = Int.MAX_VALUE

fun main() {
    val names: List<String> = getUserInputNames()
    val cars: List<Car> = makeCars(names)

    val game = Game(cars)

    val numRounds: Int = getUserInputRounds()
    game.play(numRounds)
}

fun makeCars(names: List<String>): List<Car> {
    return names.map { name -> Car(name) }
}
