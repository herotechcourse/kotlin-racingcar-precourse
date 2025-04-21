package racingcar.models

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var distance: Int) {

    fun simulateRound() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }

    fun printStatus() {
        print("$name : ")
        repeat(distance) {
            print("-")
        }
        println()
    }
}