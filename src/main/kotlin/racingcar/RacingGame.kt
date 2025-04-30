package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    var list : List<Car> = mutableListOf<Car>()

    fun run(){
        //이거 예외만 던져주면 되는건가

        list = inputCars()



        val count = inputCout()
        require(count>0){throw IllegalArgumentException("횟수작음")}
        println("실행 결과")
        startGame(count = count)
        val winners = getWinners()
        printWinners(winners)
    }
    fun printWinners(winners: List<Car>) {
        val string = winners.joinToString(", ") { c -> c.name }
        list.map { it.printInfo() }
        println("Winners : $string")
    }
    fun startGame(count : Int){
        for (i in 0 until count) {
           list.map {
                val dice = Randoms.pickNumberInRange(0,9)
                if(isMove(dice))it.goForward()
                it.printInfo()

            }
            println()
        }
    }
    fun getWinners() : List<Car> {
        val maxValue = list.maxOf { it.position }
        val winners = list.filter { it.position == maxValue }
        return winners
    }
    fun isMove(number : Int) : Boolean {
        return number >= 4
    }
    fun inputCars() : List<Car>{
        val list = mutableListOf<Car>()

        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = Console.readLine()
        input.split(",").map {
            it.trim()
            if(validString(it)) {
                list.add(Car(name = it))
            }
            else throw IllegalArgumentException("이름 터짐")
        }
        return list
    }
    fun inputCout() : Int {
        print("시도할 횟수는 몇 회인가요>")
        val input = Console.readLine()
        //TODO 자체예외가 있는데 따로 처리해야하는가
        val count = input.trim().toInt()
        return count
    }
    fun validString(string : String) : Boolean {
        if(string.length>5)
            return false
        if(string == "")
            return false
        return true
    }

    /*
    * 입력후
    *
    *
    *
    *
    *
    *
    *
    * */
}