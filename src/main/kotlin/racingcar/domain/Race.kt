package racingcar.domain

class Race(private val cars: List<RacingCar>) {
    fun playAllGrounds() {
        cars.forEach { it.run() }
    }

    fun getWinners() : List<RacingCar> {
        val maxPos = cars.maxOf { it.pos }
        return cars.filter { it.pos == maxPos }
    }

    fun getCars(): List<RacingCar> = cars
}
