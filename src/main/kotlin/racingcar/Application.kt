import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Car racing game coming soon!")
    promptForCars()
}

data class Car(val name: String)

fun promptForCars(): String {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    return input
}