package racingcar

fun main() {
    println("Names of the cars (comma-separated):")
    val cars = readln().split(",").map { require(it.trim().length <= 5) { "Each name should be up to 5 characters"} }
    println(cars)

    println("How many rounds will be played?")
    val rounds = readln().toIntOrNull()
    require(rounds != null) {"The number of rounds should be a valid number"}
    print(rounds)
}
