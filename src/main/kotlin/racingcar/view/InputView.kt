package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarName(): List<String> {
        print("Enter the names of the cars (comma-separated):\n")
        val players = Console.readLine() ?: ""
        return enrollCars(players)
    }
}

fun readRoundCount(): Int {
    print("How many rounds will be played?\n")
    val rounds = Console.readLine() ?: ""
    println()
    return rounds.toInt()
}

fun enrollCars(players: String): List<String> {
    return players.split(",").map {
        val name = it.trim()
        if (name.length > 5) throw IllegalArgumentException("Car name '$name' is too long. Max 5 characters allowed.")
        name
    }
}
