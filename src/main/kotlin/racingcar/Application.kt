package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program
    val carNames = readNames
    
}

fun readNames() : List<String> {
    println("Enter the names of the cars (comma-seperated): ")
    val input = Console.readLine()
    val names = input.split(",").map {it.trim() }

    if(names.isEmpty()) {
        throw IllegalArgumentException("car names need to be entered")
    }
    names.forEach {
        if(it.isEmpty() || it.length > 5){
            throw IllegalArgumentException("each car names must be 1 to 5 characters long")
        }
    }
    return names;
}