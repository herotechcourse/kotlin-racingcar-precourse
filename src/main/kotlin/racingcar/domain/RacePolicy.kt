package racingcar.domain

interface RacePolicy {
    fun canMove(car: Car, number: Int): Boolean
}

