package racingcar

data class Car(val name: String, var position: Int = 0)

fun main() {
    // validating car names
    try{
        println("Enter car names (comma-seperated, max 5 characters each name):")
        val input = readLine() ?: throw IllegalArgumentException("No input provided.")
        val names = input.split(",").map { it.trim()}

        if (names.isEmpty()) throw IllegalArgumentException("You didn't provide any car names.")

        val cars = names.map { name ->
            if (name.isEmpty() || name.length > 5)
                throw IllegalArgumentException("Invalid car name: '$name'")
            Car(name)
        }
        // Validate number of rounds
        println("Enter number of rounds:")
        val roundsInput = readLine() ?: throw IllegalArgumentException("No input for rounds.")
        val rounds = roundsInput.toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a number.")
        println("\nRace Start!\n")
}