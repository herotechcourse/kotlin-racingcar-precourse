package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Games(var challengers: String, var rounds: String) {


}

fun main() {
    // racing start introducing comment
    println("Enter the names of the cars (comma-separated):")
    val challengers = Console.readLine()
    println("How many rounds will be played?")
    val rounds = Console.readLine()

    println()
    println("Race Results")

    val challengerList = challengers.split(",") // [pobi, woni, jun]

//    Games()
    var currentRound = 0
    while (currentRound != rounds.toInt()) {
        for (i in 1..challengerList.size) {
            val diceNumber = Randoms.pickNumberInRange(0, 9)
            if (diceNumber >= 4) {
                // todo 전진한 count 저장 필요
            }
        }
    }
}
