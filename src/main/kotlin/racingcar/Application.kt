package racingcar

fun main() {
    // TODO: Implement the program

}

fun getCarNames(): List<String> {
    var isFinished = false;

    do {
        println("Enter car names, must be separated by commas!:")
        val carNamesInput = readLine()?.trim() ?: continue
        val carNames = carNamesInput.split(",").map { it.trim() }

        if(carNames.all { it.isNotEmpty() && it.length <= 5 }) {
            return carNames
        } else {
            throw IllegalArgumentException()
        }

    } while (!isFinished)
}
