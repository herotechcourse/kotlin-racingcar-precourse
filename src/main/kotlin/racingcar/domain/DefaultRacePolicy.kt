package racingcar.domain

class DefaultRacePolicy : RacePolicy {
    override fun canMove(number: Int): Boolean = number >= FORWARD_CONDITION

    companion object {
        private const val FORWARD_CONDITION = 4
    }
}
