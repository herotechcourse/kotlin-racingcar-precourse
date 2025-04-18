package racingcar

class UserInput {
    var carNames = mutableListOf<String>()
        private set
    var rounds: Int = 0
        private set

    fun setCarNamesFromInput(input: String) {
        val names = input.split(",").map { it.trim() }

        for (name in names) {
            require(name.isNotBlank()) { "Car names cannot be blank" }
            require(name.length <= 5) { "Car name '$name' is too long (max 5 characters)" }
        }

        this.carNames = names.toMutableList()
    }

    fun setRoundsFromInput(input: String) {
        val parsedRounds = input.toIntOrNull()

        require(parsedRounds != null) { "Input must be a valid number" }
        require(parsedRounds >= 1) { "Round value must be at least 1" }

        this.rounds = parsedRounds
    }
}