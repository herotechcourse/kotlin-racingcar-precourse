/**
 * FixedRoundsRace configuration class
 */

package racingcar

import camp.nextstep.edu.missionutils.Console

/**
 * extension function to List<T>
 * Returns whether there are duplicates in the list.
 */
fun <T> List<T>.containsDuplicates() : Boolean {
    // source: https://stackoverflow.com/questions/47200440/kotlin-how-to-find-number-of-repeated-values-in-a-list#comment105915149_47200815
    return this.groupingBy { it }.eachCount().any { it.value > 1 }
}

/**
 * extension function to List<T>
 * Returns a pair of indices of the first duplicate elements in the list.
 * Returns Pair(-1, -1) if no duplicates exist in the list.
 */
fun <T> List<T>.firstDuplicatesIndices() : Pair<Int, Int> {
    for (i in this.indices.take(this.size - 1)) {
        val j = this.takeLast(this.size - i - 1).indexOfFirst { it == this[i] }
        if (j != -1) {
            return Pair(i, i + j + 1)
        }
    }
    return Pair(-1, -1)
}

/**
 * FixedRoundsRace configuration class
 * Use factory methods as:
 *   FixedRoundsRaceConfiguration.from(namesString, nRoundsString)
 *   FixedRoundsRaceConfiguration.fromStdIn()
 */
class FixedRoundsRaceConfiguration private constructor(val carNames: List<String>, val nRounds: Int) {
    companion object Factory {
        private const val MAX_N_ROUNDS = 200

        private fun validateNamesSize(names: List<String>) {
            require(names.size >= 2) {
                "Number of names should be two or more"
            }
        }

        private fun isValidName(name: String) : Boolean {
            return (name.isNotEmpty() && (name.length <= 5))
        }

        private fun validateName(name: String, index: Int) {
            require(isValidName(name)) {
                "names[$index]: \"$name\": Length of each name must be 0 < length <= 5"
            }
        }

        private fun validateNoDuplicateNames(names: List<String>) {
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
            return ((nRounds > 0) && (nRounds <= MAX_N_ROUNDS))
        }

        private fun validateNRounds(nRounds: Int) {
            require(isValidNRounds(nRounds)) {
                "Number of rounds (= $nRounds) must be 0 < n <= $MAX_N_ROUNDS"
            }
        }

        /**
         * Returns a list of names, after parsing and validating [namesString].
         * Leading and trailing spaces in each name are ignored.
         * @throws IllegalArgumentException if [namesString] is invalid.
         */
        private fun parseNames(namesString: String) : List<String> {
            val names = namesString.split(',').map { it.trim() }
            validateNamesSize(names)
            names.mapIndexed { index, name -> validateName(name, index) }
            validateNoDuplicateNames(names)

            return names
        }

        /**
         * Returns number of rounds, after parsing and validating [nRoundsString].
         * @throws IllegalArgumentException if [nRoundsString] is invalid.
         */
        private fun parseNRounds(nRoundsString: String) : Int {
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
            validateNRounds(nRounds)

            return nRounds
        }

        /**
         * Factory function which validates input and returns FixedRoundsRaceConfiguration object.
         */
        fun from(namesString: String, nRoundsString: String) : FixedRoundsRaceConfiguration {
            val names = parseNames(namesString)
            val nRounds = parseNRounds(nRoundsString)

            return FixedRoundsRaceConfiguration(names, nRounds)
        }

        /**
         * Factory function which returns FixedRoundsRaceConfiguration object from user input via standard input.
         */
        fun fromStdIn() : FixedRoundsRaceConfiguration {
            println("Please enter car names(max 5 letters), separated by comma(,):")
            val names = parseNames(Console.readLine())

            println("Please enter number of rounds(> 0):")
            val nRounds = parseNRounds(Console.readLine())

            return FixedRoundsRaceConfiguration(names, nRounds)
        }
    }
}
