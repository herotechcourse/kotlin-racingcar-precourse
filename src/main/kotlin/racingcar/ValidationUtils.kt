package racingcar

import java.lang.IllegalArgumentException

fun validateCarNames(input: String){
    require(input.isNotBlank()){"Car names cannot be blank"}
    input.split(",").forEach {
        val name = it.trim()
        require(name.isNotEmpty()) {"Car names cannot be empty"}
        require(name.length <= 5) {"Car names cannot exceed 5 char"}
    }
}

fun validateRounds(input: String): Int{
    val rounds = input.toIntOrNull()
        ?: throw IllegalArgumentException("Round count must be an Integer")
    require(rounds > 0) {"Round count must be a positive"}
    return rounds
}