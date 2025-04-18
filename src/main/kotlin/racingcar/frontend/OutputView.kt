package racingcar.frontend

import racingcar.backend.dto.RaceResponse

object OutputView {
    private const val CARS_NAME_INPUT_MESSAGE = "Enter the names of the cars (comma-separated):"
    private const val RACE_COUNT_INPUT_MESSAGE = "How many rounds will be played?"
    private const val RACE_RESULTS = "Race Results"

    fun printCarNamesRequest() = println(CARS_NAME_INPUT_MESSAGE)

    fun printRaceCountRequest() = println(RACE_COUNT_INPUT_MESSAGE)

    fun printRaceResultResponse(raceResponse: RaceResponse) {
        println()
        println(RACE_RESULTS)
        repeat(raceResponse.roundNum) { round ->
            raceResponse.raceResultList.forEach { raceResult ->
                println("${raceResult.carName} : ${raceResult.positions[round]}")
            }
            println()
        }
    }

    fun printWinnersResponse(raceResponse: RaceResponse) {
        println("Winners : ${raceResponse.winnerList.joinToString(", ")}")
    }
}