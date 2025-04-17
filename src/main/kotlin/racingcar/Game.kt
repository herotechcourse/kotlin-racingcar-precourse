package racingcar
import camp.nextstep.edu.missionutils.Console

class Game{
    private val cars: MutableList<Car> = mutableListOf()
    private var numberOfRounds:Int = 0

    // read input, check for errors
    private fun initGame() {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        if (input.isNullOrEmpty()) throw IllegalArgumentException("No input with names provided")
        val names = input.split(',')
        for (name in names){
            if (name.length > 5) throw IllegalArgumentException("Incorrect name: $name")
            cars.add(Car(name))
        }
        println("How many rounds will be played?")
        numberOfRounds = Console.readLine().toInt()
        if (numberOfRounds < 1)
            throw IllegalArgumentException("Less than one round")
    }

    // main game loop: inits the game: prints start message, runs the number of rounds entered y user,
// prints result message
    fun runGame(){
        initGame()
        println("\nRace Results")
        for (i in 1..numberOfRounds){
            for(car in cars)
                car.runRound()
            println()
        }
        println("Winners : ${getWinner().joinToString (", ") { it.name } }")
    }

    //gets the biggest result and forms the list of cars that finished with this result
    private fun getWinner():List<Car>{
        val topResult = cars.maxOf{it.movesForward}
        val winners = cars.filter{it.movesForward == topResult}
        return winners
    }
}
