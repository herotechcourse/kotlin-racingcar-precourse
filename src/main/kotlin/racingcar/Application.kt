package racingcar
import camp.nextstep.edu.missionutils.Console
fun main() {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val carNames = input.split(",").map { it.trim() }

    validateCarNames(carNames)

}

fun validateCarNames(carNames: List<String>) {
    for (name in carNames){
        if(name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException("Each car name must be 1 to 5 characters long.")
        }
    }
}
