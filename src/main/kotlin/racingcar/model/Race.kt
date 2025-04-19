package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>) {
    fun play(rounds: Int): List<List<Car>> {
        val history = mutableListOf<List<Car>>()

        repeat(rounds) {
            cars.forEach { car ->
                val number = Randoms.pickNumberInRange(0, 9)
                car.move(number)
            }
            history.add(cars.map {Car(it.name).apply{repeat(it.position) {move(4)}}})
        }
        return history
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.name }
    }
}