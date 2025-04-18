package racingcar

fun main() {
    print("Names of the cars (comma-separated): ")
    val cars = readln().split(",").map { it.trim() }
    println(cars)

    print("Number of rounds: ")
    val rounds = readln().toIntOrNull()
    print(rounds)
}
