package racingcar.view

class OutputView {
    fun printRacingStartMessage() {
        println("")
        println("Race Results")
    }

    // TO-DO: Refactor separate for "-"
    fun printCarNamesAndProcess(carNames: List<String>, progressList: List<List<Int>>) {
        progressList.forEach { eachRoundProgress ->
            carNames.withIndex().forEach { (index, carName) ->
                println("$carName : ${"-".repeat(eachRoundProgress[index])}")
            }
            println("")
        }
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString()}")
    }
}

