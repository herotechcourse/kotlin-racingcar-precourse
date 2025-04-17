package racingcar
import camp.nextstep.edu.missionutils.Console

fun main()
{
    //Read car names and number of rounds from user
    println("Enter the names of the cars (comma-separated):")
    val carNames = readLine()
    SeparateCarNames(carNames)

    println("How many rounds will be played?")
    val rounds = Console.readLine()
    println("Number of rounds: $rounds")

}

//Separate names into list of strings based on "," as delimiter
fun SeparateCarNames(carNames:String?){
    val names = carNames!!.split(",")
    println("Car names are: $names")
}