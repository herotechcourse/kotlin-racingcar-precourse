package racingcar
import camp.nextstep.edu.missionutils.Console

fun getNAmes(): List<String> {
    print("Please enter names of the cars separated by comma: ")
    val cars = Console.readLine()

    val cleanNames = cars.split(",").map { it.trim() }

    if (cleanNames.isEmpty() || cleanNames.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("All cars must have a name up to 5 characters each")
    }

    return cleanNames
}


fun testest(wat : String) {
    println("wat I want is $wat")
}

fun main() {
    println("Hello, world")


    val Name: String = "Sara"
    val Surname: String = " Kim"
    var combine: String = Name + Surname
    val age: Int = 39
    println(combine)

    var team = mutableListOf("rob", "bob", "log")
    testest(wat = "bass")

    println("The full name is $combine and age is $age")
    println(team)
    team.add("cog")
    println(team)

    val carros = getNAmes()
    print("$carros")

}