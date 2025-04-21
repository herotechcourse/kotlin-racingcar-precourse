package racingcar.presentation

object OutputView {

    fun printPlay(roundPositions: List<List<Pair<String, Int>>>) {
        println()
        println("Race Results")

        roundPositions.forEachIndexed { index, snapshot ->
            snapshot.forEach { (name, position) ->
                println("$name : ${"-".repeat(position)}")
            }
            println()
        }
    }
}