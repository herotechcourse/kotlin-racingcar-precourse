package racingcar.domain

class Round(val value: Int) {
    companion object {
        fun from(input: String): Round {
            val number = input.toIntOrNull()
                ?: throw IllegalArgumentException("Round must be positive integer")

            return Round(number)
        }
    }

    init {
        require(value > 0) { "Round must be positive integer" }
    }
}