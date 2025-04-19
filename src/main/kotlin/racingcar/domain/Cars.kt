package racingcar.domain

class Cars {

    private val carList: MutableList<Car> = mutableListOf()

    fun add(car: Car) {
        carList.add(car)
    }

    fun moveAll() {
        carList.forEach { it.move() }
    }

    fun showAll() {
        carList.forEach { it.show() }
        println()
    }

    fun getWinners(): List<String> {
        val maxDistance = carList.maxOfOrNull { it.getDistance() } ?: 0
        return carList.filter { it.getDistance() == maxDistance }
            .map { it.getName() }
    }
}