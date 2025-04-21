package racingcar

fun main() {
    val names = readln().split(",").map { it.trim() }
    if (names.any {!it.matches(Regex("^[A-Za-z]+$")) || it.length > 5 }) {
        throw IllegalArgumentException("Invalid name")
    }
}
