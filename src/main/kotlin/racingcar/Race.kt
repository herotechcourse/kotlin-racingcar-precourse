package racingcar

class Race(private val cars: List<Car>) {

    fun playOneRound(randomNumberProvider: () -> Int) {
        cars.forEach { car ->
            val number = randomNumberProvider()
            car.move(number)
        }
    }

    fun getWinners(): List<Car> {
        val max = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == max }
    }

    fun getCars(): List<Car> = cars
}
