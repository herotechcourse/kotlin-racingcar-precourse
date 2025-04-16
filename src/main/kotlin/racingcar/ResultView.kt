package racingcar

object ResultView {
    fun displayEndPositions(carsList: List<Car>) {
        carsList.forEach { it.display() }
    }
}