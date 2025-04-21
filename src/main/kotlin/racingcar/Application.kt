package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car( val name: String, var position : Int = 0 )

fun getNames(): List<String> {
    println("Please enter names of the cars separated by comma: ")

    // Read input, split by comma, trim whitespace from each name
    val cars = Console.readLine().split(",").map { it.trim() } // learned I can use split method and map on the same variable

    // Validate: names must not be empty and must be 5 chars max
    if (cars.isEmpty() || cars.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("All cars must have a name up to 5 characters each")
    }
    return cars
}

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

    repeat(rounds) {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.position++
            }
            //TODO: print progress
        }
    }

        //TODO: print winner(s)

    cars.forEach { car: Car ->
        println("${car.name} has position ${car.position}")
    }

}