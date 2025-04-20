package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program

    // 1. Get car names
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine().split(",").map { it.trim() }

    // 2. Validate car names
    for (name in carNames) {
        if (name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException("Each car must have a name and max 5 characters!")
        }
    }
    // 3. Get number of rounds
    println("How many rounds will be played?")
    val rounds = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a valid number!")

    // 4. Create positions list (outside any loop!)
    val positions = MutableList(carNames.size) { 0 }

    // 5. Loop through rounds and move cars
    println("Race Results")
    for (round in 1..rounds) {
        for (i in carNames.indices) {
            val move = Randoms.pickNumberInRange(0, 9)
            if (move >= 4) {
                positions[i]++
            }
            println("${carNames[i]} : ${"-".repeat(positions[i])}")
        }
        println()
    }

    // 6. Determine winner(s)
    val maxPos = positions.maxOrNull() ?: 0
    val winners = carNames.filterIndexed { index, _ -> positions[index] == maxPos }

    println("Winners : ${winners.joinToString(", ")}")
}
