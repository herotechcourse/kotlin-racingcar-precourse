/**
 * FixedRoundsRace configuration class
 */

package racingcar

import camp.nextstep.edu.missionutils.Console

/**
 * FixedRoundsRace configuration class
 * Use factory methods as:
 *   FixedRoundsRaceConfiguration.from(namesString, nRoundsString)
 *   FixedRoundsRaceConfiguration.fromStdIn()
 */
class FixedRoundsRaceConfiguration private constructor(val carNames: List<String>, val nRounds: Int) {
    companion object Factory {
        private val DEFAULT_VALIDATOR = FixedRoundsRaceConfigurationValidator

        /**
         * Returns a list of names, after parsing and validating [namesString].
         * Leading and trailing spaces in each name are ignored.
         * @throws IllegalArgumentException if [namesString] is invalid.
         */
        private fun parseNames(namesString: String, validator: FixedRoundsRaceConfigurationValidatorInterface) : List<String> {
            val names = namesString.split(',').map { it.trim() }
            validator.validateNamesSize(names)
            names.mapIndexed { index, name -> validator.validateName(name, index) }
            validator.validateNoDuplicateNames(names)

            return names
        }

        /**
         * Returns number of rounds, after parsing and validating [nRoundsString].
         * @throws IllegalArgumentException if [nRoundsString] is invalid.
         */
        private fun parseNRounds(nRoundsString: String, validator: FixedRoundsRaceConfigurationValidatorInterface) : Int {
            val nRounds: Int
            try {
                nRounds = nRoundsString.toInt()
            } catch (e: NumberFormatException) {
                /**
                 * Invalid cases caught:
                 * - [nRoundsString] is out of bounds (> max int: 2,147,483,647)
                 * - [nRoundsString] is a non-integer, e.g. float
                 * - [nRoundsString] contains non-digit characters
                 */
                throw IllegalArgumentException("Invalid value for number of rounds: \"$nRoundsString\"")
            } catch (e: Exception) {
                throw IllegalArgumentException("Invalid value for number of rounds: \"$nRoundsString\"")
            }
            validator.validateNRounds(nRounds)

            return nRounds
        }

        /**
         * Factory function which validates input and returns FixedRoundsRaceConfiguration object.
         */
        fun from(
            namesString: String,
            nRoundsString: String,
            validator: FixedRoundsRaceConfigurationValidatorInterface = this.DEFAULT_VALIDATOR
        ) : FixedRoundsRaceConfiguration {
            val names = parseNames(namesString, validator = validator)
            val nRounds = parseNRounds(nRoundsString, validator = validator)

            return FixedRoundsRaceConfiguration(names, nRounds)
        }

        /**
         * Factory function which returns FixedRoundsRaceConfiguration object from user input via standard input.
         */
        fun fromStdIn(
            validator: FixedRoundsRaceConfigurationValidatorInterface = this.DEFAULT_VALIDATOR
        ) : FixedRoundsRaceConfiguration {
            println("Please enter car names(${validator.MIN_CAR_NAME_LENGTH} <= length <= ${validator.MAX_CAR_NAME_LENGTH}), separated by comma(,):")
            val names = parseNames(Console.readLine(), validator = validator)

            println("Please enter number of rounds(${validator.MIN_N_ROUNDS} <= n <= ${validator.MAX_N_ROUNDS}):")
            val nRounds = parseNRounds(Console.readLine(), validator = validator)

            return FixedRoundsRaceConfiguration(names, nRounds)
        }
    }
}
