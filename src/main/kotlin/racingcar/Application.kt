package racingcar
import camp.nextstep.edu.missionutils.Console

fun setCarData(input: String): MutableMap<String, String> {
    val carsList = input.split(",")
    val carsMap: MutableMap<String, String> = mutableMapOf()

    for (car in carsList) {
        carsMap[car] = ""
    }
    return carsMap
}

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput: String = Console.readLine()
    validateCarsInput(input = carNamesInput)

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    validateRoundsInput(input = roundsInput)

    var rounds: Int = roundsInput.toInt()
    val cars: MutableMap<String, String> = setCarData(carNamesInput)
}
