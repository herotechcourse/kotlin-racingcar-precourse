package racingcar

import camp.nextstep.edu.missionutils.Randoms

class VehicleList {
    var list = mutableListOf<Vehicle>()
    fun addCar(vehicle: Vehicle){
        list.add(vehicle)
    }
    fun printScore(){
        list.map {
            val dice = Randoms.pickNumberInRange(0,9)
            if(isMove(dice))it.goForward()
            print("${it.getName()} : ${it.getInfo()}")
        }
        println()
    }
}