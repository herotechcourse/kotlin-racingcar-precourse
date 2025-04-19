fun readRounds1() : String {
    val rounds = readLine()
    if (rounds == null) {
        return ""
    }
    return rounds
}

fun readRounds2(inputProvider: () -> String?) : String {
    val rounds = inputProvider()
    if (rounds == null) {
        return ""
    }
    return rounds
}

fun main() {
    println(readRounds1())
    println(readRounds2 { "5" } )
}