package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame(private val carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun play(rounds: Int) {
        repeat(rounds) {
            cars.forEach {
                it.move()
                println("${it.name}: ${"-".repeat(it.position)}")
            }
            println()
        }
    }
}
