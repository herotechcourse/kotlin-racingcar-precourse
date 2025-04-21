package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

// program entry to start carRacing
fun main() {
    val racingGame = RacingGame()
    racingGame.start()
}

// Car class define the car name, position, how car moves
class Car(s: String) {
    val name: String = s
    private var position = 0

    // when random number equal or greater than 4, car moves
    fun move(){
        if( Randoms.pickNumberInRange(0, 9) >=4) {
            position++
        }
    }
    // get private variable position value
    fun getPosition(): Int = position

    // create the move bar according position value
    fun getRacingResult():String = "-".repeat(position)
}

// object InputValidate verify input argument
object InputValidate {

    // validate the input for rounds
    fun validateRounds(input: String): Int {

        // check rounds is integer
        val rounds = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Input rounds are not integer")
        }

        // check rounds is positive
        if (rounds <= 0)
            throw IllegalArgumentException("Input rounds are smaller or equal to zero")
        return rounds
    }

    // check car name length , duplicated car names, empty car name
    fun validateCarsName(carNames: List<String>) {

        // car names can not be the same, otherwise throw exception
        val carNamesSet = carNames.toSet()
        if(carNames.size != carNamesSet.size)
            throw IllegalArgumentException("car names can not be the same")

        // car name length greater than 5, throw exception
        carNames.forEach {
            if (it.length > 5)
                throw IllegalArgumentException("car name is more than 5 characters")
        }

        // car name list is empty, throw exception
        if(carNames.isEmpty())
            throw IllegalArgumentException("car names is empty")
    }
}

// RacingGame read input rounds from user to variable rounds,
// create car objects list according to car names input
// simulate racing n rounds, find the winner
class RacingGame {
    private var rounds = 0
    private lateinit var cars: List<Car>

    // function to parse input, start racing simulation, announce Winner
    fun start() {
            initialize()
            race()
            announceWinner()
    }

    // parse input argument
    private fun initialize()
    {
        cars = inputCarNameInit()
        rounds = inputRoundInit()
    }

    // parse and validate car names , return Car object list
    private fun inputCarNameInit(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val input: String = Console.readLine()

        // split the input , remove the pre and tailing space, remove car name which only contain spaces
        val carRawNames = input.split(",").map { it.trim() }.map { it.replace("\\s+".toRegex(), "") }
        val carNames = carRawNames.filter { it.isNotEmpty() }

        InputValidate.validateCarsName(carNames)

        return carNames.map { Car(it) }
    }

    // parse and validate rounds input
    private fun inputRoundInit(): Int {
        println("How many rounds will be played?")

        val round = Console.readLine()

        return InputValidate.validateRounds(round)
    }

    // function to simulate car racing
    private fun race() {
        println("Race results by round:")
        println()

        // start racing for rounds times
        repeat(rounds) {
            moveAllCars()
            printStatus()
            println()
        }
    }

    // move each car
    private fun moveAllCars() {
        cars.forEach {
            it.move()
        }
    }

    // print car position
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