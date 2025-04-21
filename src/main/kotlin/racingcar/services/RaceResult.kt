package racingcar.services

class RaceResult(private val results: Map<String, Int>) {

    private val maxScore: Int = results.values.maxOrNull() ?: 0
    private val winners: Set<String> = results.filterValues { it == maxScore }.keys

    fun printAllResults() {
        for ((name, score) in results) {
            println("$name : ${"-".repeat(score)}")
        }
    }

    fun printWinners() = println("Winners : ${winners.joinToString(", ")}")

}