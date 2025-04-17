package racingcar.handler

import camp.nextstep.edu.missionutils.Console

object InputHandler {
    fun getValidatedCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        
        val input = Console.readLine().trim()
            require(input.isNotBlank()) { "Input must be entered" }
        

        val names = input.split(",").map { it.trim() }
            require(names.distinct().size == names.size) { "Car names must be unique." }
            require(names.all { it.matches(Regex("^[A-Za-z_]{1,5}$")) }) { 
                "Car names must contain only letters or underscores and be 1 to 5 characters long." 
            }
            
        return names
    }

    fun getValidatedRoundCount(): Int {
        println("How many rounds will be played?")
        
        val input = Console.readLine()
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("Input must be a number.")
            require(count > 0) { "Round count must be a positive integer." }

        return count
    }
}
