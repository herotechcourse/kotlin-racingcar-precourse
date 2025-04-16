fun readCarNames1() : String {
    val carNames = readLine()
    if (carNames == null) {
        return ""
    }
    return carNames
}

fun readCarNames2(inputProvider: () -> String?) : String {
    val carNames = inputProvider()
    if (carNames == null) {
        return ""
    }
    return carNames
}

fun main() {
    println(readCarNames1())
    println(readCarNames2 { "pobi,woni" } )
}