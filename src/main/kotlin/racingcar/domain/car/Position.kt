package racingcar.domain.car

class Position(val position: Int = 0) {
    
    fun increase(): Position {
        return Position(position + INCREMENT)
    }

    companion object {
        private const val INCREMENT: Int = 1
    }
}
