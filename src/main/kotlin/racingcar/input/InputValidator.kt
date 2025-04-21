package racingcar.input

/**
 * InputValidator is responsible for validating user inputs such as
 * car names and the number of racing rounds.
 * @throws IllegalArgumentException if any invalid
 */
object InputValidator {
	private const val MAX_CAR_NAME_LENGTH = 5
	private const val MIN_ROUND_COUNT = 1

	/**
	 * Validates a list of car names.
	 *
	 * @param names the list of car names entered by the user
	 * @return the validated list of names (unchanged)
	 * @throws IllegalArgumentException if any name is invalid
	 */
	fun validateNames(names : List<String>): List<String> {
		validateAnyEmptyNames(names)
		validateNoDuplicateNames(names)
		validateName(names)
		return names
	}

	/**
	 * Checks whether the provided list of car names is valid in terms of existence and non-emptiness.
	 * This method ensures:
	 * - At least one car name is provided
	 * - No name in the list is empty (e.g., "", " ")
	 * @param names list of names parsed from user input
	 * @throws IllegalArgumentException if the list is empty or contains blank names
	 */
	private fun validateAnyEmptyNames(names : List<String>) {
		if (names.isEmpty())
			throw IllegalArgumentException("At least one car name must be provided.")
		if (names.any { it.isEmpty() }) {
			throw IllegalArgumentException("Car name cannot be empty or blank.")
		}
	}

	/**
	 * Validates that there are no duplicate car names in the list, using case-insensitive comparison.
	 *
	 * Internally normalizes names to lowercase, groups them, and identifies duplicates.
	 * If duplicates are found, an informative error message listing the conflicting names is included.
	 *
	 * Example error message:
	 * ```
	 * Duplicate car names detected (case-insensitive):
	 * - "POBI", "pobi"
	 * - "jun", "JUN"
	 * Car names must be unique.
	 * ```
	 *
	 * @param names the original list of car names (user input)
	 * @throws IllegalArgumentException if any duplicate names exist (ignoring case)
	 */
	private fun validateNoDuplicateNames(names: List<String>) {
		val duplicates = extractDuplicateNames(names)

		if (duplicates.isNotEmpty()) {
			val message = formatDuplicateNamesMessage(duplicates)
			throw IllegalArgumentException(
				"Duplicate car names detected (case-insensitive):\n$message\nCar names must be unique."
			)
		}
	}

	/**
	 * Extracts case-insensitive duplicates from a list of names.
	 * @param names original user input (car names)
	 * @return a map where keys are lowercased names, and values are the original names that conflict
	 */
	private fun extractDuplicateNames(names: List<String>): Map<String, List<String>> {
		return names.groupBy { it.lowercase() }
			.filter { it.value.size > 1 }
	}

	/**
	 * Formats a multiline string listing grouped duplicate names.
	 * Example output:
	 * ```
	 * - "POBI", "pobi"
	 * - "JUN", "jun"
	 * ```
	 * @param duplicates a map where each key is the normalized name,
	 *                   and the value is a list of original names that conflicted
	 * @return formatted string for use in an error message
	 */
	private fun formatDuplicateNamesMessage(duplicates: Map<String, List<String>>): String {
		return duplicates.entries.joinToString("\n") { (_, group) ->
			"- " + group.joinToString(", ") { "\"$it\"" }
		}
	}

	/**
	 * Validates that the list is not empty and that
	 * all individual names meet validation rules.
	 * @throws IllegalArgumentException if any invalid
	 */
	private fun validateName(names: List<String>) {
		names.forEach { name -> validateSingleName(name) }
	}

	/**
	 * Validates a single car name for:
	 * - non-blank content
	 * - max length of 5
	 * - only alphanumeric characters (extra safety)
	 */
	private fun validateSingleName(name: String) {
		validateNotBlank(name)
		validateLength(name)
		validateAlphaNumeric(name)
	}

	/**
	 * Checks that the name is not blank.
	 * @throws IllegalArgumentException if name is blank
	 */
	private fun validateNotBlank(name: String) {
		if (name.isBlank()) throw IllegalArgumentException("Car name cannot be blank.")
	}

	/**
	 * Checks that the name is no longer than 5 characters.
	 * @throws IllegalArgumentException if name is too long
	 */
	private fun validateLength(name: String) {
		if (name.length > MAX_CAR_NAME_LENGTH) throw IllegalArgumentException("Car name must be 5 characters or fewer: '$name'")
	}

	/**
	 * Checks that the name contains only alphanumeric characters.
	 * @throws IllegalArgumentException if name has invalid characters
	 */
	private fun validateAlphaNumeric(name: String) {
		if (!isAlphaNumeric(name)) {
			throw IllegalArgumentException("Car name must only contain letters and numbers: '$name'")
		}
	}

	/**
	 * Returns true if the string contains only letters and numbers.
	 */
	private fun isAlphaNumeric(value: String): Boolean {
		return value.matches(Regex("^[a-zA-Z0-9]+$"))
	}

	/**
	 * Validates the number of rounds for the race.
	 *
	 * @param round the number of rounds entered by the user (1-based)
	 * @return the validated round number
	 * @throws IllegalArgumentException if the number is out of bounds ( MIN_ROUND_COUNT ~ MAX_ROUND_COUNT)
	 */
	fun validateRound(round: Int): Int {
		if (round < MIN_ROUND_COUNT) throw IllegalArgumentException("Round must be at least 1.")
		return round
	}
}
