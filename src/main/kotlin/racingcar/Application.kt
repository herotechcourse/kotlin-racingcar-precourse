package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program
    getUserName()
    getRoundNumber()
}
fun getUserName():List<String>{
    println("Enter the names of the cars (comma-separated):")
    val userInput = Console.readLine()
    var carsName = userInput.split(",")
    carsName.forEach{
        if (it.length>5)
            throw IllegalArgumentException("names cannot exceed 5 characters!")
        if (it.isBlank())
            throw IllegalArgumentException("each car needs a name!")
    }
    return carsName
}
fun getRoundNumber():Int{
    println("How many rounds will be played?")
    try {
        val userInput = Console.readLine()
        val numberOfRounds = Integer.parseInt(userInput)
        return numberOfRounds
    }catch (e:Exception){
        throw IllegalArgumentException("You entered invalid number!")
    }
}