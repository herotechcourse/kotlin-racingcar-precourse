package racingcar.domain

data class Position(val value: Int) {
    fun increase(): Position {
        return Position(value + 1)
    }
}
