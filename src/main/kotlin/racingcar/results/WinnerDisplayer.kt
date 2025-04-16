package racingcar.results

class WinnerDisplayer {

    fun formatWinners(winnerNames: List<String>): String {
        return "Winners: ${winnerNames.joinToString(", ")}"
    }
}