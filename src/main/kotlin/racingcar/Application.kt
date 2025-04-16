package racingcar

fun main() {

    val carNamesInput = readCarNamesInput()

}

fun readCarNamesInput(): String {
    println("Enter the names of the cars (comma-separated):")
    return readln()
}
