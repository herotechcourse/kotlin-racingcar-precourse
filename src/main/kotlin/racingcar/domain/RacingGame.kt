package racingcar.domain

class RacingGame(private val cars: List<Car>) {

    fun play(rounds: Int, numberGenerator: () -> Int): List<List<Car>> {
        val result = mutableListOf<List<Car>>()

        repeat(rounds) {
            cars.forEach { it.move(numberGenerator()) }
            // 현재 상태 복사해서 저장 (참조 방지용)
            result.add(cars.map { Car(it.getName()).apply { repeat(it.position) { move(4) } } })
        }

        return result
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.getName() }
    }
}