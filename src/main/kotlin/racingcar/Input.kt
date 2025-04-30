package racingcar

import camp.nextstep.edu.missionutils.Console

object Input {
    fun <T>nameToEntity(string : String) : List<Vehicle> where T : Vehicle {
        val list = mutableListOf<Vehicle>()
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = Console.readLine()
        input.split(",").map {
            it.trim()
            if(validString(it)) {
                makeVehicle(constructor = ::Car, string = it)
            }
            else throw IllegalArgumentException("이름 터짐")
        }
        return list
    }
}


