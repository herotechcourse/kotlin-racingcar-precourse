
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0)

fun main() {
    // validating car names
    try{
        println("Enter car names (comma-seperated, max 5 characters each name):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim()}

        if (names.isEmpty()) throw IllegalArgumentException("You didn't provide any car names.")

        val cars = names.map { name ->
            if (name.isEmpty() || name.length > 5)
                throw IllegalArgumentException("Invalid car name: '$name'")
            Car(name)
        }
        // Validate number of rounds
        println("Enter number of rounds:")
        val roundsInput = Console.readLine()
        val rounds = roundsInput.toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a number.")
        if (rounds <= 0) throw IllegalArgumentException("Rounds must be greater than 0.")
        println("\nRace Start!\n")

        // Run game for number of rounds
        repeat(rounds) {
            for (car in cars) {
                val move = Randoms.pickNumberInRange(0, 9)
                if (move >= 4) {
                    car.position += 1
                }
            }
        }
