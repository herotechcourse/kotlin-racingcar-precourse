package racingcar.domain

class Round(val round: Int) {
    companion object {
        fun from(input: String): Round {
            val number = input.toIntOrNull()
                ?: throw IllegalArgumentException("Round must be a number")

            return Round(number)
        }
    }
}