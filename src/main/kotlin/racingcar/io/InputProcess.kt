package racingcar.io

import camp.nextstep.edu.missionutils.Console


class InputProcess {

    fun readInput(): String = Console.readLine()

    fun processCarName():List<String>{
        val input = readInput()
        val names = input.split(",")
            .map{it.trim()}

        names.forEach {validateEmptyString(it, "Car names")}
        names.forEach {validateCarNameLength(it)}

        return names
    }
    fun processRoundNumber():Int {
        val input = readInput()
        val number = input.toIntOrNull()
        require(number != null && number>0){"Invalid round number: must be a non-negative integer and less than or equal to ${Int.MAX_VALUE}"}
        return number
    }

    fun validateEmptyString(str:String, obj:String){
        require(str.isNotEmpty()) {obj+" cannot be empty"}
    }

    fun validateCarNameLength(str:String){
        require(str.length > 5) { "Car names cannot exceed 5 characters" }
    }
}