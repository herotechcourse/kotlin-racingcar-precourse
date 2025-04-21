package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

/**
 * Represent cars running in car racing simulation
 * Output status including [name] and [distance]
 * Manage movement of car and edit [distance]
 */
class Car(val name: String, var distance: Int) {

    /** Move car forward and increase [distance] if random number is 4 or greater */
    fun simulateRound() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }

    /** Output [name] and [distance] to display status */
    fun printStatus() {
        print("$name : ")
        repeat(distance) {
            print("-")
        }
        println()
    }
}