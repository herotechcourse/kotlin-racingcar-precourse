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
}
