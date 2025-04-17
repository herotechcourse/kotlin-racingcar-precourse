package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val racingGame = RacingGame()
    racingGame.start()
}

class Car(s: String) {
    val name: String = s
    private var position = 0

    fun move(){
        if( Randoms.pickNumberInRange(0, 9) >=4) {
            position += 1
        }
    }
    fun getPosition(): Int = position
    fun getRacingResult():String = "-".repeat(position)
}

object InputValide {

    fun valideRound(input: String): Int {
        val round = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }

        if (round <= 0)
            throw IllegalArgumentException()
        return round
    }

    fun valideCarsName(carNames: List<String>) {

        carNames.forEach {
            if (it.length > 5)
                throw IllegalArgumentException()
        }

        if(carNames.isEmpty())
            throw IllegalArgumentException()
    }
}

class RacingGame {
    private var rounds = 0
    private lateinit var cars: List<Car>

    fun start() {

            initialize()
            race()
            announceWinner()
    }

    private fun initialize()
    {
        cars = inputCarNameInit()
        rounds = inputRoundInit()

    }

    private fun inputCarNameInit(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val input: String = Console.readLine()
        val carRawNames = input.split(",").map { it.trim() }.map { it.replace("\\s+".toRegex(), "") }
        val carNames = carRawNames.filter { it.isNotEmpty() }

        InputValide.valideCarsName(carNames)

        return carNames.map { Car(it) }
    }

    private fun inputRoundInit(): Int {
        println("How many rounds will be played?")

        val round = Console.readLine()

        return InputValide.valideRound(round)
    }


    private fun race() {
        println("Race results by round:")
        println()
        repeat(rounds) {
            moveAllCars()
            printStatus()
            println()
        }
    }

    private fun moveAllCars() {
        cars.forEach {
            it.move()
        }
    }

    private fun printStatus() {

        cars.forEach {
            println("${it.name} : ${it.getRacingResult()}")
        }
    }

    private fun announceWinner() {
        val maxScore = cars.maxOf { it.getPosition() }

        val winners = cars.filter { it.getPosition() == maxScore }

        println("Winners : " + winners.joinToString(", ") { it.name })
    }
}