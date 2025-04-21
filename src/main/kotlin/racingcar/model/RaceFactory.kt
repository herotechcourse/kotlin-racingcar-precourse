package racingcar.model

object RaceFactory {

    private const val MAX_NAME_COUNT = 10
    private const val MAX_ROUND_COUNT = 100
    private const val MIN_ROUND_COUNT = 1

    fun create(names: List<String>, roundCount: Int): Race {
        validateNames(names)
        validateRounds(roundCount)

        return Race(Cars(names.map { Car(Name(it)) }), Rounds(roundCount))
    }

    private fun validateNames(names: List<String>) {
        require(names.isNotEmpty()) { "At least one car is required." }
        require(names.size <= MAX_NAME_COUNT) { "Car count must not exceed $MAX_NAME_COUNT." }
        require(names.distinct().size == names.size) { "Car names must be unique." }
    }

    private fun validateRounds(roundCount: Int) {
        require(roundCount in MIN_ROUND_COUNT..MAX_ROUND_COUNT) {
            "Round count must be between $MIN_ROUND_COUNT and $MAX_ROUND_COUNT"
        }
    }
}
