package racingcar.view

import racingcar.model.decideMovement
import racingcar.model.makeRacingDistanceList


class OutputView {
    fun printCarRacingStartMessage() {
        println("")
        println("Race Results")
    }

    // TO-DO: Refactor structure
    fun printCarNamesAndProcess(carNames: List<String>, theNumberOfRound: Int) {
        val processInitialList: MutableList<Int> = makeRacingDistanceList(carNames)

        repeat(theNumberOfRound) {
            for ((index, value) in processInitialList.withIndex()) {
                if (decideMovement()) {
                    processInitialList[index] += 1
                }
                val processLine = "-".repeat(processInitialList[index])
                println("${carNames[index]} : $processLine")
            }
            println("")
        }

    }
}







