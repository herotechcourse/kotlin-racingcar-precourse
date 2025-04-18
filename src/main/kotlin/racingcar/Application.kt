package racingcar

fun main() {
    var carNames: List<String> = listOf()

    while (true) {
        print("Names of the cars (comma-separated): ")
        val input = readLine()?.trim() ?: ""

        carNames = input.split(",").map { it.trim() }

        val invalidNames = carNames.filter { it.length > 5 }

        break
    }

    print("Number of rounds: ")
    val rounds = readLine()!!.toInt()
}


