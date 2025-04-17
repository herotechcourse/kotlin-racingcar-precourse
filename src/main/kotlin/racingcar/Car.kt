package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Car (val name:String){
    var movesForward = 0
        private set

    private fun printCar(){
        println("$name : ${"-".repeat(movesForward)}")
    }

    fun runRound(){
        val rand = Randoms.pickNumberInRange(0, 9)
        if (rand >= 4)
            ++movesForward
        printCar()
    }
}