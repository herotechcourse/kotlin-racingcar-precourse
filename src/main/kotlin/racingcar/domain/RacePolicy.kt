package racingcar.domain

interface RacePolicy {
    fun canMove(number: Int): Boolean
}

