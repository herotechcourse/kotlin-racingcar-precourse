package racingcar

fun displayProgress(gameTable: HashMap<String, Int>) {
    gameTable.forEach { (k, v) ->
        println("$k : ${"-".repeat(v)}")
    }
}

fun determineWinners(gameTable: HashMap<String, Int>): List<String> {
    val maxScore = gameTable.maxOf { it.value }
    return gameTable.filter { it.value == maxScore }.keys.toList()
}

fun displayWinners(winnersList: List<String>) {
    println("Winners : ${winnersList.joinToString(", ")}")
}