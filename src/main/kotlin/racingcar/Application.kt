package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// Represents a car with a name and current position in the race
data class Car( val name: String, var position : Int = 0 )

fun getNames(): List<String> {
    println("Please enter names of the cars separated by comma: ")

    val cars = Console.readLine().split(",").map { it.trim() } // learned I can use split method and map on the same variable

    if (cars.isEmpty() || cars.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("All cars must have a name up to 5 characters each")
    }

    return cars
}

// Prompts user to input number of rounds and returns a validated integer
fun getRounds(): Int {
    println("Please enter number of rounds: ")

    // Try converting input to integer; returns null on failure
    val rounds = Console.readLine().toIntOrNull()

    if (rounds == null || rounds < 1 ) {
        throw IllegalArgumentException("Rounds must be a positive integer")
    }
    return rounds
}

fun main() {

    val carNames = getNames()
    val rounds = getRounds()
    val cars: List<Car> = carNames.map { Car(it) }

    println()

    println("Race Results")

    repeat(rounds) {
        // Move each car forward if random number >= 4
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.position++
            }
        }

        // Print the race status for the current round
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    // Determine and print the winner(s)
    val highest = cars.maxOf { it.position }
    val winners = cars.filter { it.position == highest }.map { it.name }
    println("Winners : ${winners.joinToString(", ")}")
}