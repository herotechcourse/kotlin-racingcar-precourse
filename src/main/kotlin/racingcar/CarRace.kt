package racingcar

import camp.nextstep.edu.missionutils.Randoms


class CarRace {
    fun run(carList: List<String>,roundCnt: Int): MutableMap<String, String> {
        var roundResult= mutableMapOf<String,String>()
        var carDirect=carRace(carList)
        val result=Display()

        carDirect.forEach{
            roundResult[it.key] = ""
        }
        for(i in 0 until roundCnt){
            roundResult=explainRace(carDirect,roundResult)
            result.printRound(roundResult)
            carDirect=carRace(carList)
        }
        return roundResult
    }


    fun carRace(carList:List<String>): MutableMap<String,String>{ //Call carRandomNumber pick function

        val carDir = mutableMapOf<String,String>()
        for (car in carList){
            carDir[car] = eachCar()
        }

        return carDir
    }

    fun eachCar(): String {

        val randomNum= Randoms.pickNumberInRange(0,9)
        return if (randomNum>=4)
        {
            "MOVING_FORWARD"
        }
        else{
            "STOP"
        }
    }

    fun explainRace(carDirect:Map<String,String>,roundResult:MutableMap<String,String>) : MutableMap<String,String>{
        carDirect.forEach {
            roundResult[it.key]+=forwardDirect(it.value)
        }
        println()
        return roundResult
    }

    fun forwardDirect(direct: String): String{
        if (direct == "MOVING_FORWARD") {
            return "-"
        }
        return ""
    }


}