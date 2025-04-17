package racingcar

fun main() {
    var carNames: List<String> = listOf()

    while (true) {
        print("Enter car names separated by commas (each name max 5 characters): ")
        val input = readLine()?.trim() ?: ""

        carNames = input.split(",").map { it.trim() }

        val invalidNames = carNames.filter { it.length > 5 }

        break
    }

    println("Car names: $carNames")
}


