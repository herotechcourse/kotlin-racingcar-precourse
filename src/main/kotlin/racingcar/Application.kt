package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars(comma-separated):")
    val input = Console.readLine()
    val splitNames = input.split(",", ignoreCase = true, limit = 0) //delimiter can be "," or ", "
    val names = ArrayList<String>()

    println("How many rounds will be played?")
    val numberOfRounds :Int = Console.readLine().toInt()
    //println(numberOfRounds)

    for(i in splitNames.indices){
        val carName = splitNames[i].removeWhitespaces()
        names.add(carName)
    }
    //println(names)

    val cars = names.map { Car(it) }
    val race = Race(cars, numberOfRounds)
    race.startRace()
}

//Function to remove Whitespaces
fun String.removeWhitespaces() = replace(" ", "")

fun calculateWinners(cars: List<Car>) {
    print("Winners : ")
    val maxDisplacement = cars.maxOf { it.displacement }
    val winners = mutableListOf<String>()
    for (car in cars) {
        if (car.displacement == maxDisplacement) {
            winners.add(car.carName)
        }
    }
    println(winners.joinToString(", "))
}

class Race (private val cars: List<Car>, private val numberOfRounds: Int){
    fun startRace() {
        println("Race Results")
        for (round in 1..numberOfRounds) {
            for (car in cars) {
                car.moveCar()
            }
            println()
        }
        calculateWinners(cars)
    }
}

class Car(val carName:String) {
    private var speed :Int = 0
    private val movement = mutableListOf<Char>()
    var displacement = 0

    private fun getSpeed() {
        speed = Randoms.pickNumberInRange(0, 9)
    }

    fun moveCar() {
        getSpeed()
        if (speed >= 4) {
            movement.add('-')
            displacement++
        }
        println("$carName : ${movement.joinToString("")}")
    }
}