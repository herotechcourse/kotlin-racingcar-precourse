package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program
}
fun getNames():List<String>{
    println("Enter the names of the cars (comma-separated):")
    val names = Console.readLine()
    val parts = names.split(",")
    return parts
}
