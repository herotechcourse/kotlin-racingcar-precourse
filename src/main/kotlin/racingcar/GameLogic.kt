package racingcar

class GameLogic (
    private val carsList: List<Car>,
    private val numberOfRounds: Int) {

    fun play() {
        for (round in 1..numberOfRounds) {
            carsList.forEach{it.move()}
        }
        ResultView.displayEndPositions(carsList)
        val listWinners = getWinners()
        ResultView.printFinalWinners(listWinners)
    }

    private fun getWinners(): List<Car> {
        val winnersPosition = carsList.maxOf { it.position }
        val listWinners = carsList.filter { it.position == winnersPosition }
        return listWinners

    }
}