package racingcar.util

class Output {
    fun printResultPhrase() {
        println("Race Results");
    }

    fun printRoundResult(result: List<String>) {
        println(result.joinToString("\n"));
        println();
    }

    fun printWinners(winners: List<String>) {
        print("Winners : ");
        print(winners.joinToString(", "));
    }
}