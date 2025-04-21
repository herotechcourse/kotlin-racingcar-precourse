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
    val list = Console.readLine().split(",")
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


    playgame(gameSet, roundNumber)
}

data class Game(
    val playerName: String,
    var runCount: Int,
)


fun playgame(gameSet: List<Game>, roundNumber: Int): String {

    println(" Race Results")

    for (i in 1..roundNumber){
        println("$i 번째입니다.")

        for (play in gameSet){
            val num = Randoms.pickNumberInRange(0,9)
            println("${play.playerName} 의 $i 번째 턴 결과는 $num")


            if(num>4){
                println("전진하세요")
                play.runCount+=1

            }
            print("${play.playerName}: ")
                printRunCount(play.runCount)
            println()
        }
        println()
    }

    return gameSet.maxByOrNull { it.runCount }?.playerName.toString()
}

fun printRunCount(count: Int){
    for (i in 1..count){
        print("-")
    }
}