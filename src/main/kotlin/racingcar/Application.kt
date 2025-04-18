package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program
    // prompt user input for the car names and number of rounds
    println("Enter the names of the cars (comma-separated):")
    val carName = Console.readLine()
    println("How many rounds will be played?")
    val rounds = Console.readLine()

    val names = carName.split(",")
    for (name in names) {
        try {
            validateInput(name)
        } catch (e: IllegalArgumentException) {
            println("Error: ${e}")
        }
    }

    var num = Randoms.pickNumberInRange(0, 9)
    if(num >= 4) {
        println("-")
    }
}

fun validateInput(name: String): Boolean {
    // names cannot exceed 5 characters
    if(name.length > 5) {
        throw IllegalArgumentException("Car name '$name' is too long. Max 5 characters allowed.")
    }
    return true
}