package racingcar

class GameLogic (
    private val carsList: List<Car>,
    private val numberOfRounds: Int) {

    fun play() {
        for (round in 1..numberOfRounds) {
            carsList.forEach{it.move()}
        }
        ResultView.displayEndPositions(carsList)
    }

}