package racingcar.view

object ResultView {

    fun printResultTitle() {
        println("\n실행 결과") // This is "Execution result" in Korean
    }

    fun printRoundResult(roundResult: Map<String, Int>) {
        for ((car, position) in roundResult) {
            println("${car} : ${"-".repeat(position)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}
