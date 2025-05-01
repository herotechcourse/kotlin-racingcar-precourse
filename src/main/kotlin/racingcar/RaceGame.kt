package racingcar

import kotlin.math.max
import camp.nextstep.edu.missionutils.Randoms

class RaceGame (val playerNames: List<String>, val raceDuration: Int){
    var racers: List<RacingCar> = List(playerNames.size) {
        i -> RacingCar(playerNames[i])
    }

    fun startGame() {
        println("실행 결과")
        repeat(raceDuration) {
            proceed()
            printState()
        }
    }

    private fun proceed() {
        racers.forEach { racer ->
            racer.tryMove(Randoms.pickNumberInRange(0,9))
        }
    }

    private fun printState() {
        racers.forEach { racer ->
            racer.printState()
        }
        println("")
    }

    fun printWinner() {
        val winner : MutableList<String> = getWinnerList()

        println("Winners : ${winner.joinToString(", ")}")
    }

    private fun getWinnerList() : MutableList<String> {
        val maxDistance = calculateMaxDistance()
        val winner : MutableList<String> = mutableListOf()

        racers.forEach { racer ->
            if (racer.getDistanceTraveled() == maxDistance) {
                winner.add(racer.name)
            }
        }
        return winner
    }

    private fun calculateMaxDistance() : Int {
        var maxDistance = 0
        racers.forEach { racer ->
            maxDistance = max(maxDistance, racer.getDistanceTraveled())
        }
        return maxDistance
    }
}