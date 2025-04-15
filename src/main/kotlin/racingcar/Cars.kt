package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Cars(private val cars: List<Car>) {

    fun moveAll() {
        cars.forEach { car ->
            val number = Randoms.pickNumberInRange(0, 9)
            car.move(number >= 4)
        }
    }

    fun printRound() {
        cars.forEach { car ->
            println(car.printProgress())
        }
        println()
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: return emptyList()
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun fromNames(input: String): Cars {
            val carList = input.split(",")
                .map { it.trim() }
                .map { Car.create(it) }
            return Cars(carList)
        }
    }
}
