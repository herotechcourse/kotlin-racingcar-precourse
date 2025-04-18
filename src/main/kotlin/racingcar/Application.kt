package racingcar

fun main() {
    try {
        val start = CarRacing()
        start.race()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}