package racingcar.view

import racingcar.model.Round

data class RoundResultDto(
    val roundResultForOutput: List<String>
) {
    companion object {
        private val roundResult: MutableList<String> = mutableListOf()

        fun of(round: Round): RoundResultDto {
            round.getRoundResult().forEach { (car, status) ->
                val dashes = "-".repeat(status)
                roundResult.add("${car.name} : $dashes")
            }
            return RoundResultDto(roundResult)
        }
    }
}
