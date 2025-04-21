package racingcar.domain

class Round(val round: Int) {
    companion object {
        fun from(input: String): Round {
            val number = input.toIntOrNull()
                ?: throw IllegalArgumentException("Round must be numeric")

            return Round(number)
        }
    }

    init {
        require(round > 0) { "Round must be a positive number" }
    }
}