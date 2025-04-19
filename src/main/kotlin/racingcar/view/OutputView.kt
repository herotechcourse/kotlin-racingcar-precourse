package racingcar.view

object OutputView {

    fun showRacing() {
        println("Race Results")
    }

    fun showResult(winnerNames: List<String>) {
        println("Winners : " + winnerNames.joinToString(", "))
    }
}