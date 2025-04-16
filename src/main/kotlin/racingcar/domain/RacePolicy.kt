package racingcar.domain

class RacePolicy {

    fun canMove(number: Int): Boolean = number >= FORWARD_CONDITION

    companion object {
        private const val FORWARD_CONDITION = 4
    }
}
