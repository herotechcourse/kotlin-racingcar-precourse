package racingcar

fun main() {
    // TODO: Implement the program
}


object InputController {
    fun readNamesOfCars(): List<String>? {
        return readlnOrNull()?.split(",")
    }

    fun readRounds(): Int? {
        return readlnOrNull()?.toInt()
    }
}