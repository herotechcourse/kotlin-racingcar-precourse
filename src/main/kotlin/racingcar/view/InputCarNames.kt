package racingcar.view
import camp.nextstep.edu.missionutils.Console

object InputCarNames {
    fun invoke(): List<String> {
        println("Enter the names of the cars (comma-separated): ")
        val input = Console.readLine()
        val names = input.split(",")
            .map { it.trim() } //Trim spaces before and after each name
                .also { validateEmptyInput(it) }
        names.forEach { validateNameLength(it) }
        return names
    }

    private fun validateEmptyInput(names: List<String>) {
        if (names.isEmpty() || names.any { it.isBlank() }) {
            throw IllegalArgumentException("Car names cannot be blank")
        }
    }

    private fun validateNameLength(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("Car names must be 5 characters or fewer. Entered name: '$name'")
        }
    }
}
