package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>, private val round: Int) {
    data class Process(val carName: String, var movement: String)

    fun play() {

        val process = cars.map { Process(it.carName, "") }

        repeat(round) {
            cars.forEach { car ->
                if (goingForward()) process.find { proc -> proc.carName == car.carName }?.apply {
                    movement += "-"
                }
            }
            printProcess(process)
        }
        //after the loop, calculate who's the winner(s)
        //print winner(s)

    }

    private fun goingForward(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    private fun printProcess(process: List<Process>) {
        process.forEach { proc -> println("${proc.carName} : ${proc.movement}") }
        println()
    }
}
