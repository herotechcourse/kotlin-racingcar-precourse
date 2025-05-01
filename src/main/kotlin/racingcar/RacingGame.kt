package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    var vehicleList : List<Vehicle> = mutableListOf()

    fun run(){
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        vehicleList = inputVehicles()

        print("시도할 횟수는 몇 회인가요>")
        val count = inputCount()
        println("실행 결과")
        startGame(count = count)

        val winners = getWinners()
        Output.printVehicleScores(vehicles = vehicleList)
        Output.printVehicleWinners(winners)
    }


    private fun inputVehicles() : List<Vehicle> {
        val input = Console.readLine()
        val list = Input.nameToEntity<Car>(input)

        return list
    }

    private fun inputCount() : Int {
        val input = Console.readLine()
        val count = input.trim().toInt()
        require(count>0){throw IllegalArgumentException(myConstErrorMessage.WRONG_CONT)}

        return count
    }

    private fun getWinners() : List<Vehicle> {
        val maxValue = vehicleList.maxOf { it.position }
        val winners = vehicleList.filter { it.position == maxValue }
        return winners
    }

    private fun startGame(count : Int){

        for (i in 0 until count) {
            vehicleList.map {
                val dice = Randoms.pickNumberInRange(0,9)
                if(it.isMove(dice))it.move()
            }
            Output.printVehicleScores(vehicles = vehicleList)
            println()
        }
    }

}
