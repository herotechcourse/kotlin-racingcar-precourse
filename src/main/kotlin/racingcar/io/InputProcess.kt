package racingcar.io

import camp.nextstep.edu.missionutils.Console


class InputProcess {

    fun readInput(): String {
        return Console.readLine()
    }

    fun processCarName():List<String>{
        val input = readInput()
        val names = input.split(",")
            .map{it.trim()}

        names.forEach {validateCarNameExist(it)}

        return names
    }

    fun validateCarNameExist(str:String){
        require(str.isNotEmpty()) {"Car names cannot be empty"}
    }

}