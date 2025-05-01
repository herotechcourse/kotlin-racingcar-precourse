/**
 * FixedRoundsRace configuration validator class
 */

package racingcar

interface FixedRoundsRaceConfigurationValidatorInterface {
    val MIN_N_CARS: Int
    val MIN_CAR_NAME_LENGTH: Int
    val MAX_CAR_NAME_LENGTH: Int
    val MIN_N_ROUNDS: Int
    val MAX_N_ROUNDS: Int

    fun validateNamesSize(names: List<String>)
    fun validateName(name: String, index: Int)
    fun validateNoDuplicateNames(names: List<String>)
    fun validateNRounds(nRounds: Int)
}

/**
 * FixedRoundsRace configuration validator class
 */
class FixedRoundsRaceConfigurationValidator() {
    companion object Validator : FixedRoundsRaceConfigurationValidatorInterface {
        override val MIN_N_CARS = 2
        override val MIN_CAR_NAME_LENGTH = 1
        override val MAX_CAR_NAME_LENGTH = 5
        override val MIN_N_ROUNDS = 1
        override val MAX_N_ROUNDS = 500

        override fun validateNamesSize(names: List<String>) {
            require(names.size >= MIN_N_CARS) {
                "Number of names should be $MIN_N_CARS or more"
            }
        }

        private fun isValidName(name: String) : Boolean {
            return ((name.length >= MIN_CAR_NAME_LENGTH) && (name.length <= MAX_CAR_NAME_LENGTH))
        }

        override fun validateName(name: String, index: Int) {
            require(isValidName(name)) {
                "names[$index]: \"$name\": Length of each name must be $MIN_CAR_NAME_LENGTH <= length <= $MAX_CAR_NAME_LENGTH"
            }
        }

        override fun validateNoDuplicateNames(names: List<String>) {
            val indices = names.firstDuplicatesIndices()
            if (indices.first != indices.second) {
                throw IllegalArgumentException("Duplicate car names: [${indices.first}] ${names[indices.first]}, [${indices.second}] ${names[indices.second]}")
            }
            // or, if error message need not includes indices of duplicates,
            // require(names.containsDuplicates()) {
            //    "Some names are identical."
            //}
        }

        private fun isValidNRounds(nRounds: Int) : Boolean {
            return ((nRounds >= MIN_N_ROUNDS) && (nRounds <= MAX_N_ROUNDS))
        }

        override fun validateNRounds(nRounds: Int) {
            require(isValidNRounds(nRounds)) {
                "Number of rounds (= $nRounds) must be $MIN_N_ROUNDS <= n <= $MAX_N_ROUNDS"
            }
        }
    }
}
