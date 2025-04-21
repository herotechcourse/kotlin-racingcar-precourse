package racingcar

import camp.nextstep.edu.missionutils.Randoms



class CarRace() {
    private val randomGenerator:RandomGenerator = RandomImpl()
    fun run(carList: List<String>,roundCnt: String): MutableMap<String, String> {
        var roundResult= mutableMapOf<String,String>()
        var carDirect=carRace(carList)
        val roundCntToInt=roundCnt.toInt()
        val result=Display()

        carDirect.forEach{
            roundResult[it.key] = ""
        }
        for(i in 0 until roundCntToInt){
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

    fun eachCar() :String{
        return move(randomGenerator.randoms())
    }

    fun move(randomNumber: Int):String{
        if(randomNumber>=4)
            return "MOVING_FORWARD"
        else
            return "STOP"
    }

    fun explainRace(carDirect:Map<String,String>, roundResult:MutableMap<String,String>) : MutableMap<String,String>{
        carDirect.forEach {
            roundResult[it.key]+=checkDirect(it.value)
        }
        println()
        return roundResult
    }
    fun checkDirect(direct: String): String{
        if (direct == "MOVING_FORWARD") {
            return "-"
        }
        return ""
    }


}


