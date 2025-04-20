package racingcar.domain.car

class Position(val value: Int = 0) {

    fun increase(): Position {
        return Position(value + INCREMENT)
    }

    companion object {
        private const val INCREMENT: Int = 1
    }
}
