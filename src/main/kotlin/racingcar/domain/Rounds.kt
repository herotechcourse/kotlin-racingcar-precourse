package racingcar.domain

data class Rounds(private val rounds: MutableList<Round> = mutableListOf()) {
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
        rounds.add(round)
    }

    fun toList(): List<Round> {
        return rounds.map { it.copy() }
    }
}