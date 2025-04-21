package racingcar.model

class Winner(val cars: List<Car>) {
    var winners: MutableList<Car> = mutableListOf()

    fun findWinners() {
        val max = cars.maxOfOrNull { it.position }

        for (car in cars) {
            if (car.position == max) {
                winners.add(car)
            }
        }
    }

    fun displayWinners() {
        print("Winners : " + winners.joinToString(", ") { it.name })
    }

}