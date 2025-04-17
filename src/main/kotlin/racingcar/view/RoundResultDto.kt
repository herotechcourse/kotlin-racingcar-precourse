package racingcar.view

import racingcar.model.Round

data class RoundResultDto(
    private val round: Round,
    private val roundResultForOutput: MutableList<String> = mutableListOf()
) {
    init {
        round.getRoundResult().forEach { (car, status) ->
            val dashes = "-".repeat(status)
            roundResultForOutput.add("${car.name} : $dashes")
        }
    }

    fun getRoundResultForOutput(): List<String> = roundResultForOutput
}
