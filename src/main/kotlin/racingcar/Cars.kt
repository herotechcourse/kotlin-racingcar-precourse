package racingcar

class Cars(private val cars: List<Car>) {

    fun moveAll() {
        cars.forEach { car ->
            val number = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9)
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
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun fromNames(input: String): Cars {
            val carList = input.split(",")
                .map { it.trim() }
                .map { Car(it) } // exception thrown here if invalid
            return Cars(carList)
        }
    }
}