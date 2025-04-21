package racingcar.model

class Winner(val cars: List<Car>) {
    var winners: MutableList<Car> = mutableListOf()

    fun findWinners() {
        for (car in cars) {
            if (winners.isEmpty()) {
                winners.add(car)
                continue
            }
            if (car.position > winners.last().position) {
                winners.clear()
                winners.add(car)
            } else if (car.position == winners.last().position) {
                winners.add(car)
            } else if (car.position < winners.last().position && winners.size > 1) {
                winners.removeLast()
            } else {
                continue
            }
        }
    }

    fun displayWinners() {
        print("Winners : " + winners.joinToString(", ") { it.name })
    }

}