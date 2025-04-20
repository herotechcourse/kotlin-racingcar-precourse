package racingcar


import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated, max 5 characters):")
    val input = Console.readLine()
    return input.split(",").map { it.trim() }.also { names ->
        require(names.all { it.isNotBlank() && it.length <= 5 }) {
            "All car names must be non-empty and at most 5 characters long."
        }
    }
}


