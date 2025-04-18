package racingcar


import camp.nextstep.edu.missionutils.Console;


fun main() {
    println("Enter the names of the cars (comma-separated):")
    val cars = Console.readLine().split(",").map(::Car)
    println("How many rounds will be played?")
    var gameInput = Input(cars, Console.readLine().toInt())
    Game(gameInput).run()
}