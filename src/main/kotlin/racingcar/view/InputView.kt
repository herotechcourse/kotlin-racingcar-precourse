package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    //입력만 받고 넘겨줌 포워더 역할

    /*
    * input cars name from user
    * e.g : pobi,woni,jun
    */
    fun inputCarNames(): List<String>{
        println("Enter the names of the cars to race (separate names with commas (,))")
        val carNameInput = Console.readLine()
        val carNames = carNameInput.split(",").map{it.trim()}
        InputValidator.validateCarNames(carNames)
        return carNames
    }

    // input the num of rounds
    fun inputRoundCount(): Int {
        print("Enter the number of rounds : ")
        val roundCountInput = Console.readLine()
        return InputValidator.validateRound(roundCountInput)
    }
}