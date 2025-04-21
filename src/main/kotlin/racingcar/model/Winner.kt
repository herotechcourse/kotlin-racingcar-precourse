package racingcar.model

class Winner(val cars: List<Car>) {
    var winners: List<Car> = emptyList()

    fun findWinners() {
        val max = cars.maxOfOrNull { it.position }
        winners = cars.filter { it.position == max }
    }

    fun displayWinners() {
        print("Winners : " + winners.joinToString(", ") { it.name })
    }

}