package racingcar.view

import racingcar.model.Referee

data class WinnersDto(val winnersForOutput: String) {

    companion object {
        fun of(referee: Referee): WinnersDto {
            val winners = referee.getWinners().joinToString(", ") { it.name }
            return WinnersDto(winners)
        }
    }
}
