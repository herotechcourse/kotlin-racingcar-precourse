package racingcar.fixture

class CarMovementFixtureBuilder {
    private val values = mutableListOf<Int>()

    fun round(vararg decisions: Boolean): CarMovementFixtureBuilder {
        decisions.forEach { move ->
            values += if (move) MOVING_FORWARD else STOP
        }
        return this
    }

    fun build(): Pair<Int, Array<Int>> {
        val first = values.first()
        val rest = values.drop(1)
        return Pair(first, rest.toTypedArray())
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}