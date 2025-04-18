package racingcar

fun main() {
    println("Enter the names of the cars(comma-separated):")
    val input = readLine() ?:""
    val splitNames = input.split(",", ignoreCase = true, limit = 0) //delimiter can be "," or ", "
    val names = ArrayList<String>()

    println("How many rounds will be played?")
    val numberOfRounds :Int = readLine()?.toInt() ?: 0
    println(numberOfRounds)

    for(i in splitNames.indices){
        val carName = splitNames[i].removeWhitespaces()
        names.add(carName)
    }
    println(names)
}

//Function to remove Whitespaces
fun String.removeWhitespaces() = replace(" ", "")
