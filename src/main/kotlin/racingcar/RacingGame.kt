package racingcar

import camp.nextstep.edu.missionutils.Randoms


class RacingGame(
    private val carNames: List<String>,
    private val roundCount: Int,
    private val io: IOInterface,
) {
    fun start() {
        val cars = carNames.map { Car(it) }

        io.print("Race Results")

        repeat(roundCount) {
            val random = Randoms.pickNumberInRange(0, 9)
            cars.forEach { it.move(random) }
            cars.forEach { io.print(it.display()) }
        }
    }
}
