package racingcar

object InputParser {
    fun parseNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        if (names.any { it.isEmpty() }) {
            throw IllegalArgumentException("이름은 빈 문자열일 수 없습니다.")
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("이름은 5자를 초과할 수 없습니다.")
        }
        return names
    }

    fun parseRounds(input: String): Int {
        val rounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("라운드 수는 숫자여야 합니다.")
        if (rounds <= 0) {
            throw IllegalArgumentException("라운드 수는 1 이상이어야 합니다.")
        }
        return rounds
    }
}

