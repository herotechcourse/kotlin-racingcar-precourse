package racingcar.domain

data class Position(private val value: Int) {
    fun increase(): Position {
        return Position(value + 1)
    }

    fun toInt(): Int {
        return value
    }
}
