package racingcar.domain

data class Rounds(private val rounds: List<Round> = listOf()) {
    fun getWinners(): Cars {
        return this.rounds.last().winners
    }

    override fun toString(): String {
        return StringBuilder().apply {
            rounds.forEach { round ->
                append(round.toString())
                append("\n")
            }
        }.toString()
    }

    fun add(round: Round) {

    }
}