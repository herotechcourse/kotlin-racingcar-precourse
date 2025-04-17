package racingcar.view

import racingcar.model.Round

data class RoundResultDto(
    val roundResultForOutput: List<String>
) {
    companion object {
        fun of(round: Round): RoundResultDto {
            val roundResult: MutableList<String> = mutableListOf()
            round.getRoundResult().forEach { (car, status) ->
                val dashes = "-".repeat(status)
                roundResult.add("${car.name} : $dashes")
            }
            return RoundResultDto(roundResult)
        }
    }
}
