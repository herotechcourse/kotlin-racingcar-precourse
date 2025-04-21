package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {


    /**
     * 1) The user should be able to specify car names and the number of rounds.
     * 2) Car names should be comma-separated when entered by the user.
     * 3) Each car must have a name, and names cannot exceed 5 characters.
     */

    println("Enter the names of the cars (comma-separated):")
    val list = Console.readLine().split(",") //todo 공백제거
    for(item in list){
        if (item.count()>5){
            throw IllegalArgumentException()
        }
    }

    val gameSet = list.map {
        Game(playerName = it, runCount = 0)
    }


    println("How many rounds will be played?")
    val roundNumber = Console.readLine().toInt()


    val winnerList = playGame(gameSet, roundNumber)
    println("Winners : ${winnerList.joinToString(", ")}")
}


fun playGame(gameSet: List<Game>, roundNumber: Int): List<String> {

    println("Race Results")

    for (i in 1..roundNumber){

        for (play in gameSet){
            val num = Randoms.pickNumberInRange(0,9)

            if(num>4){
                play.runCount+=1

            }
            print("${play.playerName}: ")
                printRunCount(play.runCount)
            println()
        }
        println()
    }



    val maxCount = gameSet.maxOfOrNull { it.runCount }
    val winnerList = gameSet.filter { it.runCount == maxCount }
        .map { it.playerName }

    return winnerList
}

fun printRunCount(count: Int){
    for (i in 1..count){
        print("-")
    }
}