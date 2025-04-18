package racingcar.domain

class Race (private val cars: List<Car>) {
    fun runRound(){
        cars.forEach { it.move() }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
    }
    
    fun getCars(): List<Car> = cars
}