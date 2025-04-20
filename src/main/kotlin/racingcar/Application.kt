package racingcar

class Game() {
    var round: Int = 0
    // Get car input
    fun nameInput(): List<String>{
        println("Enter the names of the cars (comma-separated):")
        val input = readLine()!!
        return input.trim().split(",")
    }

    // Get number of rounds input
    fun roundInput() {
        println("How many rounds will be played?")
        val input = readLine()!!
        round=input.toInt()
    }
}

fun main() {

}


