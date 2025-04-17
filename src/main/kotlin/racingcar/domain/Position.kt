package racingcar.domain

class Position private constructor(private val value: Int) {

    fun value(): Int = value

    fun forwarded(): Position = Position(value + 1)

    companion object {
        private const val INIT_POSITION = 0

        fun from(): Position = Position(INIT_POSITION)
    }
}
