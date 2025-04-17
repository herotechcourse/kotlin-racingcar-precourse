package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program

    // Interactive form for user's car name input:
    println("Welcome to Racing Cars! Enter the car names that will compete together(comma-separated):")
    val cars = Console.readLine()
    println("The competitors are: $cars")

    // Interactive form for the number of round the race should take:
    println("Now, choose how many rounds the competitors should run:")
    val rounds = Console.readLine()
    println("The competitors will run $rounds rounds")
}
