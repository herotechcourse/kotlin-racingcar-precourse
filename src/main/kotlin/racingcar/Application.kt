package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main()
{
    //Read car names and number of rounds from user
    println("Enter the names of the cars (comma-separated):")
    val carNames = readLine()
    var names = SeparateCarNames(carNames)

    println("How many rounds will be played?")
    val rounds = Console.readLine()
    println("Number of rounds: $rounds")

    //Car racing logic
    racing_func(names,rounds)
}

//This function is where the car racing is programmed
fun racing_func(names:List<String>,rounds:String)
{
    val size = names.size //size = number of cars
    // carPos shows the car name and its position at each round.
    var carPos = mutableMapOf<String, String>()
    for(i in 0 until size){
        carPos[names[i]] = ""
    }
    println("Race Results")
    for (i in 0 until rounds.toInt()) {
        carPos = Calculate_Car_Position(carPos,size,names)
        //Print each round results
        PrintRoundResults(carPos)
        println()
    }
    /* Each car's position has one or more '-', so now let's count the number of '-'
    to know the rank of the car */
    for (key in carPos.keys) {
        carPos[key] = carPos[key]?.count().toString()
    }
    //Get the winners
    GetRaceWinners(carPos)
}

//Get the top scorer from the cars. Print all the car names that have the max value
fun GetRaceWinners(carPos: MutableMap<String, String>){
    val maxValue = carPos.values.maxOfOrNull { it.toInt() }

    //Filter all entries that match the max value
    val topScorers = carPos.filter { it.value.toInt() == maxValue }

    //Print winners
    if (topScorers.isNotEmpty()) {
        print("Winners : ")
        val winners = topScorers.keys.joinToString(", ")
        println("$winners")
    }
}

//This function prints every round results
fun PrintRoundResults(carPos:MutableMap<String, String>) {
    for (key in carPos.keys) {
        println(key + " : " + carPos[key])
    }
}

//Position is calculated as :
//     A random number for each car is generated. If the random number
//     is greater that 4, that car moves one step forward. So, in the
//     position for that car, a '-' id appended.
fun Calculate_Car_Position(carPos: MutableMap<String, String>, size:Int,names:List<String>) : MutableMap<String, String>{
    for(j in 0 until size) {
        val no = Randoms.pickNumberInRange(0, 9)
        if (no >= 4) {
            carPos[names[j]] = carPos[names[j]] + '-' //append a '-' if number is greater than or equal to 4
        }
    }
    return carPos
}

//Separate names into list of strings based on "," as delimiter
fun SeparateCarNames(carNames:String?) : List<String>
{
    val names = carNames!!.split(",")
    return names
}