package racingcar

object Output {
    fun printResultsRound(results: List<RaceResult>) {
        println("Race Results")
        results.forEach { result ->
            val positionMarker = "-".repeat(result.position)
            println("${result.carName} : $positionMarker")
        }
        println("\n")
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}