package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {


    /**
     * 1) The user should be able to specify car names and the number of rounds.
     * - Car names should be comma-separated when entered by the user.
     * - Each car must have a name, and names cannot exceed 5 characters.
     */

    println("Enter the names of the cars (comma-separated):")
    val list = Console.readLine().split(",").map { it.trim() }
    for (item in list) {

        /**
         * 6) If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.
         */
        if (item.count() > 5) {
            throw IllegalArgumentException()
        }
    }

    val gameSet = list.map {
        Game(playerName = it, runCount = 0)
    }


    println("How many rounds will be played?")
    val roundNumber = Console.readLine().toInt()

    println("Race Results")

    val winnerList = playGame(gameSet, roundNumber)
    println("Winners : ${winnerList.joinToString(", ")}")
}


fun playGame(gameSet: List<Game>, roundNumber: Int): List<String> {

    for (i in 1..roundNumber) {
        for (play in gameSet) {
            val num = Randoms.pickNumberInRange(0, 9)

            /**
             * 2) Each of the n cars can either move forward or stay still during a given number of rounds.
             * 3) A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
             */
            if (num >= 4) {
                play.runCount += 1
            }

            /**
             * 4) When printing the progress of each car, display the car's name alongside its movement.
             */
            val runCount:String = getRunCount(play.runCount)
            println("${play.playerName} : $runCount")
        }
        println()
    }

    return findWinner(gameSet)
}

fun findWinner(gameSet: List<Game>): List<String> {
    /**
     * 5) After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
     * - If there are multiple winners, their names should be displayed and separated by commas.
     */
    val maxCount = gameSet.maxOfOrNull { it.runCount }
    val winnerList = gameSet.filter { it.runCount == maxCount }
        .map { it.playerName }

    return winnerList
}

fun getRunCount(count: Int): String {
    return "-".repeat(count)
}