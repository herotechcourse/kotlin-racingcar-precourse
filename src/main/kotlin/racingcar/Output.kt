package racingcar

object Output {
    fun printResultsRound(results: List<List<RaceResult>>) {
        println("Race Results")
        results.forEach { round ->
            round.forEach { result ->
                val positionMarker = "-".repeat(result.position)
                println("${result.carName} : $positionMarker")
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}