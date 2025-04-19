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
    println(numberOfRounds)

    for(i in splitNames.indices){
        val carName = splitNames[i].removeWhitespaces()
        names.add(carName)
    }
    //println(names)
}

//Function to remove Whitespaces
fun String.removeWhitespaces() = replace(" ", "")

class Car(val carName:String, val rounds:Int) {
    private var speed :Int = 0
    private var movement = ArrayList<Char> (rounds)
    var displacement = 0

    private fun getSpeed() {
        speed = Randoms.pickNumberInRange(0, 10)
    }

    fun moveCar() {
        getSpeed()
        if (speed >= 4) {
            movement.add('-')
        }
        println(movement.joinToString(""))
    }
}